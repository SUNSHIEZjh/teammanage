package com.team_manage.controller.topic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.topic.query.WxNotifyQry;
import com.team_manage.controller.topic.vo.NotifyInfoVO;
import com.team_manage.service.NotifyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 消息通知表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/notify/info")
@Api(value = "WxNotifyInfoController", tags = {"WX-消息通知接口"})
public class WxNotifyInfoController {

    /**
     * 消息通知Service
     */
    private final NotifyInfoService notifyInfoService;

    @ApiOperation("用户消息通知分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:notify:page")
    public Result<IPage<NotifyInfoVO>> page(@RequestBody WxNotifyQry qry) {
        return Result.success(notifyInfoService.pageByQry(qry));
    }

    @ApiOperation("批量已读消息")
    @PostMapping("/batch/read")
//    @SaCheckPermission("wx:notify:batch:read")
    public Result<Boolean> read(@RequestBody @NotNull(message = "通知ID列表") List<Long> notifyIds) {
        return Result.success(notifyInfoService.batchRead(notifyIds));
    }

    @ApiOperation("已读所有消息")
    @PostMapping("/read/all")
//    @SaCheckPermission("wx:notify:read:all")
    public Result<Boolean> readAll() {
        return Result.success(notifyInfoService.readAll());
    }
}

