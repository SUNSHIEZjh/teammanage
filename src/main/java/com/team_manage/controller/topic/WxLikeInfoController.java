package com.team_manage.controller.topic;


import com.team_manage.common.Result;
import com.team_manage.controller.topic.dto.LikeDTO;
import com.team_manage.service.LikeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 点赞信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/like/info")
@Api(value = "WxLikeInfoController", tags = {"WX-点赞信息接口"})
public class WxLikeInfoController {

    /**
     * 点赞信息Service
     */
    private final LikeInfoService likeInfoService;

    @ApiOperation("新增点赞")
    @PostMapping("/add")
//    @SaCheckPermission("wx:like:add")
    public Result<Boolean> add(@RequestBody @Valid LikeDTO likeDTO) {
        return Result.success(likeInfoService.add(likeDTO));
    }

    @ApiOperation("取消点赞")
    @PostMapping("/cancel/{businessId}")
//    @SaCheckPermission("wx:like:cancel")
    public Result<Boolean> cancel(@PathVariable @NotNull(message = "业务ID") Long businessId) {
        return Result.success(likeInfoService.cancel(businessId));
    }
}

