package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team_manage.common.Constant;
import com.team_manage.controller.topic.dto.TopicInfoDTO;
import com.team_manage.controller.topic.query.WebTopicQry;
import com.team_manage.controller.topic.query.WxTopicQry;
import com.team_manage.controller.topic.query.WxUserTopicQry;
import com.team_manage.controller.topic.vo.TopicInfoVO;
import com.team_manage.entity.TopicInfo;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.TopicInfoMapper;
import com.team_manage.service.TopicInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 话题信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class TopicInfoServiceImpl extends ServiceImpl<TopicInfoMapper, TopicInfo> implements TopicInfoService {

    /**
     * 微信话题信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<TopicInfoVO>
     */
    @Override
    public IPage<TopicInfoVO> wxPage(WxTopicQry qry) {
        IPage<TopicInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 设置用户ID
        try {
            qry.setUserId(StpUtil.getLoginIdAsLong());
        } catch (Exception e) {
            qry.setUserId(Constant.LONG_ZERO);
        }
        // 返回分页信息
        return baseMapper.wxPage(qry, pages);
    }

    /**
     * WEB话题信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<TopicInfoVO>
     */
    @Override
    public IPage<TopicInfoVO> webPage(WebTopicQry qry) {
        IPage<TopicInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 设置用户ID
        qry.setUserId(StpUtil.getLoginIdAsLong());
        // 返回分页信息
        return baseMapper.webPage(qry, pages);
    }

    /**
     * 我的话题列表
     *
     * @param qry 查询Qry
     * @return IPage<TopicInfoVO>
     */
    @Override
    public IPage<TopicInfoVO> mine(WxTopicQry qry) {
        IPage<TopicInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        qry.setUserId(StpUtil.getLoginIdAsLong());
        // 返回分页信息
        return baseMapper.minePage(qry, pages);
    }

    /**
     * 话题信息详情
     *
     * @param topicId 话题ID
     * @return TopicInfoVO
     */
    @Override
    public TopicInfoVO detailById(Long topicId) {
        Long userId;
        // 设置用户ID
        try {
            userId = StpUtil.getLoginIdAsLong();
        } catch (Exception e) {
            userId = Constant.LONG_ZERO;
        }
        return baseMapper.detailById(topicId, userId);
    }

    /**
     * 新增话题信息
     *
     * @param topicInfoDTO 话题DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(TopicInfoDTO topicInfoDTO) {
        // 组装话题信息
        TopicInfo topicInfo = CopyUtils.classCopy(topicInfoDTO, TopicInfo.class);
        // 设置话题信息初始值
        topicInfo.setTopicTime(new Date())
                .setUserId(StpUtil.getLoginIdAsLong())
                .setCollectNum(Constant.INTEGER_ZERO)
                .setLikeNum(Constant.INTEGER_ZERO)
                .setTopicHot(Constant.INTEGER_ZERO);
        // 保存话题信息
        return this.save(topicInfo);
    }

    /**
     * 修改话题信息
     *
     * @param topicId      话题ID
     * @param topicInfoDTO 话题DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(Long topicId, TopicInfoDTO topicInfoDTO) {
        // 根据话题ID查询话题信息
        TopicInfo topicInfo = baseMapper.selectById(topicId);
        if (ObjectUtils.isEmpty(topicInfo)){
            throw new ServiceException("未查询到话题信息!");
        }
        if (!topicInfo.getUserId().equals(StpUtil.getLoginIdAsLong())) {
            throw new ServiceException("不能修改他人的帖子!");
        }
        // 组装话题信息
        topicInfo = CopyUtils.classCopy(topicInfoDTO, TopicInfo.class);
        topicInfo.setTopicId(topicId);
        // 更新话题信息
        return this.updateById(topicInfo);
    }

    /**
     * 删除话题信息
     *
     * @param topicId 话题ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long topicId) {
        return this.removeById(topicId);
    }

    /**
     * 查询用户发布的话题信息
     *
     * @param qry qry
     * @return IPage<TopicInfoVO>
     */
    @Override
    public IPage<TopicInfoVO> user(WxUserTopicQry qry) {
        IPage<TopicInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        try {
            qry.setLoginId(StpUtil.getLoginIdAsLong());
        } catch (Exception e){
            qry.setLoginId(Constant.LONG_ZERO);
        }
        // 返回分页信息
        return baseMapper.userPage(qry, pages);
    }
}
