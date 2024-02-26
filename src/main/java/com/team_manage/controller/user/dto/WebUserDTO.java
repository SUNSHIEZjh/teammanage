package com.team_manage.controller.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户信息DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户信息DTO")
public class WebUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号")
    @ApiModelProperty("用户账号")
    private String userAccount;

    /**
     * 用户头像
     */
    @NotBlank(message = "用户头像")
    @ApiModelProperty("用户头像")
    private String userAvatar;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码")
    @ApiModelProperty("手机号码")
    private String userPhone;

    /**
     * 出生日期
     */
    @NotNull(message = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("出生日期")
    private Date userBirthday;

    /**
     * 性别 0、未知 1、男 2、女
     */
    @NotNull(message = "性别")
    @ApiModelProperty("性别 0、未知 1、男 2、女")
    private Integer userSex;

    /**
     * 角色ID
     */
    @NotNull(message = "角色ID")
    @ApiModelProperty("角色ID")
    private Long roleId;

}
