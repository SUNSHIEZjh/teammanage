package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.order.dto.OrderTicketDTO;
import com.team_manage.controller.order.query.WebOrderQry;
import com.team_manage.controller.order.query.WxOrderQry;
import com.team_manage.controller.order.vo.OrderInfoVO;
import com.team_manage.entity.*;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.*;
import com.team_manage.service.OrderInfoService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.DateUtils;
import com.team_manage.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    /**
     * 订票记录Mapper
     */
    private final TicketRecordMapper ticketRecordMapper;

    /**
     * 订票明细Mapper
     */
    private final OrderItemMapper orderItemMapper;

    /**
     * 人员信息Mapper
     */
    private final PersonInfoMapper personInfoMapper;

    /**
     * 景点信息Mapper
     */
    private final AttractionsInfoMapper attractionsInfoMapper;

    /**
     * 景点门票Mapper
     */
    private final AttractionsTicketMapper attractionsTicketMapper;

    /**
     * 景点门票预定
     *
     * @param orderTicketDTO 预定门票DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean order(OrderTicketDTO orderTicketDTO) {
        // 查询景点信息
        AttractionsInfo attractionsInfo = attractionsInfoMapper.selectById(orderTicketDTO.getAttractionsId());
        if (ObjectUtils.isEmpty(attractionsInfo)) {
            throw new ServiceException("未查询到景点信息!");
        }
        // 查询门票信息
        AttractionsTicket attractionsTicket = attractionsTicketMapper.selectById(orderTicketDTO.getTicketId());
        if (ObjectUtils.isEmpty(attractionsTicket)) {
            throw new ServiceException("未查询到景点门票信息!");
        }
        // 获取用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 校验当天是否已经买过该景点门票
        List<TicketRecord> list = new LambdaQueryChainWrapper<>(ticketRecordMapper)
                .eq(TicketRecord::getTicketId, orderTicketDTO.getTicketId())
                .eq(TicketRecord::getOrderDate, DateUtils.dateToString2(orderTicketDTO.getOrderDate()))
                .eq(TicketRecord::getRecordStatus, Constant.INTEGER_ONE)
                .in(TicketRecord::getPersonId, orderTicketDTO.getPersonIds())
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> personIds = list.stream().map(TicketRecord::getPersonId).collect(Collectors.toList());
            List<PersonInfo> personInfoList = new LambdaQueryChainWrapper<>(personInfoMapper)
                    .in(PersonInfo::getPersonId, personIds)
                    .list();
            StringBuilder names = new StringBuilder();
            for (PersonInfo personInfo : personInfoList) {
                names.append(personInfo.getPersonName()).append("、");
            }
            throw new ServiceException(names.substring(Constant.INTEGER_ZERO, names.length() - Constant.INTEGER_ONE) + "已购买过当天该次门票，无法继续购买!");
        }
        // 组装订单表
        Long orderId = IdUtils.getLongId();
        OrderInfo orderInfo = CopyUtils.classCopy(orderTicketDTO, OrderInfo.class);
        orderInfo.setUserId(userId)
                .setOrderId(orderId)
                .setOrderNum(String.valueOf(orderId))
                .setOrderDate(orderTicketDTO.getOrderDate())
                .setOrderTime(new Date())
                .setOrderStatus(Constant.INTEGER_ONE);
        // 循环组装订单明细和订票记录信息
        for (Long personId : orderTicketDTO.getPersonIds()) {
            // 组装订单详情
            Long itemId = IdUtils.getLongId();
            OrderItem orderItem = new OrderItem()
                    .setItemId(itemId)
                    .setOrderId(orderId)
                    .setItemNum(Constant.INTEGER_ONE)
                    .setItemTotal(attractionsTicket.getTicketPrice())
                    .setTicketId(attractionsTicket.getTicketId())
                    .setPersonId(personId);
            // 保存订单详情
            orderItemMapper.insert(orderItem);
            // 组装订票记录
            TicketRecord ticketRecord = new TicketRecord()
                    .setTicketId(attractionsTicket.getTicketId())
                    .setOrderDate(orderTicketDTO.getOrderDate())
                    .setPersonId(personId)
                    .setAttractionsId(orderTicketDTO.getAttractionsId())
                    .setRecordStatus(Constant.INTEGER_ONE)
                    .setOrderId(orderId)
                    .setItemId(itemId);
            // 保存订票记录
            ticketRecordMapper.insert(ticketRecord);
        }
        // 保存订单信息
        return this.save(orderInfo);
    }

    /**
     * 我的订单信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<OrderInfoVO>
     */
    @Override
    public IPage<OrderInfoVO> mine(WxOrderQry qry) {
        // 设置登录用户ID
        qry.setUserId(StpUtil.getLoginIdAsLong());
        // 组装分页类
        IPage<OrderInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 查询并返回数据
        return baseMapper.mine(qry, pages);
    }

    /**
     * 订单信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<OrderInfoVO>
     */
    @Override
    public IPage<OrderInfoVO> pageByQry(WebOrderQry qry) {
        // 组装分页类
        IPage<OrderInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return baseMapper.pageByQry(qry, pages);
    }

    /**
     * 订单信息详情
     *
     * @param orderId 订单ID
     * @return OrderInfoVO
     */
    @Override
    public OrderInfoVO detail(Long orderId) {
        return baseMapper.detail(orderId);
    }


    /**
     * 景点门票退票
     *
     * @param orderId 订单ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean refund(Long orderId) {
        // 查询订单信息
        OrderInfo orderInfo = baseMapper.selectById(orderId);
        // 判断订单是否存在
        if (ObjectUtils.isEmpty(orderInfo)) {
            throw new ServiceException("未查询到订单信息!");
        }
        // 判断订单是否存在
        if (!Constant.INTEGER_ONE.equals(orderInfo.getOrderStatus())) {
            throw new ServiceException("订单已完成或已取消，无法退票!");
        }
        // 修改订单信息
        new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(OrderInfo::getOrderId, orderId)
                // 设置订单状态为已取消
                .set(OrderInfo::getOrderStatus, Constant.INTEGER_THREE)
                .update();
        // 将订票记录修改为已退票
        new LambdaUpdateChainWrapper<>(ticketRecordMapper)
                .eq(TicketRecord::getOrderId, orderId)
                // 设置订票记录为已取消
                .set(TicketRecord::getRecordStatus, Constant.INTEGER_TWO)
                .update();
        // 返回成功
        return true;
    }

    /**
     * 设置订单完成
     *
     * @param orderId 订单ID
     * @return Boolean
     */
    @Override
    public Boolean success(Long orderId) {
        // 修改订单信息
        return new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(OrderInfo::getOrderId, orderId)
                // 设置订单状态为已完成
                .set(OrderInfo::getOrderStatus, Constant.INTEGER_TWO)
                .update();
    }
}
