package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.topic.dto.CommentDTO;
import com.team_manage.controller.topic.query.WxCommentQry;
import com.team_manage.controller.topic.vo.CommentInfoVO;
import com.team_manage.entity.CommentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface CommentInfoService extends IService<CommentInfo> {

    /**
     * 新增评论
     *
     * @param commentDTO 评论DTO
     * @return Boolean
     */
    CommentInfoVO add(CommentDTO commentDTO);

    /**
     * 评论信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<CommentInfoVO>
     */
    IPage<CommentInfoVO> pageByTopic(WxCommentQry qry);

    /**
     * 删除评论信息
     *
     * @param commentIds 评论ID列表
     * @return Boolean
     */
    Boolean del(List<Long> commentIds);
}
