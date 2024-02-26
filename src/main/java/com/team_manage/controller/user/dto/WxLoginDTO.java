package com.team_manage.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * WxLoginDTO登录DTO
 *
 * @author ZSL
 * @since 2023-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Wx登录DTO")
public class WxLoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CODE
     */
    @NotBlank(message = "CODE")
    @ApiModelProperty(value = "CODE", name = "code")
    private String code;
}
