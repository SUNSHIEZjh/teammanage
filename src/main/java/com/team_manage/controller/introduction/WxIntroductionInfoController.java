package com.team_manage.controller.introduction;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.introduction.dto.WxIntroductionInfoDTO;
import com.team_manage.controller.introduction.query.WxIntroductionQry;
import com.team_manage.controller.introduction.query.WxUserIntroductionQry;
import com.team_manage.controller.introduction.vo.WxIntroductionInfoVO;
import com.team_manage.service.IntroductionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 攻略信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/introduction/info")
@Api(value = "WxIntroductionInfoController", tags = {"WX-攻略信息接口"})
public class WxIntroductionInfoController {

    /**
     * 攻略信息Service
     */
    private final IntroductionInfoService introductionInfoService;

    @ApiOperation("攻略信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:introduction:page")
    public Result<IPage<WxIntroductionInfoVO>> page(@RequestBody WxIntroductionQry qry) {
        return Result.success(introductionInfoService.pageByQry(qry));
    }

    @ApiOperation("攻略信息详情")
    @GetMapping("/detail/{introductionId}")
//    @SaCheckPermission("wx:introduction:detail")
    public Result<WxIntroductionInfoVO> detail(@PathVariable @NotNull(message = "攻略ID") Long introductionId) {
        return Result.success(introductionInfoService.detail(introductionId));
    }


    @ApiOperation("新增攻略信息")
    @PostMapping("/add")
//    @SaCheckPermission("wx:introduction:add")
    public Result<Boolean> add(@RequestBody @Valid WxIntroductionInfoDTO introductionInfoDTO) {
        return Result.success(introductionInfoService.add(introductionInfoDTO));
    }

    @ApiOperation("编辑攻略信息")
    @PostMapping("/edit/{introductionId}")
//    @SaCheckPermission("wx:introduction:edit")
    public Result<Boolean> edit(@PathVariable @NotNull(message = "攻略ID") Long introductionId,
                                @RequestBody @Valid WxIntroductionInfoDTO introductionInfoDTO) {
        return Result.success(introductionInfoService.edit(introductionId, introductionInfoDTO));
    }


    @ApiOperation("删除攻略信息")
    @DeleteMapping("/del/{introductionId}")
//    @SaCheckPermission("wx:introduction:del")
    public Result<Boolean> del(@PathVariable @NotNull(message = "攻略ID") Long introductionId) {
        return Result.success(introductionInfoService.del(introductionId));
    }

    @ApiOperation("我的攻略信息分页查询")
    @PostMapping("/mine")
//    @SaCheckPermission("wx:introduction:mine")
    public Result<IPage<WxIntroductionInfoVO>> mine(@RequestBody WxIntroductionQry qry) {
        return Result.success(introductionInfoService.mine(qry));
    }

    @ApiOperation("用户攻略信息分页查询")
    @PostMapping("/user")
//    @SaCheckPermission("wx:introduction:user")
    public Result<IPage<WxIntroductionInfoVO>> user(@RequestBody WxUserIntroductionQry qry) {
        return Result.success(introductionInfoService.user(qry));
    }
}

