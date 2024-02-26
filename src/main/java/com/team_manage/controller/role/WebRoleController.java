package com.team_manage.controller.role;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.role.dto.RoleDTO;
import com.team_manage.controller.role.query.RoleQry;
import com.team_manage.controller.role.vo.RoleVO;
import com.team_manage.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/role")
@Api(value = "WebRoleController", tags = {"WEB-角色信息接口"})
public class WebRoleController {

    /**
     * 角色Service
     */
    private final SysRoleService roleService;

    @ApiOperation("角色分页查询")
    @GetMapping("/page")
//    @SaCheckPermission("system:role")
    public Result<IPage<RoleVO>> page(RoleQry roleQry) {
        return Result.success(roleService.pageByQry(roleQry));
    }

    @ApiOperation("角色详情")
    @GetMapping("/detail/{roleId}")
//    @SaCheckPermission("system:role:show")
    public Result<RoleVO> detail(@PathVariable @NotNull(message = "角色ID") Long roleId) {
        return Result.success(roleService.detailById(roleId));
    }

    @ApiOperation("新增角色")
    @PostMapping("/save")
//    @SaCheckPermission("system:role:add")
    public Result<Boolean> save(@RequestBody @Valid RoleDTO roleDTO) {
        return Result.success(roleService.save(roleDTO));
    }

    @ApiOperation("修改角色")
    @PostMapping("/edit/{roleId}")
//    @SaCheckPermission("system:role:edit")
    public Result<Boolean> edit(@NotNull(message = "角色ID") @PathVariable Long roleId,
                                @RequestBody @Valid RoleDTO roleDTO) {
        return Result.success(roleService.edit(roleId, roleDTO));
    }

    @ApiOperation("删除角色")
    @PostMapping("/del/{roleId}")
//    @SaCheckPermission("system:role:del")
    public Result<Boolean> del(@NotNull(message = "角色ID") @PathVariable Long roleId) {
        return Result.success(roleService.del(roleId));
    }

    @ApiOperation("查询角色信息列表")
    @GetMapping("/list")
    public Result<List<RoleVO>> list() {
        return Result.success(roleService.roleList());
    }
}

