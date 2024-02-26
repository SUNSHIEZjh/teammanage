package com.team_manage.controller.introduction;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.introduction.dto.AuditDTO;
import com.team_manage.controller.introduction.query.WebIntroductionQry;
import com.team_manage.controller.introduction.vo.WxIntroductionInfoVO;
import com.team_manage.service.IntroductionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/web/introduction/info")
@Api(value = "WebIntroductionInfoController", tags = {"WEB-攻略信息接口"})
public class WebIntroductionInfoController {

    /**
     * 攻略信息Service
     */
    private final IntroductionInfoService introductionInfoService;

    @ApiOperation("攻略信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:introduction:page")
    public Result<IPage<WxIntroductionInfoVO>> page(@RequestBody WebIntroductionQry qry) {
        return Result.success(introductionInfoService.pageByQry(qry));
    }

    @ApiOperation("攻略信息详情")
    @GetMapping("/detail/{introductionId}")
//    @SaCheckPermission("web:introduction:detail")
    public Result<WxIntroductionInfoVO> detail(@PathVariable @NotNull(message = "攻略ID") Long introductionId) {
        return Result.success(introductionInfoService.detail(introductionId));
    }

    @ApiOperation("攻略信息审核")
    @PostMapping("/audit")
//    @SaCheckPermission("web:introduction:audit")
    public Result<Boolean> audit(@RequestBody AuditDTO auditDTO) {
        return Result.success(introductionInfoService.audit(auditDTO));
    }
}

