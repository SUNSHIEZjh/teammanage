package com.team_manage.controller.facilities;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.facilities.dto.FeaturedProductDTO;
import com.team_manage.controller.facilities.query.FeaturedProductQry;
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
@RequestMapping("/web/featured/product")
@Api(value = "WebFeaturedProductController", tags = {"WEB-特色商品接口"})
public class WebFeaturedProductController {
    /**
     * 特色商品Service
     */
    private final FeaturedProductService featuredProductService;

    @ApiOperation("特色商品信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:featured:product:page")
    public Result<IPage<FeaturedProductVO>> page(@Valid @RequestBody FeaturedProductQry qry) {
        return Result.success(featuredProductService.pageByQry(qry));
    }

    @ApiOperation("特色商品信息详情")
    @GetMapping("/detail/{productId}")
//    @SaCheckPermission("web:featured:product:detail")
    public Result<FeaturedProductVO> detail(@PathVariable @NotNull(message = "商品ID") Long productId) {
        return Result.success(featuredProductService.detailById(productId));
    }

    @ApiOperation("新增特色商品信息")
    @PostMapping("/add")
//    @SaCheckPermission("web:featured:product:add")
    public Result<Boolean> add(@RequestBody @Valid FeaturedProductDTO featuredProductDTO) {
        return Result.success(featuredProductService.add(featuredProductDTO));
    }

    @ApiOperation("修改特色商品信息")
    @PostMapping("/edit/{productId}")
//    @SaCheckPermission("web:featured:product:edit")
    public Result<Boolean> edit(@NotNull(message = "商品ID") @PathVariable Long productId,
                                @RequestBody @Valid FeaturedProductDTO featuredProductDTO) {
        return Result.success(featuredProductService.edit(productId, featuredProductDTO));
    }

    @ApiOperation("删除特色商品信息")
    @DeleteMapping("/del/{productId}")
//    @SaCheckPermission("web:featured:product:del")
    public Result<Boolean> del(@NotNull(message = "商品ID") @PathVariable Long productId) {
        return Result.success(featuredProductService.del(productId));
    }
}

