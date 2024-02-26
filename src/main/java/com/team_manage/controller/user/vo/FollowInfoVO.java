package com.team_manage.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 关注信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "关注信息VO")
public class FollowInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关注ID
     */
    @ApiModelProperty("关注ID")
    private Long followId;

    /**
     * 关注人
     */
    @ApiModelProperty("关注人")
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
     * 被关注人
     */
    @ApiModelProperty("被关注人")
    private Long beUserId;

    /**
     * 被关注用户名称
     */
    @ApiModelProperty("被关注用户名称")
    private String beUserName;

    /**
     * 被关注用户头像
     */
    @ApiModelProperty("被关注用户头像")
    private String beUserAvatar;

    /**
     * 关注时间
     */
    @ApiModelProperty("关注时间")
    private Date followTime;

    /**
     * 是否关注
     */
    @ApiModelProperty("是否关注")
    private Long isFollow;

}
