package com.team_manage.controller.topic.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 话题信息表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "话题信息VO")
public class CollectTopicVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 话题ID
     */
    @ApiModelProperty("话题ID")
    private Long topicId;

    /**
     * 话题标题
     */
    @ApiModelProperty("话题标题")
    private String topicTitle;

    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    private Date topicTime;

    /**
     * 话题内容
     */
    @ApiModelProperty("话题内容")
    private String topicContent;

    /**
     * 话题图片
     */
    @ApiModelProperty("话题图片")
    private String topicImg;

    /**
     * 发布人
     */
    @ApiModelProperty("发布人")
    private Long userId;

    /**
     * 话题热度
     */
    @ApiModelProperty("话题热度")
    private Integer topicHot;

    /**
     * 话题收藏数
     */
    @ApiModelProperty("话题收藏数")
    private Integer collectNum;

    /**
     * 点赞数量
     */
    @ApiModelProperty("点赞数量")
    private Integer likeNum;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String userAvatar;

    /**
     * 是否收藏
     */
    @ApiModelProperty("是否收藏")
    private Integer isCollect;

    /**
     * 是否点赞
     */
    @ApiModelProperty("是否点赞")
    private Integer isLike;

    /**
     * 评论数量
     */
    @ApiModelProperty("评论数量")
    private Integer commentNum;

}
