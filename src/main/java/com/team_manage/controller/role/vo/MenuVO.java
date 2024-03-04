package com.team_manage.controller.role.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单VO
 * </p>
 *
 * @author ZSL
 * @since 2023-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("菜单VO")
public class MenuVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 菜单路由
     */
    private String menuPath;

    /**
     * 权限标识
     */
    private String menuFlag;

    /**
     * 菜单父编号
     */
    private Long menuParent;

    /**
     * 菜单类型 1、父菜单 2、菜单 3、按钮
     */
    private Integer menuType;

    /**
     * 菜单排序
     */
    private Integer menuSort;

    /**
     * 菜单图标
     */
    private String menuIcon;


}
