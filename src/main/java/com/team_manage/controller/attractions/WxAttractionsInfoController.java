package com.team_manage.controller.attractions;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.attractions.query.AttractionsInfoQry1;
import com.team_manage.controller.attractions.vo.AttractionsInfoVO;
import com.team_manage.service.AttractionsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/wx/attractions/info")
@Api(value = "WxAttractionsInfoController", tags = {"WX-景点信息接口"})
public class WxAttractionsInfoController {

    /**
     * 景点信息Service
     */
    private final AttractionsInfoService attractionsInfoService;

    @ApiOperation("景点信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:attractions:page")
    public Result<IPage<AttractionsInfoVO>> page(@RequestBody AttractionsInfoQry1 qry) {
        return Result.success(attractionsInfoService.pageByQry1(qry));
    }

    @ApiOperation("景点信息详情")
    @GetMapping("/detail/{attractionsId}")
//    @SaCheckPermission("wx:attractions:detail")
    public Result<AttractionsInfoVO> detail(@PathVariable @NotNull(message = "景点ID") Long attractionsId) {
        return Result.success(attractionsInfoService.detailById(attractionsId));
    }
}

