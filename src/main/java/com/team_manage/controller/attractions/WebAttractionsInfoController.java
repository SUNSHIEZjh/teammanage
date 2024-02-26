package com.team_manage.controller.attractions;


import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.attractions.dto.AttractionsInfoDTO;
import com.team_manage.controller.attractions.query.AttractionsInfoQry;
import com.team_manage.controller.attractions.vo.AttractionsInfoVO;
import com.team_manage.service.AttractionsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 景点信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/attractions/info")
@Api(value = "WebAttractionsInfoController", tags = {"WEB-景点信息接口"})
public class WebAttractionsInfoController {

    /**
     * 景点信息Service
     */
    private final AttractionsInfoService attractionsInfoService;

    @ApiOperation("景点信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:attractions:page")
    public Result<IPage<AttractionsInfoVO>> page(@RequestBody AttractionsInfoQry qry) {
        return Result.success(attractionsInfoService.pageByQry(qry));
    }

    @ApiOperation("景点信息详情")
    @GetMapping("/detail/{attractionsId}")
//    @SaCheckPermission("web:attractions:detail")
    public Result<AttractionsInfoVO> detail(@PathVariable @NotNull(message = "景点ID") Long attractionsId) {
        return Result.success(attractionsInfoService.detailById(attractionsId));
    }

    @ApiOperation("新增景点信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:attractions:add")
    public Result<Boolean> add(@RequestBody @Valid AttractionsInfoDTO attractionsInfoDTO) {
        return Result.success(attractionsInfoService.add(attractionsInfoDTO));
    }

    @ApiOperation("修改景点信息")
    @PostMapping("/edit/{attractionsId}")
//    @SaCheckPermission("web:attractions:edit")
    public Result<Boolean> edit(@NotNull(message = "景点ID") @PathVariable Long attractionsId,
                                @RequestBody @Valid AttractionsInfoDTO attractionsInfoDTO) {
        return Result.success(attractionsInfoService.edit(attractionsId, attractionsInfoDTO));
    }

    @ApiOperation("删除景点信息")
    @DeleteMapping("/del/{attractionsId}")
//    @SaCheckPermission("web:attractions:del")
    public Result<Boolean> del(@NotNull(message = "景点ID") @PathVariable Long attractionsId) {
        return Result.success(attractionsInfoService.del(attractionsId));
    }

    @ApiOperation("修改景点开放状态")
    @PostMapping("/status/{attractionsId}")
//    @SaCheckPermission("web:attractions:status")
    public Result<Boolean> status(@NotNull(message = "景点ID") @PathVariable Long attractionsId,
                                  @RequestParam @NotNull(message = "开放状态：1、正常开放 2、未开放") Integer openingStatus) {
        return Result.success(attractionsInfoService.status(attractionsId, openingStatus));
    }
}

