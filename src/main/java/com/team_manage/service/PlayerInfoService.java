package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.playerinfo.dto.PlayerInfoDTO;
import com.team_manage.controller.playerinfo.dto.PlayerOnDepartDTO;
import com.team_manage.controller.playerinfo.query.PlayerInfoQry;
import com.team_manage.controller.playerinfo.vo.PlayerInfoVO;
import com.team_manage.entity.PlayerInfo;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface PlayerInfoService extends IService<PlayerInfo> {


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<PlayerInfoVO> pageByQry(PlayerInfoQry qry);


    /**
     * 删除用户信息
     *
     * @param playerId 用户ID
     * @return Boolean
     */
    Boolean del(Long playerId);


    /**
     * 删除用户信息
     *
     * @param playerId 用户ID
     * @return Boolean
     */
    Boolean depart(Long playerId, PlayerOnDepartDTO playerOnDepartDTO);


    /**
     * 修改用户信息
     *
     * @param playerId      用户ID
     * @param playerInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long playerId, PlayerInfoDTO playerInfoDTO);

    /**
     * 新增用户信息
     *
     * @param playerInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(PlayerInfoDTO playerInfoDTO);

    /**
     * 用户信息详情
     *
     * @param playerId 用户ID
     * @return WebUserVO
     */
    PlayerInfoVO detail(Long playerId);

    /**
     * 用户下来
     * @return PlayerInfo
     */
    List<PlayerInfoVO> getList();
}
