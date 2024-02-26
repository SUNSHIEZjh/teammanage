package com.team_manage.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录DTO
 *
 * @author ZSL
 * @since 2023-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户登录DTO")
public class LoginDTO {
    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号")
    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码")
    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码")
    @ApiModelProperty(value = "验证码")
    private String code;
}
