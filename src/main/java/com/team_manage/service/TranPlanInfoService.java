package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.tranplaninfo.dto.TranPlanInfoDTO;
import com.team_manage.controller.tranplaninfo.query.TranPlanInfoQry;
import com.team_manage.controller.tranplaninfo.vo.TranPlanInfoVO;
import com.team_manage.entity.TranPlanInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface TranPlanInfoService extends IService<TranPlanInfo> {


    /**
     * 修改用户信息
     *
     * @param tranPlanInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(TranPlanInfoDTO tranPlanInfoDTO);


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<TranPlanInfoVO> pageByQry(TranPlanInfoQry qry);


    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return Boolean
     */
    Boolean del(Long userId);

    /**
     * 修改用户信息
     *
     * @param tranPlanID      用户ID
     * @param tranPlanInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long tranPlanID, TranPlanInfoDTO tranPlanInfoDTO);

    /**
     * 新增用户信息
     *
     * @param tranPlanInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(TranPlanInfoDTO tranPlanInfoDTO);

    /**
     * 用户信息详情
     *
     * @param tranPlanID 用户ID
     * @return WebUserVO
     */
    TranPlanInfoVO detail(Long tranPlanID);
}
