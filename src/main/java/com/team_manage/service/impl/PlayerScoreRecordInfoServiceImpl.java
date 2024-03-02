package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.playscore.dto.PlayerScoreRecordDTO;
import com.team_manage.controller.playscore.query.PlayerScoreRecordQry;
import com.team_manage.controller.playscore.vo.PlayerScoreRecordVO;
import com.team_manage.entity.PlayerScoreRecord;
import com.team_manage.mapper.PlayerScoreRecordInfoMapper;
import com.team_manage.service.PlayScoreRecordService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 技术得分 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class PlayerScoreRecordInfoServiceImpl extends ServiceImpl<PlayerScoreRecordInfoMapper, PlayerScoreRecord> implements PlayScoreRecordService {


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    @Override
    public IPage<PlayerScoreRecordVO> pageByQry(PlayerScoreRecordQry qry) {
        IPage<PlayerScoreRecordVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().scoreRecordPageByQry(qry, pages);
    }


    /**
     * 删除技术得分
     *
     * @param playerScoreId 技术得分信息ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long playerScoreId) {
        // 删除用户信息
        return this.removeById(playerScoreId);
    }

    /**
     * 修改技术得分信息
     *
     * @param playerScoreId        技术得分ID
     * @param playerScoreRecordDTO 技技术得分DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long playerScoreId, PlayerScoreRecordDTO playerScoreRecordDTO) {
        // 修改用户信息
        PlayerScoreRecord playerScoreRecord = CopyUtils.classCopy(playerScoreRecordDTO, PlayerScoreRecord.class);
        playerScoreRecord.setKeyId(playerScoreId);
        return this.updateById(playerScoreRecord);
    }

    /**
     * 新增技术得分信息
     *
     * @param playerScoreRecordDTO 技术得分DTO
     * @return Boolean
     */
    @Override
    public Boolean add(PlayerScoreRecordDTO playerScoreRecordDTO) {
        // 新增用户
        PlayerScoreRecord playerScoreRecord = CopyUtils.classCopy(playerScoreRecordDTO, PlayerScoreRecord.class);
        // 新增技术的分信息
        this.save(playerScoreRecord);
        return true;
    }

    /**
     * 技术得分信息详情
     *
     * @param playerScoreId 技术得分ID
     * @return WebUserVO
     */
    @Override
    public PlayerScoreRecordVO detail(Long playerScoreId) {
        return CopyUtils.classCopy(baseMapper.selectById(playerScoreId), PlayerScoreRecordVO.class);
    }

    /**
     * 球员得分明细
     *
     * @param playerId 球员ID
     * @return
     */
    @Override
    public List<PlayerScoreRecordVO> detailList(Long playerId) {
        return CopyUtils.classCopyList(this.baseMapper.selectList(new LambdaQueryWrapper<PlayerScoreRecord>().eq(PlayerScoreRecord::getPlayerId, playerId)), PlayerScoreRecordVO.class);
    }

}
