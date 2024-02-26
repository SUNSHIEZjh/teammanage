package com.team_manage.controller.user;


import cn.dev33.satoken.stp.StpUtil;
import com.team_manage.common.Result;
import com.team_manage.controller.user.dto.LoginDTO;
import com.team_manage.controller.user.dto.WxLoginDTO;
import com.team_manage.controller.user.dto.WxUserDTO;
import com.team_manage.controller.user.vo.WebLoginVO;
import com.team_manage.controller.user.vo.WxUserVO;
import com.team_manage.controller.user.vo.WxUserVO1;
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
@RequestMapping("/wx/user")
@Api(value = "WxUserController", tags = {"WX-用户信息接口"})
public class WxUserController {
    /**
     * 用户Service
     */
    private final SysUserService userService;

    @ApiOperation("用户授权登录")
    @PostMapping("/login")
    public Result<WebLoginVO> login(@RequestBody @Valid WxLoginDTO loginDTO) {
        return Result.success(userService.wxLogin(loginDTO));
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/mine")
    public Result<WxUserVO> mine() {
        return Result.success(userService.mine());
    }

    @ApiOperation("获取用户详情信息")
    @GetMapping("/user/{userId}")
    public Result<WxUserVO1> user(@PathVariable @NotNull(message = "用户ID") Long userId) {
        return Result.success(userService.user(userId));
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/edit")
    public Result<Boolean> edit(@RequestBody @Valid WxUserDTO userDTO ) {
        return Result.success(userService.edit(userDTO));
    }

    @ApiOperation("检查登录是否过期")
    @GetMapping("/check")
    public Result<Boolean> check() {
        try{
            StpUtil.checkLogin();
            return Result.success(Boolean.TRUE);
        } catch (Exception e){
            return Result.success(Boolean.FALSE);
        }
    }
}

