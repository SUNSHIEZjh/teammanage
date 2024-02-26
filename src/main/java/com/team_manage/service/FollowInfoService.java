package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.user.query.FollowInfoQry;
import com.team_manage.controller.user.vo.FollowInfoVO;
import com.team_manage.entity.FollowInfo;

/**
 * <p>
 * 关注信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
public interface FollowInfoService extends IService<FollowInfo> {

    /**
     * 关注信息分页查询
     *
     * @param qry qry
     * @return IPage<FollowInfoVO>
     */
    IPage<FollowInfoVO> pageByQry(FollowInfoQry qry);

    /**
     * 判断是否关注用户
     *
     * @param beUserId 被关注用户ID
     * @return FollowInfoVO
     */
    FollowInfoVO check(Long beUserId);

    /**
     * 关注用户
     *
     * @param beUserId 被关注用户ID
     * @return FollowInfoVO
     */
    FollowInfoVO follow(Long beUserId);

    /**
     * 取消关注用户
     *
     * @param followId 关注ID
     * @return Boolean
     */
    Boolean cancel(Long followId);
}
