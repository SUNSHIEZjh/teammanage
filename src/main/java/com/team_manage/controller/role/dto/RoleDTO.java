package com.team_manage.controller.role.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 角色信息操作DTO
 * </p>
 *
 * @author ZSL
 * @since 2023-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "角色信息操作DTO")
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称")
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色标识
     */
    @NotBlank(message = "角色标识")
    @ApiModelProperty("角色标识")
    private String roleFlag;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;


}
