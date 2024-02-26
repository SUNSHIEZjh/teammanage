package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.topic.query.WxCollectQry;
import com.team_manage.controller.topic.vo.CollectIntroductionVO;
import com.team_manage.controller.topic.vo.CollectTopicVO;
import com.team_manage.entity.CollectInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 收藏信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface CollectInfoMapper extends BaseMapper<CollectInfo> {

    /**
     * 查询用户收藏的话题信息
     *
     * @param qry   查询Qry
     * @param pages 分页page
     * @return IPage<CollectTopicVO>
     */
    IPage<CollectTopicVO> topicPage(@Param("qry") WxCollectQry qry, @Param("pages") IPage<CollectTopicVO> pages);

    /**
     * 查询用户收藏的攻略信息
     *
     * @param qry   查询Qry
     * @param pages 分页page
     * @return IPage<CollectTopicVO>
     */
    IPage<CollectIntroductionVO> introductionPage(@Param("qry") WxCollectQry qry, @Param("pages") IPage<CollectTopicVO> pages);
}
