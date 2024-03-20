package com.team_manage.controller.playscore;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.playscore.dto.PlayerScoreRecordDTO;
import com.team_manage.controller.playscore.query.PlayerScoreRecordQry;
import com.team_manage.controller.playscore.vo.PlayerScoreRecordVO;
import com.team_manage.service.PlayScoreRecordService;
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
@RequestMapping("/web/play/score")
@Api(value = "PlayScoreRecordController", tags = {"技术得分接口"})
public class PlayScoreRecordController {
    /**
     * 用户Service
     */
    private final PlayScoreRecordService playScoreRecordService;


    @ApiOperation("球员技术得分分页查询")
    @PostMapping("/page")
    public Result<IPage<PlayerScoreRecordVO>> page(@RequestBody @Valid PlayerScoreRecordQry qry) {
        return Result.success(playScoreRecordService.pageByQry(qry));
    }

    @ApiOperation("球队得分详情")
    @GetMapping("/detail/{playerScoreId}")
//    @SaCheckPermission("web:user:detail")
    public Result<PlayerScoreRecordVO> detail(@PathVariable @NotNull(message = "球员得分ID") Long playerScoreId) {
        return Result.success(playScoreRecordService.detail(playerScoreId));
    }

    @ApiOperation("新增球员技术信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid PlayerScoreRecordDTO playerScoreRecordDTO) {
        return Result.success(playScoreRecordService.add(playerScoreRecordDTO));
    }

    @ApiOperation("修改球员技术得分信息")
    @PostMapping("/edit/{playerScoreId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "技术得分ID") Long playerScoreId,
                                @RequestBody @Valid PlayerScoreRecordDTO playerScoreRecordDTO) {
        return Result.success(playScoreRecordService.webEdit(playerScoreId, playerScoreRecordDTO));
    }

    @ApiOperation("删除球员技术得分信息")
    @PostMapping("/del/{playerScoreId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "技术得分ID") Long playerScoreId) {
        return Result.success(playScoreRecordService.del(playerScoreId));
    }

    @ApiOperation("球员技术得分列表查询")
    @PostMapping("/detail/list/{playerId}")
    public Result<List<PlayerScoreRecordVO>> detailList(@PathVariable @NotNull(message = "球员ID") Long playerId) {
        return Result.success(playScoreRecordService.detailList(playerId));
    }
}

