package com.team_manage.controller.tranplaninfo;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.tranplaninfo.dto.TranPlanInfoDTO;
import com.team_manage.controller.tranplaninfo.query.TranPlanInfoQry;
import com.team_manage.controller.tranplaninfo.vo.TranPlanInfoVO;
import com.team_manage.controller.user.dto.LoginDTO;
import com.team_manage.controller.user.dto.WebUserDTO;
import com.team_manage.controller.user.query.WebUserQry;
import com.team_manage.controller.user.vo.WebLoginVO;
import com.team_manage.controller.user.vo.WebUserVO;
import com.team_manage.service.SysUserService;
import com.team_manage.service.TranPlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 训练计划表 前端控制器
 * </p>
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/tranplan")
@Api(value = "TranPlanInfoController", tags = {"训练计划接口"})
public class TranPlanInfoController {
    /**
     * 用户Service
     */
    private final TranPlanInfoService tranPlanInfoService;


    @ApiOperation("训练计划分页查询")
    @PostMapping("/page")

    public Result<IPage<TranPlanInfoVO>> page(@RequestBody @Valid TranPlanInfoQry qry) {
        return Result.success(tranPlanInfoService.pageByQry(qry));
    }

    @ApiOperation("训练计划信息详情")
    @GetMapping("/detail/{tranPlanId}")
//    @SaCheckPermission("web:user:detail")
    public Result<TranPlanInfoVO> detail(@PathVariable @NotNull(message = "训练计划ID") Long tranPlanId) {
        return Result.success(tranPlanInfoService.detail(tranPlanId));
    }

    @ApiOperation("新增训练计划")
    @PostMapping("/add")
//    @SaCheckPermission("web:user:add")
    public Result<Boolean> add(@RequestBody @Valid TranPlanInfoDTO tranPlanInfoDTO ) {
        return Result.success(tranPlanInfoService.add(tranPlanInfoDTO));
    }

    @ApiOperation("修改训练计划")
    @PostMapping("/edit/{tranPlanId}")
//    @SaCheckPermission("web:user:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "用户ID") Long tranPlanId,
                                @RequestBody @Valid TranPlanInfoDTO tranPlanInfoDTO ) {
        return Result.success(tranPlanInfoService.webEdit(tranPlanId, tranPlanInfoDTO));
    }

    @ApiOperation("删除训练计划")
    @PostMapping("/del/{tranPlanId}")
//    @SaCheckPermission("web:user:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "用户ID") Long tranPlanId) {
        return Result.success(tranPlanInfoService.del(tranPlanId));
    }
}

