package com.team_manage.controller.facilities;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.facilities.dto.SurroundingFacilitiesDTO;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry;
import com.team_manage.controller.facilities.vo.SurroundingFacilitiesVO;
import com.team_manage.service.SurroundingFacilitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 周边设施表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/surrounding/facilities")
@Api(value = "WebSurroundingFacilitiesController", tags = {"WEB-周边设施接口"})
public class WebSurroundingFacilitiesController {

    /**
     * 周边设施Service
     */
    private final SurroundingFacilitiesService surroundingFacilitiesService;

    @ApiOperation("周边设施信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:surrounding:facilities:page")
    public Result<IPage<SurroundingFacilitiesVO>> page(@RequestBody SurroundingFacilitiesQry qry) {
        return Result.success(surroundingFacilitiesService.pageByQry(qry));
    }

    @ApiOperation("周边设施信息详情")
    @GetMapping("/detail/{facilitiesId}")
//    @SaCheckPermission("web:surrounding:facilities:detail")
    public Result<SurroundingFacilitiesVO> detail(@PathVariable @NotNull(message = "设施ID") Long facilitiesId) {
        return Result.success(surroundingFacilitiesService.detailById(facilitiesId));
    }

    @ApiOperation("新增周边设施信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:surrounding:facilities:add")
    public Result<Boolean> add(@RequestBody @Valid SurroundingFacilitiesDTO surroundingFacilitiesDTO) {
        return Result.success(surroundingFacilitiesService.add(surroundingFacilitiesDTO));
    }

    @ApiOperation("修改周边设施信息")
    @PostMapping("/edit/{facilitiesId}")
//    @SaCheckPermission("web:surrounding:facilities:edit")
    public Result<Boolean> edit(@NotNull(message = "设施ID") @PathVariable Long facilitiesId,
                                @RequestBody @Valid SurroundingFacilitiesDTO surroundingFacilitiesDTO) {
        return Result.success(surroundingFacilitiesService.edit(facilitiesId, surroundingFacilitiesDTO));
    }

    @ApiOperation("删除周边设施信息")
    @DeleteMapping("/del/{facilitiesId}")
//    @SaCheckPermission("web:surrounding:facilities:del")
    public Result<Boolean> del(@NotNull(message = "设施ID") @PathVariable Long facilitiesId) {
        return Result.success(surroundingFacilitiesService.del(facilitiesId));
    }

    @ApiOperation("修改周边设施状态")
    @PostMapping("/status/{facilitiesId}")
//    @SaCheckPermission("web:attractions:status")
    public Result<Boolean> status(@NotNull(message = "设施ID") @PathVariable Long facilitiesId,
                                  @RequestParam @NotNull(message = "设施状态：1、正常营业 2、暂停营业") Integer facilitiesStatus) {
        return Result.success(surroundingFacilitiesService.status(facilitiesId, facilitiesStatus));
    }
}

