package com.team_manage.controller.user.vo;

import cn.dev33.satoken.stp.SaTokenInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 登录返回信息VO
 *
 * @author ZSL
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WebLoginVO 登录返回信息VO")
public class WebLoginVO implements Serializable {

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
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String userAvatar;

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

    /**
     * saToken
     */
    @ApiModelProperty("saToken")
    private String saToken;

    /**
     * 用户登录信息
     */
    @ApiModelProperty("用户登录信息")
    private SaTokenInfo tokenInfo;
}
