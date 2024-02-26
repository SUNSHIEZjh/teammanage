package com.team_manage.controller.role;


import com.team_manage.common.Result;
import com.team_manage.controller.role.dto.RoleMenuDTO;
import com.team_manage.controller.role.vo.RoleMenuVO;
import com.team_manage.service.SysRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 角色菜单表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/role/menu")
@Api(value = "WebRoleMenuController", tags = {"WEB-角色菜单信息接口"})
public class WebRoleMenuController {
    /**
     * 角色菜单Service
     */
    private final SysRoleMenuService roleMenuService;

    @ApiOperation("根据角色ID获取菜单列表")
    @GetMapping("/tree/{roleId}")
//    @SaCheckPermission("system:role:tree")
    public Result<List<RoleMenuVO>> listTree(@PathVariable @NotNull(message = "角色ID") Long roleId) {
        return Result.success(roleMenuService.listTree(roleId));
    }

    @ApiOperation("角色授权菜单")
    @PostMapping("/empower")
//    @SaCheckPermission("system:role:empower")
    public Result<Boolean> empower(@RequestBody @Valid RoleMenuDTO roleMenuDTO) {
        return Result.success(roleMenuService.empower(roleMenuDTO));
    }

    @ApiOperation("查询登录用户菜单树")
    @GetMapping("/user")
    public Result<List<RoleMenuVO>> user() {
        return Result.success(roleMenuService.user());
    }

    @ApiOperation("查询登录用户列表")
    @GetMapping("/user/list")
    public Result<List<RoleMenuVO>> userList() {
        return Result.success(roleMenuService.userList());
    }
}

