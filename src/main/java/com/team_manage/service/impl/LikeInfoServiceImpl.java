package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.topic.dto.LikeDTO;
import com.team_manage.entity.*;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.*;
import com.team_manage.service.LikeInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 点赞信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class LikeInfoServiceImpl extends ServiceImpl<LikeInfoMapper, LikeInfo> implements LikeInfoService {

    /**
     * 话题Mapper
     */
    private final TopicInfoMapper topicInfoMapper;

    /**
     * 评论Mapper
     */
    private final CommentInfoMapper commentInfoMapper;

    /**
     * 攻略Mapper
     */
    private final IntroductionInfoMapper introductionInfoMapper;

    /**
     * 消息通知Mapper
     */
    private final NotifyInfoMapper notifyInfoMapper;

    /**
     * 用户Mapper
     */
    private final SysUserMapper sysUserMapper;

    /**
     * 点赞信息Service
     *
     * @param likeDTO 点赞DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Boolean add(LikeDTO likeDTO) {
        // 获取登录用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 查询用户信息
        SysUser user = sysUserMapper.selectById(userId);
        // 判断是否已经点过赞了
        List<LikeInfo> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(LikeInfo::getBusinessId, likeDTO.getBusinessId())
                .eq(LikeInfo::getUserId, userId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("您已经点过赞了!");
        }
        // 根据点赞类型增加点赞数量
        if (Constant.LIKE_TYPE_TOPIC.equals(likeDTO.getLikeType())) {
            // 给该话题增加一点点赞数量
            topicInfoMapper.setNum(likeDTO.getBusinessId(), Constant.INTEGER_THREE, Constant.INTEGER_ONE, Constant.INTEGER_ONE);
            // 查询帖子信息
            TopicInfo topicInfo = topicInfoMapper.selectById(likeDTO.getBusinessId());
            if (ObjectUtils.isEmpty(topicInfo)) {
                throw new ServiceException("未获取到帖子信息,可能帖子已被删除!");
            }
            // 添加点赞提醒
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(likeDTO.getBusinessId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_TOPIC)
                            .setUserId(topicInfo.getUserId())
                            .setNotifyContent("您的帖子被用户[" + user.getUserName() + "]点赞啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        } else if (Constant.LIKE_TYPE_COMMENT.equals(likeDTO.getLikeType())) {
            // 给该评论增加一点点赞数量
            commentInfoMapper.setNum(likeDTO.getBusinessId(), Constant.INTEGER_ONE, Constant.INTEGER_ONE);
            // 查询评论信息
            CommentInfo commentInfo = commentInfoMapper.selectById(likeDTO.getBusinessId());
            if (ObjectUtils.isEmpty(commentInfo)) {
                throw new ServiceException("未获取到评论信息,可能评论已被删除!");
            }
            // 添加点赞提醒
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(likeDTO.getBusinessId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_TOPIC)
                            .setUserId(commentInfo.getUserId())
                            .setNotifyContent("您的评论被用户[" + user.getUserName() + "]点赞啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        } else if (Constant.LIKE_TYPE_INTRODUCTION.equals(likeDTO.getLikeType())) {
            // 给该攻略增加一点点赞数量
            introductionInfoMapper.setNum(likeDTO.getBusinessId(), Constant.INTEGER_ONE, Constant.INTEGER_ONE, Constant.INTEGER_ONE);
            // 添加点赞提醒
            IntroductionInfo introductionInfo = introductionInfoMapper.selectById(likeDTO.getBusinessId());
            if (ObjectUtils.isEmpty(introductionInfo)) {
                throw new ServiceException("未获取到攻略信息,可能攻略已被删除!");
            }
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(likeDTO.getBusinessId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_INTRODUCTION)
                            .setUserId(introductionInfo.getUserId())
                            .setNotifyContent("您的攻略被用户[" + user.getUserName() + "]点赞啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        }
        // 保存点赞数据
        LikeInfo likeInfo = CopyUtils.classCopy(likeDTO, LikeInfo.class);
        // 设置点赞用户和点赞时间
        likeInfo.setUserId(userId).setLikeTime(new Date());
        // 保存点赞信息
        return this.save(likeInfo);
    }

    /**
     * 取消点赞
     *
     * @param businessId 业务ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Boolean cancel(Long businessId) {
        // 查询点赞信息
        LikeInfo likeInfo = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(LikeInfo::getBusinessId, businessId)
                .eq(LikeInfo::getUserId, StpUtil.getLoginIdAsLong())
                .one();
        // 判断点赞信息
        if (ObjectUtils.isEmpty(likeInfo)) {
            throw new ServiceException("您还未点过赞!");
        }
        // 根据点赞类型减少点赞数量
        if (Constant.LIKE_TYPE_TOPIC.equals(likeInfo.getLikeType())) {
            // 给该话题减少一点点赞数量
            topicInfoMapper.setNum(likeInfo.getBusinessId(), Constant.INTEGER_THREE, Constant.INTEGER_TWO, Constant.INTEGER_ONE);
        } else if (Constant.LIKE_TYPE_COMMENT.equals(likeInfo.getLikeType())) {
            // 给该评论减少一点点赞数量
            commentInfoMapper.setNum(likeInfo.getBusinessId(), Constant.INTEGER_TWO, Constant.INTEGER_ONE);
        } else if (Constant.LIKE_TYPE_INTRODUCTION.equals(likeInfo.getLikeType())) {
            // 给该攻略减少一点点赞数量
            introductionInfoMapper.setNum(likeInfo.getBusinessId(), Constant.INTEGER_ONE, Constant.INTEGER_TWO, Constant.INTEGER_ONE);
        }
        // 删除点赞信息
        return this.removeById(likeInfo.getLikeId());
    }
}
