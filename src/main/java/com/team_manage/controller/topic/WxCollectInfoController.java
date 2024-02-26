package com.team_manage.controller.topic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.topic.dto.CollectDTO;
import com.team_manage.controller.topic.query.WxCollectQry;
import com.team_manage.controller.topic.vo.CollectIntroductionVO;
import com.team_manage.controller.topic.vo.CollectTopicVO;
import com.team_manage.service.CollectInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 收藏信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/collect/info")
@Api(value = "WxCollectInfoController", tags = {"WX-收藏信息接口"})
public class WxCollectInfoController {

    /**
     * 收藏Service
     */
    private final CollectInfoService collectInfoService;

    @ApiOperation("分页查询用户收藏的帖子信息")
    @PostMapping("/topic/page")
//    @SaCheckPermission("wx:collect:topic:page")
    public Result<IPage<CollectTopicVO>> topicPage(@RequestBody WxCollectQry qry) {
        return Result.success(collectInfoService.topicPage(qry));
    }

    @ApiOperation("分页查询用户收藏的攻略信息")
    @PostMapping("/introduction/page")
//    @SaCheckPermission("wx:collect:introduction:page")
    public Result<IPage<CollectIntroductionVO>> introductionPage(@RequestBody WxCollectQry qry) {
        return Result.success(collectInfoService.introductionPage(qry));
    }

    @ApiOperation("新增收藏")
    @PostMapping("/add")
//    @SaCheckPermission("wx:collect:add")
    public Result<Boolean> add(@RequestBody @Valid CollectDTO collectDTO) {
        return Result.success(collectInfoService.add(collectDTO));
    }

    @ApiOperation("取消收藏")
    @PostMapping("/cancel/{businessId}")
//    @SaCheckPermission("wx:collect:cancel")
    public Result<Boolean> cancel(@PathVariable @NotNull(message = "业务ID") Long businessId) {
        return Result.success(collectInfoService.cancel(businessId));
    }
}

