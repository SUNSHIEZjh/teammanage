package com.team_manage.controller.user;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.user.query.FollowInfoQry;
import com.team_manage.controller.user.vo.FollowInfoVO;
import com.team_manage.service.FollowInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 关注信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/follow/info")
@Api(value = "WxFollowInfoController", tags = {"WX-关注信息接口"})
public class WxFollowInfoController {

    /**
     * 关注信息Service
     */
    private final FollowInfoService followInfoService;

    @ApiOperation("关注信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:follow:page")
    public Result<IPage<FollowInfoVO>> page(@RequestBody FollowInfoQry qry) {
        return Result.success(followInfoService.pageByQry(qry));
    }

    @ApiOperation("判断是否关注用户")
    @GetMapping("/check/{beUserId}")
//    @SaCheckPermission("wx:follow:check")
    public Result<FollowInfoVO> check(@PathVariable @NotNull(message = "被关注用户ID") Long beUserId) {
        return Result.success(followInfoService.check(beUserId));
    }

    @ApiOperation("关注用户")
    @PostMapping("/follow/{beUserId}")
//    @SaCheckPermission("wx:follow:follow")
    public Result<FollowInfoVO> follow(@PathVariable @NotNull(message = "被关注用户ID") Long beUserId) {
        return Result.success(followInfoService.follow(beUserId));
    }

    @ApiOperation("取消关注")
    @PostMapping("/cancel/{followId}")
//    @SaCheckPermission("wx:follow:cancel")
    public Result<Boolean> cancel(@PathVariable @NotNull(message = "关注ID") Long followId) {
        return Result.success(followInfoService.cancel(followId));
    }
}

