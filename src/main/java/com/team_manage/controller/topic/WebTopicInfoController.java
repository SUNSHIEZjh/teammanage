package com.team_manage.controller.topic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.topic.query.WebTopicQry;
import com.team_manage.controller.topic.vo.TopicInfoVO;
import com.team_manage.service.TopicInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/web/topic/info")
@Api(value = "WebTopicInfoController", tags = {"WEB-话题信息接口"})
public class WebTopicInfoController {
    /**
     * 话题信息Service
     */
    private final TopicInfoService topicInfoService;

    @ApiOperation("话题信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:topic:page")
    public Result<IPage<TopicInfoVO>> page(@RequestBody WebTopicQry qry) {
        return Result.success(topicInfoService.webPage(qry));
    }

    @ApiOperation("话题信息详情")
    @GetMapping("/detail/{topicId}")
//    @SaCheckPermission("web:topic:detail")
    public Result<TopicInfoVO> detail(@PathVariable @NotNull(message = "话题ID") Long topicId) {
        return Result.success(topicInfoService.detailById(topicId));
    }

    @ApiOperation("删除话题信息")
    @DeleteMapping("/del/{topicId}")
//    @SaCheckPermission("web:topic:del")
    public Result<Boolean> del(@NotNull(message = "话题ID") @PathVariable Long topicId) {
        return Result.success(topicInfoService.del(topicId));
    }
}

