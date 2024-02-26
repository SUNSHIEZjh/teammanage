package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.topic.dto.TopicInfoDTO;
import com.team_manage.controller.topic.query.WebTopicQry;
import com.team_manage.controller.topic.query.WxTopicQry;
import com.team_manage.controller.topic.query.WxUserTopicQry;
import com.team_manage.controller.topic.vo.TopicInfoVO;
import com.team_manage.entity.TopicInfo;

/**
 * <p>
 * 话题信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface TopicInfoService extends IService<TopicInfo> {

    /**
     * 微信话题信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> wxPage(WxTopicQry qry);


    /**
     * WEB话题信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> webPage(WebTopicQry qry);

    /**
     * 我的话题列表
     *
     * @param qry 查询Qry
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> mine(WxTopicQry qry);

    /**
     * 话题信息详情
     *
     * @param topicId 话题ID
     * @return TopicInfoVO
     */
    TopicInfoVO detailById(Long topicId);

    /**
     * 新增话题信息
     *
     * @param topicInfoDTO 话题DTO
     * @return Boolean
     */
    Boolean add(TopicInfoDTO topicInfoDTO);

    /**
     * 修改话题信息
     *
     * @param topicId      话题ID
     * @param topicInfoDTO 话题DTO
     * @return Boolean
     */
    Boolean edit(Long topicId, TopicInfoDTO topicInfoDTO);

    /**
     * 删除话题信息
     *
     * @param topicId 话题ID
     * @return Boolean
     */
    Boolean del(Long topicId);

    /**
     * 查询用户发布的话题信息
     *
     * @param qry qry
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> user(WxUserTopicQry qry);
}
