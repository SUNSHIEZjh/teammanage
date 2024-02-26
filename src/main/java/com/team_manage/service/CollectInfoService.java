package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.topic.dto.CollectDTO;
import com.team_manage.controller.topic.query.WxCollectQry;
import com.team_manage.controller.topic.vo.CollectIntroductionVO;
import com.team_manage.controller.topic.vo.CollectTopicVO;
import com.team_manage.entity.CollectInfo;

/**
 * <p>
 * 收藏信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface CollectInfoService extends IService<CollectInfo> {

    /**
     * 收藏帖子、攻略
     *
     * @param collectDTO 收藏DTO
     * @return Boolean
     */
    Boolean add(CollectDTO collectDTO);

    /**
     * 取消收藏帖子、攻略
     *
     * @param businessId 业务ID
     * @return Boolean
     */
    Boolean cancel(Long businessId);

    /**
     * 分页查询用户收藏的帖子信息
     *
     * @param qry 查询Qry
     * @return IPage<CollectTopicVO>
     */
    IPage<CollectTopicVO> topicPage(WxCollectQry qry);

    /**
     * 分页查询用户收藏的攻略信息
     *
     * @param qry 查询Qry
     * @return IPage<CollectIntroductionVO>
     */
    IPage<CollectIntroductionVO> introductionPage(WxCollectQry qry);
}
