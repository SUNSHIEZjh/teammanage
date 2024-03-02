package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.playscore.dto.PlayerScoreRecordDTO;
import com.team_manage.controller.playscore.query.PlayerScoreRecordQry;
import com.team_manage.controller.playscore.vo.PlayerScoreRecordVO;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.entity.PlayerScoreRecord;
import com.team_manage.entity.TeamInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface PlayScoreRecordService extends IService<PlayerScoreRecord> {


    /**
     * 修改用户信息
     *
     * @param playerScoreRecordDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(PlayerScoreRecordDTO playerScoreRecordDTO);


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<PlayerScoreRecordVO> pageByQry(PlayerScoreRecordQry qry);


    /**
     * 删除用户信息
     *
     * @param playerScoreId 用户ID
     * @return Boolean
     */
    Boolean del(Long playerScoreId);

    /**
     * 修改用户信息
     *
     * @param playerScoreId      用户ID
     * @param playerScoreRecordDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long playerScoreId, PlayerScoreRecordDTO playerScoreRecordDTO);

    /**
     * 新增用户信息
     *
     * @param playerScoreRecordDTO 用户DTO
     * @return Boolean
     */
    Boolean add(PlayerScoreRecordDTO playerScoreRecordDTO);

    /**
     * 用户信息详情
     *
     * @param playerScoreId 用户ID
     * @return WebUserVO
     */
    PlayerScoreRecordVO detail(Long playerScoreId);
}
