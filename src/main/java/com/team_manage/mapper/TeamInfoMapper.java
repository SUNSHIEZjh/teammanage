package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.entity.MatchInfo;
import com.team_manage.entity.TeamInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface TeamInfoMapper extends BaseMapper<TeamInfo> {

    /**
     * 用户信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return WebUserVO
     */
    IPage<TeamInfoVO> teamInfoPageByQry(@Param("qry") TeamInfoQry qry, @Param("pages") IPage<TeamInfoVO> pages);


}
