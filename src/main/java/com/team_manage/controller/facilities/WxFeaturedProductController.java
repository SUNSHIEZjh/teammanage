package com.team_manage.controller.facilities;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.facilities.query.FeaturedProductQry;
import com.team_manage.controller.facilities.query.WxFeaturedProductQry;
import com.team_manage.controller.facilities.vo.FeaturedProductVO;
import com.team_manage.service.FeaturedProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 特色商品表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/featured/product")
@Api(value = "WxFeaturedProductController", tags = {"WX-特色商品接口"})
public class WxFeaturedProductController {

    /**
     * 特色商品详情
     */
    private final FeaturedProductService featuredProductService;

    @ApiOperation("特色商品信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:featured:product:page")
    public Result<IPage<FeaturedProductVO>> page(@Valid @RequestBody FeaturedProductQry qry) {
        return Result.success(featuredProductService.pageByQry(qry));
    }

    @ApiOperation("特色商品信息详情")
    @GetMapping("/detail/{productId}")
//    @SaCheckPermission("wx:featured:product:detail")
    public Result<FeaturedProductVO> detail(@PathVariable @NotNull(message = "商品ID") Long productId) {
        return Result.success(featuredProductService.detailById(productId));
    }

    @ApiOperation("特色商品信息分页查询（带门店）")
    @PostMapping("/page1")
//    @SaCheckPermission("wx:featured:product:page1")
    public Result<IPage<FeaturedProductVO>> page1(@Valid @RequestBody WxFeaturedProductQry qry) {
        return Result.success(featuredProductService.pageByQry1(qry));
    }
}

