package com.team_manage.controller.matchinfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.matchinfo.dto.MatchInfoDTO;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.service.MatchInfoService;
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
@RequestMapping("/web/match")
@Api(value = "MatchInfoController", tags = {"赛事信息接口"})
public class MatchInfoController {
    /**
     * 用户Service
     */
    private final MatchInfoService matchInfoService;


    @ApiOperation("赛事信息分页查询")
    @PostMapping("/page")
    public Result<IPage<MatchInfoVO>> page(@RequestBody @Valid MatchInfoQry qry) {
        return Result.success(matchInfoService.pageByQry(qry));
    }

    @ApiOperation("赛事信息详情")
    @GetMapping("/detail/{matchId}")
//    @SaCheckPermission("web:user:detail")
    public Result<MatchInfoVO> detail(@PathVariable @NotNull(message = "训练计划ID") Long matchId) {
        return Result.success(matchInfoService.detail(matchId));
    }

    @ApiOperation("新增赛事信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid MatchInfoDTO matchInfoDTO) {
        return Result.success(matchInfoService.add(matchInfoDTO));
    }

    @ApiOperation("修改赛事信息")
    @PostMapping("/edit/{matchId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long tranPlanId,
                                @RequestBody @Valid MatchInfoDTO matchInfoDTO) {
        return Result.success(matchInfoService.webEdit(tranPlanId, matchInfoDTO));
    }

    @ApiOperation("删除赛事信息")
    @PostMapping("/del/{matchId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long matchId) {
        return Result.success(matchInfoService.del(matchId));
    }
}

