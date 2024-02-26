package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.user.query.FollowInfoQry;
import com.team_manage.controller.user.vo.FollowInfoVO;
import com.team_manage.entity.FollowInfo;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.FollowInfoMapper;
import com.team_manage.service.FollowInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 关注信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class FollowInfoServiceImpl extends ServiceImpl<FollowInfoMapper, FollowInfo> implements FollowInfoService {

    /**
     * 关注信息分页查询
     *
     * @param qry qry
     * @return IPage<FollowInfoVO>
     */
    @Override
    public IPage<FollowInfoVO> pageByQry(FollowInfoQry qry) {
        // 判断关注用户ID不能为空
        if (ObjectUtils.isEmpty(qry.getUserId()) && ObjectUtils.isEmpty(qry.getBeUserId())) {
            throw new ServiceException("关注人ID和被关注人ID不能同时为空!");
        }
        // 判断关注用户ID不能同时不为空
        if (ObjectUtils.isNotEmpty(qry.getUserId()) && ObjectUtils.isNotEmpty(qry.getBeUserId())) {
            throw new ServiceException("关注人ID和被关注人ID不能同时不为空!");
        }
        // 设置登录用户ID
        try {
            qry.setLoginId(StpUtil.getLoginIdAsLong());
        } catch (Exception e) {
            qry.setLoginId(Constant.LONG_ZERO);
        }
        // 创建分页类
        IPage<FollowInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        //  查询关注用户或被关注用户
        return baseMapper.pageByQry(qry, pages);
    }

    /**
     * 判断是否关注用户
     *
     * @param beUserId 被关注用户ID
     * @return FollowInfoVO
     */
    @Override
    public FollowInfoVO check(Long beUserId) {
        // 用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 判断是否关注用户
        return baseMapper.check(userId, beUserId);
    }

    /**
     * 关注用户
     *
     * @param beUserId 被关注用户ID
     * @return FollowInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FollowInfoVO follow(Long beUserId) {
        // 登录用户ID
        long userId = StpUtil.getLoginIdAsLong();
        FollowInfo one = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(FollowInfo::getUserId, userId)
                .eq(FollowInfo::getBeUserId, beUserId)
                .one();
        // 判断是否关注过用户
        if (ObjectUtils.isNotEmpty(one)) {
            throw new ServiceException("您已关注该用户，无法再次关注!");
        }
        // 组装保存关注信息
        FollowInfo followInfo = new FollowInfo().setFollowTime(new Date())
                .setUserId(userId)
                .setBeUserId(beUserId);
        this.save(followInfo);
        // 返回关注信息
        return CopyUtils.classCopy(followInfo, FollowInfoVO.class);
    }

    /**
     * 取消关注用户
     *
     * @param followId 关注ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean cancel(Long followId) {
        // 删除关注信息
        return this.removeById(followId);
    }
}
