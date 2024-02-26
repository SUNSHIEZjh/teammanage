package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.topic.query.WebTopicQry;
import com.team_manage.controller.topic.query.WxTopicQry;
import com.team_manage.controller.topic.query.WxUserTopicQry;
import com.team_manage.controller.topic.vo.TopicInfoVO;
import com.team_manage.entity.TopicInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 话题信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface TopicInfoMapper extends BaseMapper<TopicInfo> {

    /**
     * 微信话题信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> wxPage(@Param("qry") WxTopicQry qry, @Param("pages") IPage<TopicInfoVO> pages);

    /**
     * WEB信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> webPage(@Param("qry") WebTopicQry qry, @Param("pages") IPage<TopicInfoVO> pages);

    /**
     * 我的话题列表
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> minePage(@Param("qry") WxTopicQry qry, @Param("pages") IPage<TopicInfoVO> pages);

    /**
     * 话题信息详情
     *
     * @param topicId 话题ID
     * @param userId  登录人ID
     * @return TopicInfoVO
     */
    TopicInfoVO detailById(@Param("topicId") Long topicId, @Param("userId") Long userId);

    /**
     * 给话题设置数量
     *
     * @param topicId 话题ID
     * @param type    操作类型：1、热度 2、收藏 3、点赞
     * @param change  变化类型：1、增加 2、减少
     * @param num     数量
     * @return Boolean
     */
    Boolean setNum(@Param("topicId") Long topicId, @Param("type") Integer type, @Param("change") Integer change, @Param("num") Integer num);

    /**
     * 查询用户发布的话题信息
     *
     * @param qry   qry
     * @param pages 分页类
     * @return IPage<TopicInfoVO>
     */
    IPage<TopicInfoVO> userPage(@Param("qry") WxUserTopicQry qry, @Param("pages") IPage<TopicInfoVO> pages);
}
