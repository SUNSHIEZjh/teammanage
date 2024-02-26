package com.team_manage.controller.noticeinfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.noticeinfo.dto.NoticeInfoDTO;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.controller.noticeinfo.vo.NoticeInfoVO;
import com.team_manage.service.NoticeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 公告信息前端控制器
 * </p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/notice")
@Api(value = "NoticeInfoController", tags = {"公告信息接口"})
public class NoticeInfoController {
    /**
     * 用户Service
     */
    private final NoticeInfoService noticeInfoService;


    @ApiOperation("公告信息分页查询")
    @PostMapping("/page")

    public Result<IPage<NoticeInfoVO>> page(@RequestBody @Valid NoticeInfoQry qry) {
        return Result.success(noticeInfoService.pageByQry(qry));
    }

    @ApiOperation("公告信息详情")
    @GetMapping("/detail/{noticeId}")
//    @SaCheckPermission("web:user:detail")
    public Result<NoticeInfoVO> detail(@PathVariable @NotNull(message = "训练计划ID") Long noticeId) {
        return Result.success(noticeInfoService.detail(noticeId));
    }

    @ApiOperation("新增公告信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid NoticeInfoDTO noticeInfoDTO) {
        return Result.success(noticeInfoService.add(noticeInfoDTO));
    }

    @ApiOperation("修改公告信息")
    @PostMapping("/edit/{noticeId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long noticeId,
                                @RequestBody @Valid NoticeInfoDTO noticeInfoDTO) {
        return Result.success(noticeInfoService.webEdit(noticeId, noticeInfoDTO));
    }

    @ApiOperation("删除公告信息")
    @PostMapping("/del/{noticeId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long noticeId) {
        return Result.success(noticeInfoService.del(noticeId));
    }
}

