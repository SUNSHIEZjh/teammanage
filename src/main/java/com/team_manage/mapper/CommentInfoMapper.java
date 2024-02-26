package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.topic.query.WxCommentQry;
import com.team_manage.controller.topic.vo.CommentInfoVO;
import com.team_manage.entity.CommentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface CommentInfoMapper extends BaseMapper<CommentInfo> {

    /**
     * 话题增加减少点赞数量
     *
     * @param commentId 话题ID
     * @param change    点赞类型：1、增加 2、减少
     * @param num       数量
     * @return Boolean
     */
    Boolean setNum(@Param("commentId") Long commentId, @Param("change") Integer change, @Param("num") Integer num);

    /**
     * 根据话题ID查询评论信息
     *
     * @param qry   查询Qry
     * @param type  查询类型：1、评论 2、回复
     * @param pages 分页类
     * @return IPage<CommentInfoVO>
     */
    IPage<CommentInfoVO> pageByTopic(@Param("qry") WxCommentQry qry,
                                     @Param("type") Integer type,
                                     @Param("pages") IPage<CommentInfoVO> pages);

    /**
     * 根据话题ID查询评论信息列表
     *
     * @param qry  查询Qry
     * @param type 查询类型：1、评论 2、回复
     * @return List<CommentInfoVO>
     */
    List<CommentInfoVO> listByTopic(@Param("qry") WxCommentQry qry,
                                    @Param("type") Integer type);

    /**
     * 根据评论ID查询评论信息
     *
     * @param commentId 评论ID
     * @param userId    登录用户ID
     * @return CommentInfoVO
     */
    CommentInfoVO commentById(@Param("commentId") Long commentId, @Param("userId") Long userId);

    /**
     * 获取当前评论顺序
     *
     * @param topicId       帖子ID
     * @param commentParent 评论父ID
     * @return Integer
     */
    Integer countByTopicAndParent(@Param("topicId") Long topicId, @Param("commentParent") Long commentParent);
}
