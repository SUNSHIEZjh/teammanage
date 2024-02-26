package com.team_manage.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * Wx用户VO
 *
 * @author XXX
 * @since 2023-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Wx用户VO")
public class WxUserVO implements Serializable {

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

}
