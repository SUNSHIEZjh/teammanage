package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.playscore.query.PlayerScoreRecordQry;
import com.team_manage.controller.playscore.vo.PlayerScoreRecordVO;
import com.team_manage.entity.PlayerScoreRecord;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 球员技术得分 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface PlayerScoreRecordInfoMapper extends BaseMapper<PlayerScoreRecord> {

    /**
     * 球员技术得分分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return PlayerScoreRecordVO
     */
    IPage<PlayerScoreRecordVO> scoreRecordPageByQry(@Param("qry") PlayerScoreRecordQry qry, @Param("pages") IPage<PlayerScoreRecordVO> pages);


}
