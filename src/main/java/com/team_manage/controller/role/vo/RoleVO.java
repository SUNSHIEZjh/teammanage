package com.team_manage.controller.role.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色信息VO
 * </p>
 *
 * @author ZSL
 * @since 2023-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "角色信息VO")
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
