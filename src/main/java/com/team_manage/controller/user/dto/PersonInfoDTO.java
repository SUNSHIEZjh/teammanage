package com.team_manage.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 人员信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "人员信息VO")
public class PersonInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 人员名称
     */
    @NotBlank(message = "人员名称")
    @ApiModelProperty("人员名称")
    private String personName;

    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号")
    @ApiModelProperty("身份证号")
    private String personCard;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码")
    @ApiModelProperty("手机号码")
    private String personPhone;
}
