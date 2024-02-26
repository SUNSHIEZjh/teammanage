package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.order.dto.OrderTicketDTO;
import com.team_manage.controller.order.query.WebOrderQry;
import com.team_manage.controller.order.query.WxOrderQry;
import com.team_manage.controller.order.vo.OrderInfoVO;
import com.team_manage.entity.OrderInfo;

/**
 * <p>
 * 订单信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 景点门票预定
     *
     * @param orderTicketDTO 预定门票DTO
     * @return Boolean
     */
    Boolean order(OrderTicketDTO orderTicketDTO);

    /**
     * 我的订单信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<OrderInfoVO>
     */
    IPage<OrderInfoVO> mine(WxOrderQry qry);

    /**
     * 订单信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<OrderInfoVO>
     */
    IPage<OrderInfoVO> pageByQry(WebOrderQry qry);

    /**
     * 订单信息详情
     *
     * @param orderId 订单ID
     * @return OrderInfoVO
     */
    OrderInfoVO detail(Long orderId);

    /**
     * 景点门票退票
     *
     * @param orderId 订单ID
     * @return Boolean
     */
    Boolean refund(Long orderId);

    /**
     * 设置订单完成
     *
     * @param orderId 订单ID
     * @return Boolean
     */
    Boolean success(Long orderId);
}
