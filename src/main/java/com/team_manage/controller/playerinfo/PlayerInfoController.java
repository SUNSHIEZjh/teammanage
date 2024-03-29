package com.team_manage.controller.playerinfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.playerinfo.dto.PlayerInfoDTO;
import com.team_manage.controller.playerinfo.dto.PlayerOnDepartDTO;
import com.team_manage.controller.playerinfo.query.PlayerInfoQry;
import com.team_manage.controller.playerinfo.vo.PlayerInfoVO;
import com.team_manage.service.AttendanceInfoService;
import com.team_manage.service.PlayerInfoService;
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
@RequestMapping("/web/player")
@Api(value = "PlayerInfoController", tags = {"球员接口"})
public class PlayerInfoController {
    /**
     * 用户Service
     */
    private final PlayerInfoService playerInfoService;


    @ApiOperation("球员管理分页查询")
    @PostMapping("/page")
    public Result<IPage<PlayerInfoVO>> page(@RequestBody @Valid PlayerInfoQry qry) {
        return Result.success(playerInfoService.pageByQry(qry));
    }

    @ApiOperation("球员详情")
    @GetMapping("/detail/{playerId}")
//    @SaCheckPermission("web:user:detail")
    public Result<PlayerInfoVO> detail(@PathVariable @NotNull(message = "球员ID") Long playerId) {
        return Result.success(playerInfoService.detail(playerId));
    }

    @ApiOperation("新增球员信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid PlayerInfoDTO attendanceInfoDTO) {
        return Result.success(playerInfoService.add(attendanceInfoDTO));
    }

    @ApiOperation("编辑球员")
    @PostMapping("/edit/{playerId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long playerId,
                                @RequestBody @Valid PlayerInfoDTO attendanceInfoDTO) {
        return Result.success(playerInfoService.webEdit(playerId, attendanceInfoDTO));
    }

    @ApiOperation("删除球员")
    @PostMapping("/del/{playerId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long playerId) {
        return Result.success(playerInfoService.del(playerId));
    }

    @ApiOperation("人员离职")
    @PostMapping("/depart/{playerId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> depart(@PathVariable @NotNull(message = "用户ID") Long playerId,  @RequestBody @Valid PlayerOnDepartDTO playerOnDepartDTO) {
        return Result.success(playerInfoService.depart(playerId,playerOnDepartDTO));
    }
    @ApiOperation("球员管理列表查询")
    @PostMapping("/list")
    public Result<List<PlayerInfoVO>> list() {
        return Result.success(playerInfoService.getList());
    }


    @ApiOperation("个人中心详情")
    @GetMapping("/user/detail/{userId}")
//    @SaCheckPermission("web:user:detail")
    public Result<PlayerInfoVO> detailUserInfo(@PathVariable @NotNull(message = "用户ID") Long userId) {
        return Result.success(playerInfoService.detailUserInfo(userId));
    }
}

