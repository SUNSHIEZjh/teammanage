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
 * 收藏攻略信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "收藏攻略信息VO")
public class CollectIntroductionVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏ID
     */
    @ApiModelProperty("收藏ID")
    private Long collectId;

    /**
     * 收藏类型：1、帖子 2、攻略
     */
    @ApiModelProperty("收藏类型：1、帖子 2、攻略")
    private Integer collectType;

    /**
     * 业务ID：1为帖子ID 2为攻略ID
     */
    @ApiModelProperty("业务ID：1为帖子ID 2为攻略ID")
    private Long businessId;

    /**
     * 收藏时间
     */
    @ApiModelProperty("收藏时间")
    private Date collectTime;

    /**
     * 攻略名称
     */
    @ApiModelProperty("攻略名称")
    private String introductionName;

    /**
     * 攻略封面
     */
    @ApiModelProperty("攻略封面")
    private String introductionImg;

    /**
     * 攻略描述
     */
    @ApiModelProperty("攻略描述")
    private String introductionDesc;

    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    private Date introductionTime;

    /**
     * 收藏数量
     */
    @ApiModelProperty("收藏数量")
    private Integer introductionCollect;

    /**
     * 点赞数量
     */
    @ApiModelProperty("点赞数量")
    private Integer introductionLike;

    /**
     * 发布人
     */
    @ApiModelProperty("发布人")
    private Long userId;

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

}
