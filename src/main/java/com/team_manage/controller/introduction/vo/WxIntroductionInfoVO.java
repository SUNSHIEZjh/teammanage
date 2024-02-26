package com.team_manage.controller.introduction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * WX攻略信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WX攻略信息VO")
public class WxIntroductionInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略ID
     */
    @ApiModelProperty("攻略ID")
    private Long introductionId;

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
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    private Date introductionTime;

    /**
     * 发布用户
     */
    @ApiModelProperty("发布用户")
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
     * 攻略描述
     */
    @ApiModelProperty("攻略描述")
    private String introductionDesc;

    /**
     * 点赞数量
     */
    @ApiModelProperty("点赞数量")
    private Integer introductionLike;

    /**
     * 收藏数量
     */
    @ApiModelProperty("收藏数量")
    private Integer introductionCollect;

    /**
     * 攻略状态 1、未审核 2、已通过审核 3、未通过审核 4、重新提交审核
     */
    @ApiModelProperty("攻略状态 1、未审核 2、已通过审核 3、未通过审核 4、重新提交审核")
    private Integer introductionStatus;

    /**
     * 审核结果
     */
    @ApiModelProperty("审核结果")
    private String auditResult;

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
