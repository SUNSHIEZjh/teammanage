package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.topic.dto.CollectDTO;
import com.team_manage.controller.topic.query.WxCollectQry;
import com.team_manage.controller.topic.vo.CollectIntroductionVO;
import com.team_manage.controller.topic.vo.CollectTopicVO;
import com.team_manage.entity.*;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.*;
import com.team_manage.service.CollectInfoService;
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
 * 收藏信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class CollectInfoServiceImpl extends ServiceImpl<CollectInfoMapper, CollectInfo> implements CollectInfoService {

    /**
     * 话题Mapper
     */
    private final TopicInfoMapper topicInfoMapper;

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
     * 分页查询用户收藏的帖子信息
     *
     * @param qry 查询Qry
     * @return IPage<CollectTopicVO>
     */
    @Override
    public IPage<CollectTopicVO> topicPage(WxCollectQry qry) {
        IPage<CollectTopicVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 设置用户ID
        try {
            qry.setUserId(StpUtil.getLoginIdAsLong());
        } catch (Exception e) {
            qry.setUserId(Constant.LONG_ZERO);
        }
        // 如果登录用户也为空，则抛出未登录异常
        if (ObjectUtils.isEmpty(qry.getUser())) {
            qry.setUser(StpUtil.getLoginIdAsLong());
        }
        // 分页查询
        return baseMapper.topicPage(qry, pages);
    }

    /**
     * 分页查询用户收藏的攻略信息
     *
     * @param qry 查询Qry
     * @return
     */
    @Override
    public IPage<CollectIntroductionVO> introductionPage(WxCollectQry qry) {
        IPage<CollectTopicVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 设置用户ID
        try {
            qry.setUserId(StpUtil.getLoginIdAsLong());
        } catch (Exception e) {
            qry.setUserId(Constant.LONG_ZERO);
        }
        // 如果登录用户也为空，则抛出未登录异常
        if (ObjectUtils.isEmpty(qry.getUser())) {
            qry.setUser(StpUtil.getLoginIdAsLong());
        }
        // 分页查询
        return baseMapper.introductionPage(qry, pages);
    }

    /**
     * 收藏帖子、攻略
     *
     * @param collectDTO 收藏DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Boolean add(CollectDTO collectDTO) {
        // 获取登录用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 查询登录用户信息
        SysUser user = sysUserMapper.selectById(userId);
        // 判断是否已经点过赞了
        List<CollectInfo> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(CollectInfo::getBusinessId, collectDTO.getBusinessId())
                .eq(CollectInfo::getUserId, userId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("您已经收藏过了!");
        }
        // 根据点赞类型增加收藏数量
        if (Constant.COLLECT_TYPE_TOPIC.equals(collectDTO.getCollectType())) {
            // 给该话题增加一点收藏数量
            topicInfoMapper.setNum(collectDTO.getBusinessId(), Constant.INTEGER_TWO, Constant.INTEGER_ONE, Constant.INTEGER_ONE);
            // 查询帖子信息
            TopicInfo topicInfo = topicInfoMapper.selectById(collectDTO.getBusinessId());
            if (ObjectUtils.isEmpty(topicInfo)) {
                throw new ServiceException("未获取到帖子信息,可能帖子已被删除!");
            }
            // 添加收藏提醒
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(collectDTO.getBusinessId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_TOPIC)
                            .setUserId(topicInfo.getUserId())
                            .setNotifyContent("您的帖子被用户[" + user.getUserName() + "]收藏啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        } else if (Constant.COLLECT_TYPE_INTRODUCTION.equals(collectDTO.getCollectType())) {
            // 给该攻略增加一点收藏数量
            introductionInfoMapper.setNum(collectDTO.getBusinessId(), Constant.INTEGER_TWO, Constant.INTEGER_ONE, Constant.INTEGER_ONE);
            // 添加收藏提醒
            IntroductionInfo introductionInfo = introductionInfoMapper.selectById(collectDTO.getBusinessId());
            if (ObjectUtils.isEmpty(introductionInfo)) {
                throw new ServiceException("未获取到攻略信息,可能攻略已被删除!");
            }
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(collectDTO.getBusinessId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_INTRODUCTION)
                            .setUserId(introductionInfo.getUserId())
                            .setNotifyContent("您的攻略被用户[" + user.getUserName() + "]收藏啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        }
        // 保存点赞数据
        CollectInfo collectInfo = CopyUtils.classCopy(collectDTO, CollectInfo.class);
        // 设置收藏用户和收藏时间
        collectInfo.setUserId(userId).setCollectTime(new Date());
        // 保存收藏信息
        return this.save(collectInfo);
    }

    /**
     * 取消收藏帖子、攻略
     *
     * @param businessId 业务ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Boolean cancel(Long businessId) {
        // 查询收藏信息
        CollectInfo collectInfo = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(CollectInfo::getBusinessId, businessId)
                .eq(CollectInfo::getUserId, StpUtil.getLoginIdAsLong())
                .one();
        // 判断是否存在收藏信息
        if (ObjectUtils.isEmpty(collectInfo)) {
            throw new ServiceException("您还未收藏过!");
        }
        // 根据点赞类型减少收藏数量
        if (Constant.COLLECT_TYPE_TOPIC.equals(collectInfo.getCollectType())) {
            // 给该话题减少一点收藏数量
            topicInfoMapper.setNum(collectInfo.getBusinessId(), Constant.INTEGER_TWO, Constant.INTEGER_TWO, Constant.INTEGER_ONE);
        } else if (Constant.COLLECT_TYPE_INTRODUCTION.equals(collectInfo.getCollectType())) {
            // 给该攻略减少一点收藏数量
            introductionInfoMapper.setNum(collectInfo.getBusinessId(), Constant.INTEGER_TWO, Constant.INTEGER_TWO, Constant.INTEGER_ONE);
        }
        // 删除收藏信息
        return this.removeById(collectInfo.getCollectId());
    }
}
