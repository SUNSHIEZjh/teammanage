package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.playscore.dto.PlayerScoreRecordDTO;
import com.team_manage.controller.playscore.query.PlayerScoreRecordQry;
import com.team_manage.controller.playscore.vo.PlayerScoreRecordVO;
import com.team_manage.entity.PlayerScoreRecord;

import java.util.List;

/**
 * <p>
 * 技术得分表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface PlayScoreRecordService extends IService<PlayerScoreRecord> {


    /**
     * 技术得分信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<PlayerScoreRecordVO> pageByQry(PlayerScoreRecordQry qry);


    /**
     * 删除技术得分信息
     *
     * @param playerScoreId 技术得分ID
     * @return Boolean
     */
    Boolean del(Long playerScoreId);

    /**
     * 修改技术得分信息
     *
     * @param playerScoreId        技术得分ID
     * @param playerScoreRecordDTO 技术得分DTO
     * @return Boolean
     */
    Boolean webEdit(Long playerScoreId, PlayerScoreRecordDTO playerScoreRecordDTO);

    /**
     * 新增技术得分信息
     *
     * @param playerScoreRecordDTO 技术得分DTO
     * @return Boolean
     */
    Boolean add(PlayerScoreRecordDTO playerScoreRecordDTO);

    /**
     * 技术得分信息详情
     *
     * @param playerScoreId 技术得分ID
     * @return WebUserVO
     */
    PlayerScoreRecordVO detail(Long playerScoreId);

    /**
     * 球员得分明细
     *
     * @param playerId 球员ID
     * @return
     */
    List<PlayerScoreRecordVO> detailList(Long playerId);
}
