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
 * 用户信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户信息VO")
public class WebUserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long userId;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 背景图
     */
    @ApiModelProperty("背景图")
    private String backGround;

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    private String userAccount;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String userAvatar;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String userPhone;

    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private Date userBirthday;

    /**
     * 性别 0、未知 1、男 2、女
     */
    @ApiModelProperty("性别 0、未知 1、男 2、女")
    private Integer userSex;

    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    private Date lastLoginTime;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色标识
     */
    @ApiModelProperty("角色标识")
    private String roleFlag;

}
