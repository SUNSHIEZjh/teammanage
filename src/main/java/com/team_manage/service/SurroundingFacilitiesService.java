package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.facilities.dto.SurroundingFacilitiesDTO;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry1;
import com.team_manage.controller.facilities.vo.SurroundingFacilitiesVO;
import com.team_manage.entity.SurroundingFacilities;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 周边设施表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface SurroundingFacilitiesService extends IService<SurroundingFacilities> {

    /**
     * 周边设施信息分页查询
     *
     * @param qry 周边设施查询Qry
     * @return IPage<SurroundingFacilitiesVO>
     */
    IPage<SurroundingFacilitiesVO> pageByQry(SurroundingFacilitiesQry qry);

    /**
     * 周边设施信息详情
     *
     * @param facilitiesId 设施ID
     * @return SurroundingFacilitiesVO
     */
    SurroundingFacilitiesVO detailById(Long facilitiesId);

    /**
     * 新增周边设施信息
     *
     * @param surroundingFacilitiesDTO 周边设施DTO
     * @return Boolean
     */
    Boolean add(SurroundingFacilitiesDTO surroundingFacilitiesDTO);

    /**
     * 修改周边设施信息
     *
     * @param facilitiesId             设施ID
     * @param surroundingFacilitiesDTO 周边设施DTO
     * @return Boolean
     */
    Boolean edit(Long facilitiesId, SurroundingFacilitiesDTO surroundingFacilitiesDTO);

    /**
     * 删除周边设施信息
     *
     * @param facilitiesId 设施ID
     * @return Boolean
     */
    Boolean del(Long facilitiesId);

    /**
     * 修改周边设施状态
     *
     * @param facilitiesId     设施ID
     * @param facilitiesStatus 设施状态：1、正常营业 2、暂停营业
     * @return Boolean
     */
    Boolean status(Long facilitiesId, Integer facilitiesStatus);

    /**
     * 周边设施信息分页查询
     *
     * @param qry 周边设施查询Qry
     * @return IPage<SurroundingFacilitiesVO>
     */
    IPage<SurroundingFacilitiesVO> pageByQry1(SurroundingFacilitiesQry1 qry);
}
