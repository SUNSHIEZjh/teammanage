package com.team_manage.controller.role.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单查询Qry
 * </p>
 *
 * @author ZSL
 * @since 2023-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("菜单查询Qry")
public class MenuQry extends BaseParam {

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /**
     * 菜单类型 1、父菜单 2、菜单 3、按钮
     */
    @ApiModelProperty("菜单类型 1、父菜单 2、菜单 3、按钮")
    private Integer menuType;

}
