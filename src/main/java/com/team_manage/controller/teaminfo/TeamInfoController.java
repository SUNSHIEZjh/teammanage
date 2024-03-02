package com.team_manage.controller.teaminfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.dto.TeamPlayerInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.controller.teaminfo.vo.TeamPlayerInfoVO;
import com.team_manage.service.TeamInfoService;
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

    @ApiOperation("球队球员列表查询")
    @PostMapping("/user/{teamId}")
    public Result<List<TeamPlayerInfoVO>> teamPlayerList(@PathVariable @Valid Long teamId) {
        return Result.success(teamInfoService.teamPlayerList(teamId));
    }

    /**
     * 添加球员
     * @param teamId 球队ID
     * @param teamPlayerInfoDTO 球队球员信息
     * @return 成功/失败
     */
    @ApiOperation("球队球员新增")
    @PostMapping("/user/add/{teamId}")
    public Result<Boolean> teamPlayerAdd(@PathVariable @Valid Long teamId, @RequestBody @Valid TeamPlayerInfoDTO teamPlayerInfoDTO) {
        return Result.success(teamInfoService.teamPlayerAdd(teamId, teamPlayerInfoDTO));
    }

    /**
     * 移除球员
     * @param teamPlayerId 球队球员信息ID
     * @return   成功/失败
     */
    @ApiOperation("球队球员移除")
    @PostMapping("/user/remove/{teamPlayerId}")
    public Result<Boolean> teamPlayerRemove(@PathVariable @Valid Long teamPlayerId) {
        return Result.success(teamInfoService.teamPlayerRemove(teamPlayerId));
    }

    @ApiOperation("球队列表查询")
    @PostMapping("/list")
    public Result<List<TeamInfoVO>> teamPlayerList() {
        return Result.success(teamInfoService.teamList());
    }

}

