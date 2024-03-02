package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.dto.TeamPlayerInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.controller.teaminfo.vo.TeamPlayerInfoVO;
import com.team_manage.entity.TeamInfo;

import java.util.List;

/**
 * <p>
 * 球队表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface TeamInfoService extends IService<TeamInfo> {


    /**
     * 球队信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<TeamInfoVO> pageByQry(TeamInfoQry qry);


    /**
     * 删除球队
     *
     * @param teamId 球队ID
     * @return Boolean
     */
    Boolean del(Long teamId);

    /**
     * 修改球队信息
     *
     * @param teamId      球队ID
     * @param teamInfoDTO 球队DTO
     * @return Boolean
     */
    Boolean webEdit(Long teamId, TeamInfoDTO teamInfoDTO);

    /**
     * 新增球队信息
     *
     * @param teamInfoDTO 球队DTO
     * @return Boolean
     */
    Boolean add(TeamInfoDTO teamInfoDTO);

    /**
     * 球队信息详情
     *
     * @param teamId 球队ID
     * @return WebUserVO
     */
    TeamInfoVO detail(Long teamId);

    /**
     * 球队球员列表
     *
     * @param teamId
     * @return
     */
    List<TeamPlayerInfoVO> teamPlayerList(Long teamId);

    /**
     * 球队球员新增
     *
     * @param teamId            球队ID
     * @param teamPlayerInfoDTO 球队球员信息
     * @return 成功/失败
     */
    Boolean teamPlayerAdd(Long teamId, TeamPlayerInfoDTO teamPlayerInfoDTO);

    /**
     * 球队球员移除
     *
     * @param teamPlayerId 球队球员ID
     * @return 成功/失败
     */
    Boolean teamPlayerRemove(Long teamPlayerId);

    /**
     * 球队列表
     * @return  TeamInfoVO
     */
    List<TeamInfoVO> teamList();

}
