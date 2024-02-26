package com.team_manage.controller.role;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.role.query.MenuQry;
import com.team_manage.controller.role.vo.MenuVO;
import com.team_manage.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/menu")
@Api(value = "WxMenuController", tags = {"WX-菜单信息接口"})
public class WxMenuController {
    /**
     * 菜单Service
     */
    private final SysMenuService menuService;

    @ApiOperation("菜单分页查询")
    @GetMapping("/page")
//    @SaCheckPermission("menu:page")
    public Result<IPage<MenuVO>> page(MenuQry menuQry) {
        return Result.success(menuService.pageByQry(menuQry));
    }

    @ApiOperation("菜单详情")
    @GetMapping("/detail/{menuId}")
//    @SaCheckPermission("menu:page:show")
    public Result<MenuVO> detail(@PathVariable @NotNull(message = "菜单ID") Long menuId) {
        return Result.success(menuService.detailById(menuId));
    }
}

