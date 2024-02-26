package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team_manage.common.Constant;
import com.team_manage.controller.attractions.dto.AttractionsTicketDTO;
import com.team_manage.controller.attractions.query.AttractionsTicketQry;
import com.team_manage.controller.attractions.vo.AttractionsTicketVO;
import com.team_manage.entity.AttractionsTicket;
import com.team_manage.entity.TicketRecord;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.AttractionsTicketMapper;
import com.team_manage.mapper.TicketRecordMapper;
import com.team_manage.service.AttractionsTicketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 景点门票表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class AttractionsTicketServiceImpl extends ServiceImpl<AttractionsTicketMapper, AttractionsTicket> implements AttractionsTicketService {

    /**
     * 订票记录Mapper
     */
    private final TicketRecordMapper ticketRecordMapper;

    /**
     * 分页查询景点门票
     *
     * @param qry 查询条件Qry
     * @return IPage<AttractionsTicketVO>
     */
    @Override
    public IPage<AttractionsTicketVO> pageByQry(AttractionsTicketQry qry) {
        IPage<AttractionsTicket> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(AttractionsTicket::getAttractionsId, qry.getAttractionsId())
                .like(StringUtils.isNotEmpty(qry.getTicketName()), AttractionsTicket::getTicketName, qry.getTicketName())
                .eq(ObjectUtils.isNotEmpty(qry.getTicketStatus()), AttractionsTicket::getTicketStatus, qry.getTicketStatus())
                .orderByAsc(AttractionsTicket::getTicketId)
                .page(pages);
        return CopyUtils.covertPage(pages, AttractionsTicketVO.class);
    }

    /**
     * 查询景点门票详情
     *
     * @param ticketId 门票ID
     * @return AttractionsTicketVO
     */
    @Override
    public AttractionsTicketVO detailById(Long ticketId) {
        AttractionsTicket attractionsTicket = baseMapper.selectById(ticketId);
        return CopyUtils.classCopy(attractionsTicket, AttractionsTicketVO.class);
    }

    /**
     * 新增景点门票
     *
     * @param attractionsTicketDTO 景点门票DTO
     * @return Boolean
     */
    @Override
    public Boolean add(AttractionsTicketDTO attractionsTicketDTO) {
        List<AttractionsTicket> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(AttractionsTicket::getTicketName, attractionsTicketDTO.getTicketName())
                .eq(AttractionsTicket::getAttractionsId, attractionsTicketDTO.getAttractionsId())
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("门票信息已存在,新增失败!");
        }
        // 新增门票信息
        AttractionsTicket attractionsTicket = CopyUtils.classCopy(attractionsTicketDTO, AttractionsTicket.class);
        attractionsTicket.setSoldQuantity(Constant.INTEGER_ZERO);
        return this.save(attractionsTicket);
    }

    /**
     * 修改景点门票
     *
     * @param ticketId             门票ID
     * @param attractionsTicketDTO 景点门票DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(Long ticketId, AttractionsTicketDTO attractionsTicketDTO) {
        List<AttractionsTicket> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(AttractionsTicket::getTicketName, attractionsTicketDTO.getTicketName())
                .eq(AttractionsTicket::getAttractionsId, attractionsTicketDTO.getAttractionsId())
                .ne(AttractionsTicket::getTicketId, ticketId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("门票信息已存在,修改失败!");
        }
        // 修改门票信息
        AttractionsTicket attractionsTicket = CopyUtils.classCopy(attractionsTicketDTO, AttractionsTicket.class);
        attractionsTicket.setTicketId(ticketId);
        return this.updateById(attractionsTicket);
    }

    /**
     * 删除景点门票
     *
     * @param ticketId 门票ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long ticketId) {
        List<TicketRecord> list = new LambdaQueryChainWrapper<>(ticketRecordMapper)
                .eq(TicketRecord::getTicketId, ticketId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("门票信息已被使用，无法删除!");
        }
        return this.removeById(ticketId);
    }

    /**
     * 修改景点门票状态
     *
     * @param ticketId 门票ID
     * @param status   门票状态：1、正常 2、禁售
     * @return Boolean
     */
    @Override
    public Boolean status(Long ticketId, Integer status) {
        return new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(AttractionsTicket::getTicketId,ticketId)
                .set(AttractionsTicket::getTicketStatus, status)
                .update();
    }

    /**
     * 景点门票列表
     *
     * @param qry 景点门票查询Qry
     * @return List<AttractionsTicketVO>
     */
    @Override
    public List<AttractionsTicketVO> list(AttractionsTicketQry qry) {
        // 查询景点门票列表
        List<AttractionsTicket> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(AttractionsTicket::getAttractionsId, qry.getAttractionsId())
                .orderByAsc(AttractionsTicket::getTicketStatus)
                .list();
        // 将景点门票列表放入详情VO
        return CopyUtils.classCopyList(list, AttractionsTicketVO.class);
    }
}
