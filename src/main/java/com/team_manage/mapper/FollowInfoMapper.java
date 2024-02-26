package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.user.query.FollowInfoQry;
import com.team_manage.controller.user.vo.FollowInfoVO;
import com.team_manage.entity.FollowInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 关注信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
public interface FollowInfoMapper extends BaseMapper<FollowInfo> {

    /**
     * 关注信息分页查询
     *
     * @param qry   qry
     * @param pages pages
     * @return IPage<FollowInfoVO>
     */
    IPage<FollowInfoVO> pageByQry(@Param("qry") FollowInfoQry qry, @Param("pages") IPage<FollowInfoVO> pages);

    /**
     * 判断用户是否关注
     *
     * @param userId   登录用户
     * @param beUserId 被关注用户
     * @return FollowInfoVO
     */
    FollowInfoVO check(@Param("userId") long userId, @Param("beUserId") Long beUserId);
}
