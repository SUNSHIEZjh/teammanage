package com.team_manage.controller.topic.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 评论信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "评论信息VO")
public class CommentInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @ApiModelProperty("评论ID")
    private Long commentId;

    /**
     * 评论父ID
     */
    @ApiModelProperty("评论父ID")
    private Long commentParent;

    /**
     * 帖子ID
     */
    @ApiModelProperty("帖子ID")
    private Long topicId;

    /**
     * 评论时间
     */
    @ApiModelProperty("评论时间")
    private Date commentTime;

    /**
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String commentContent;

    /**
     * 评论顺序
     */
    @ApiModelProperty("评论顺序")
    private Integer commentSort;

    /**
     * 点赞数量
     */
    @ApiModelProperty("点赞数量")
    private Integer likeNum;

    /**
     * 是否点赞
     */
    @ApiModelProperty("是否点赞")
    private Integer isLike;

    /**
     * 评论用户
     */
    @ApiModelProperty("评论用户")
    private Long userId;

    /**
     * 评论用户名称
     */
    @ApiModelProperty("评论用户名称")
    private String userName;

    /**
     * 评论用户头像
     */
    @ApiModelProperty("评论用户头像")
    private String userAvatar;

    /**
     * 被评论用户
     */
    @ApiModelProperty("被评论用户")
    private Long beUserId;

    /**
     * 评论用户名称
     */
    @ApiModelProperty("被评论用户名称")
    private String beUserName;

    /**
     * 评论用户头像
     */
    @ApiModelProperty("被评论用户头像")
    private String beUserAvatar;

    /**
     * 子评论信息
     */
    @ApiModelProperty("子评论信息")
    private List<CommentInfoVO> children;

}
