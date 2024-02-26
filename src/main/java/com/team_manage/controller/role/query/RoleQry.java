package com.team_manage.controller.role.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色查询Qry
 * </p>
 *
 * @author ZSL
 * @since 2023-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "角色查询Qry")
public class RoleQry extends BaseParam {

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;
}
