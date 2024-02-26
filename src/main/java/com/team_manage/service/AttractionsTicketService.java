package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.attractions.dto.AttractionsTicketDTO;
import com.team_manage.controller.attractions.query.AttractionsTicketQry;
import com.team_manage.controller.attractions.vo.AttractionsTicketVO;
import com.team_manage.entity.AttractionsTicket;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 景点门票表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface AttractionsTicketService extends IService<AttractionsTicket> {

    /**
     * 分页查询景点门票
     *
     * @param qry 查询条件Qry
     * @return IPage<AttractionsTicketVO>
     */
    IPage<AttractionsTicketVO> pageByQry(AttractionsTicketQry qry);

    /**
     * 查询景点门票详情
     *
     * @param ticketId 门票ID
     * @return AttractionsTicketVO
     */
    AttractionsTicketVO detailById(Long ticketId);

    /**
     * 新增景点门票
     *
     * @param attractionsTicketDTO 景点门票DTO
     * @return Boolean
     */
    Boolean add(AttractionsTicketDTO attractionsTicketDTO);

    /**
     * 修改景点门票
     *
     * @param ticketId             门票ID
     * @param attractionsTicketDTO 景点门票DTO
     * @return Boolean
     */
    Boolean edit(Long ticketId, AttractionsTicketDTO attractionsTicketDTO);

    /**
     * 删除景点门票
     *
     * @param ticketId 门票ID
     * @return Boolean
     */
    Boolean del(Long ticketId);

    /**
     * 修改景点门票状态
     *
     * @param ticketId 门票ID
     * @param status 门票状态：1、正常 2、禁售
     * @return Boolean
     */
    Boolean status(Long ticketId, Integer status);

    /**
     * 景点门票列表
     *
     * @param qry 景点门票查询Qry
     * @return List<AttractionsTicketVO>
     */
    List<AttractionsTicketVO> list(AttractionsTicketQry qry);
}
