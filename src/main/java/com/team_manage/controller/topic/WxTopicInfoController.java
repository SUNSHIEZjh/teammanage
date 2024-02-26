package com.team_manage.controller.topic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.topic.dto.TopicInfoDTO;
import com.team_manage.controller.topic.query.WxTopicQry;
import com.team_manage.controller.topic.query.WxUserTopicQry;
import com.team_manage.controller.topic.vo.TopicInfoVO;
import com.team_manage.service.TopicInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 话题信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/topic/info")
@Api(value = "WxTopicInfoController", tags = {"WX-话题信息接口"})
public class WxTopicInfoController {

    /**
     * 话题信息Service
     */
    private final TopicInfoService topicInfoService;

    @ApiOperation("话题信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:topic:page")
    public Result<IPage<TopicInfoVO>> page(@RequestBody WxTopicQry qry) {
        return Result.success(topicInfoService.wxPage(qry));
    }

    @ApiOperation("查询我发布的话题信息")
    @PostMapping("/mine")
//    @SaCheckPermission("wx:topic:mine")
    public Result<IPage<TopicInfoVO>> mine(@RequestBody WxTopicQry qry) {
        return Result.success(topicInfoService.mine(qry));
    }

    @ApiOperation("查询用户发布的话题信息")
    @PostMapping("/user")
//    @SaCheckPermission("wx:topic:user")
    public Result<IPage<TopicInfoVO>> user(@RequestBody WxUserTopicQry qry) {
        return Result.success(topicInfoService.user(qry));
    }

    @ApiOperation("话题信息详情")
    @GetMapping("/detail/{topicId}")
//    @SaCheckPermission("wx:topic:detail")
    public Result<TopicInfoVO> detail(@PathVariable @NotNull(message = "话题ID") Long topicId) {
        return Result.success(topicInfoService.detailById(topicId));
    }

    @ApiOperation("新增话题信息")
    @PostMapping("/add")
//    @SaCheckPermission("wx:topic:add")
    public Result<Boolean> add(@RequestBody @Valid TopicInfoDTO topicInfoDTO) {
        return Result.success(topicInfoService.add(topicInfoDTO));
    }

    @ApiOperation("修改话题信息")
    @PostMapping("/edit/{topicId}")
//    @SaCheckPermission("wx:topic:edit")
    public Result<Boolean> edit(@NotNull(message = "话题ID") @PathVariable Long topicId,
                                @RequestBody @Valid TopicInfoDTO topicInfoDTO) {
        return Result.success(topicInfoService.edit(topicId, topicInfoDTO));
    }

    @ApiOperation("删除话题信息")
    @DeleteMapping("/del/{topicId}")
//    @SaCheckPermission("wx:topic:del")
    public Result<Boolean> del(@NotNull(message = "话题ID") @PathVariable Long topicId) {
        return Result.success(topicInfoService.del(topicId));
    }
}

