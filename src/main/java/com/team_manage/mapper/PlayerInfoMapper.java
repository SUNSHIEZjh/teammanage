package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.playerinfo.query.PlayerInfoQry;
import com.team_manage.controller.playerinfo.vo.PlayerInfoVO;
import com.team_manage.entity.PlayerInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface PlayerInfoMapper extends BaseMapper<PlayerInfo> {

    /**
     * 用户信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return WebUserVO
     */
    IPage<PlayerInfoVO> playerInfoPageByQry(@Param("qry") PlayerInfoQry qry, @Param("pages") IPage<PlayerInfoVO> pages);


}
