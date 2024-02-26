package com.team_manage.controller.teaminfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.service.TeamInfoService;
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
@RequestMapping("/web/team")
@Api(value = "TeamInfoController", tags = {"球队信息接口"})
public class TeamInfoController {
    /**
     * 用户Service
     */
    private final TeamInfoService teamInfoService;


    @ApiOperation("球队信息分页查询")
    @PostMapping("/page")
    public Result<IPage<TeamInfoVO>> page(@RequestBody @Valid TeamInfoQry qry) {
        return Result.success(teamInfoService.pageByQry(qry));
    }

    @ApiOperation("球队信息详情")
    @GetMapping("/detail/{teamId}")
//    @SaCheckPermission("web:user:detail")
    public Result<TeamInfoVO> detail(@PathVariable @NotNull(message = "训练计划ID") Long teamId) {
        return Result.success(teamInfoService.detail(teamId));
    }

    @ApiOperation("新增球队信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid TeamInfoDTO teamInfoDTO) {
        return Result.success(teamInfoService.add(teamInfoDTO));
    }

    @ApiOperation("修改球队信息")
    @PostMapping("/edit/{teamId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long teamId,
                                @RequestBody @Valid TeamInfoDTO teamInfoDTO) {
        return Result.success(teamInfoService.webEdit(teamId, teamInfoDTO));
    }

    @ApiOperation("删除球队信息")
    @PostMapping("/del/{teamId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long teamId) {
        return Result.success(teamInfoService.del(teamId));
    }
}

