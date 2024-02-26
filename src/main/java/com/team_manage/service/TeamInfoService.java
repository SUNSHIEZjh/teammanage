package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.entity.TeamInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface TeamInfoService extends IService<TeamInfo> {


    /**
     * 修改用户信息
     *
     * @param teamInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(TeamInfoDTO teamInfoDTO);


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<TeamInfoVO> pageByQry(TeamInfoQry qry);


    /**
     * 删除用户信息
     *
     * @param teamId 用户ID
     * @return Boolean
     */
    Boolean del(Long teamId);

    /**
     * 修改用户信息
     *
     * @param teamId      用户ID
     * @param teamInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long teamId, TeamInfoDTO teamInfoDTO);

    /**
     * 新增用户信息
     *
     * @param teamInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(TeamInfoDTO teamInfoDTO);

    /**
     * 用户信息详情
     *
     * @param teamId 用户ID
     * @return WebUserVO
     */
    TeamInfoVO detail(Long teamId);
}
