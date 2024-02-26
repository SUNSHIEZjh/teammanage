package com.team_manage.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.user.dto.LoginDTO;
import com.team_manage.controller.user.dto.WebUserDTO;
import com.team_manage.controller.user.query.WebUserQry;
import com.team_manage.controller.user.vo.WebLoginVO;
import com.team_manage.controller.user.vo.WebUserVO;
import com.team_manage.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/user")
@Api(value = "WebUserController", tags = {"WEB-用户信息接口"})
public class WebUserController {
    /**
     * 用户Service
     */
    private final SysUserService userService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result<WebLoginVO> login(@RequestBody @Valid LoginDTO loginDTO) {
        return Result.success(userService.login(loginDTO));
    }

    @ApiOperation("用户信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:user:page")
    public Result<IPage<WebUserVO>> page(@RequestBody @Valid WebUserQry qry) {
        return Result.success(userService.pageByQry(qry));
    }

    @ApiOperation("用户信息详情")
    @GetMapping("/detail/{userId}")
//    @SaCheckPermission("web:user:detail")
    public Result<WebUserVO> detail(@PathVariable @NotNull(message = "用户ID") Long userId) {
        return Result.success(userService.detail(userId));
    }

    @ApiOperation("新增用户信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid WebUserDTO userDTO ) {
        return Result.success(userService.add(userDTO));
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/edit/{userId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long userId,
                                @RequestBody @Valid WebUserDTO userDTO ) {
        return Result.success(userService.webEdit(userId, userDTO));
    }

    @ApiOperation("删除用户信息")
    @PostMapping("/del/{userId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long userId) {
        return Result.success(userService.del(userId));
    }
}

