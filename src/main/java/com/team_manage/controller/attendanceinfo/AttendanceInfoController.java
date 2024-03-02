package com.team_manage.controller.attendanceinfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.attendanceinfo.dto.AttendanceInfoDTO;
import com.team_manage.controller.attendanceinfo.query.AttendanceInfoQry;
import com.team_manage.controller.attendanceinfo.vo.AttendanceInfoVO;
import com.team_manage.service.AttendanceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 公告信息前端控制器
 * </p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/attendance")
@Api(value = "AttendanceInfoController", tags = {"考勤管理接口"})
public class AttendanceInfoController {
    /**
     * 用户Service
     */
    private final AttendanceInfoService attendanceInfoService;


    @ApiOperation("考勤管理分页查询")
    @PostMapping("/page")

    public Result<IPage<AttendanceInfoVO>> page(@RequestBody @Valid AttendanceInfoQry qry) {
        return Result.success(attendanceInfoService.pageByQry(qry));
    }

    @ApiOperation("考勤管理明细")
    @GetMapping("/detail/{playerId}")
//    @SaCheckPermission("web:user:detail")
    public Result<List<AttendanceInfoVO>> detail(@PathVariable @NotNull(message = "球员ID") Long playerId) {
        return Result.success(attendanceInfoService.detail(playerId));
    }

    @ApiOperation("新增考勤管理信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid AttendanceInfoDTO attendanceInfoDTO) {
        return Result.success(attendanceInfoService.add(attendanceInfoDTO));
    }
/*
    @ApiOperation("编辑考勤管理")
    @PostMapping("/edit/{attendanceId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long attendanceId,
                                @RequestBody @Valid AttendanceInfoDTO attendanceInfoDTO) {
        return Result.success(attendanceInfoService.webEdit(attendanceId, attendanceInfoDTO));
    }

    @ApiOperation("删除考勤管理")
    @PostMapping("/del/{attendanceId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long attendanceId) {
        return Result.success(attendanceInfoService.del(attendanceId));
    }*/
}

