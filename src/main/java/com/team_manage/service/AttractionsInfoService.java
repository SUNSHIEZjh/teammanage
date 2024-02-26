package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.attractions.dto.AttractionsInfoDTO;
import com.team_manage.controller.attractions.query.AttractionsInfoQry;
import com.team_manage.controller.attractions.query.AttractionsInfoQry1;
import com.team_manage.controller.attractions.vo.AttractionsInfoVO;
import com.team_manage.entity.AttractionsInfo;

/**
 * <p>
 * 景点信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface AttractionsInfoService extends IService<AttractionsInfo> {

    /**
     * 景点信息分页查询
     *
     * @param qry 查询条件
     * @return IPage<AttractionsInfoVO>
     */
    IPage<AttractionsInfoVO> pageByQry(AttractionsInfoQry qry);

    /**
     * 景点信息详情
     *
     * @param attractionsId 景点ID
     * @return AttractionsInfoVO
     */
    AttractionsInfoVO detailById(Long attractionsId);

    /**
     * 新增景点信息
     *
     * @param attractionsInfoDTO 景点信息操作DTO
     * @return Boolean
     */
    Boolean add(AttractionsInfoDTO attractionsInfoDTO);

    /**
     * 修改景点信息
     *
     * @param attractionsId      景点ID
     * @param attractionsInfoDTO 景点信息操作DTO
     * @return Boolean
     */
    Boolean edit(Long attractionsId, AttractionsInfoDTO attractionsInfoDTO);

    /**
     * 删除景点信息
     *
     * @param attractionsId 景点ID
     * @return Boolean
     */
    Boolean del(Long attractionsId);

    /**
     * 分页查询景点列表
     *
     * @param qry 景点查询Qry1
     * @return IPage<AttractionsInfoVO>
     */
    IPage<AttractionsInfoVO> pageByQry1(AttractionsInfoQry1 qry);

    /**
     * 修改景点开放状态
     *
     * @param attractionsId 景点ID
     * @param openingStatus 开放状态：1、正常开放 2、未开放
     * @return Boolean
     */
    Boolean status(Long attractionsId, Integer openingStatus);
}
