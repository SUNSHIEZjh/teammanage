package com.team_manage.controller.facilities;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry1;
import com.team_manage.controller.facilities.vo.SurroundingFacilitiesVO;
import com.team_manage.service.SurroundingFacilitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/wx/surrounding/facilities")
@Api(value = "WxSurroundingFacilitiesController", tags = {"WX-周边设施接口"})
public class WxSurroundingFacilitiesController {

    /**
     * 周边设施Service
     */
    private final SurroundingFacilitiesService surroundingFacilitiesService;

    @ApiOperation("周边设施信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:surrounding:facilities:page")
    public Result<IPage<SurroundingFacilitiesVO>> page(@RequestBody SurroundingFacilitiesQry1 qry) {
        return Result.success(surroundingFacilitiesService.pageByQry1(qry));
    }

    @ApiOperation("周边设施信息详情")
    @GetMapping("/detail/{facilitiesId}")
//    @SaCheckPermission("wx:surrounding:facilities:detail")
    public Result<SurroundingFacilitiesVO> detail(@PathVariable @NotNull(message = "设施ID") Long facilitiesId) {
        return Result.success(surroundingFacilitiesService.detailById(facilitiesId));
    }
}

