package com.team_manage.controller.user;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.user.query.PersonInfoQry;
import com.team_manage.controller.user.vo.PersonInfoVO;
import com.team_manage.service.PersonInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 人员信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequestMapping("/web/person/info")
@RequiredArgsConstructor
@Api(value = "WebPersonInfoController", tags = {"WEB-人员信息接口"})
public class WebPersonInfoController {
    /**
     * 人员信息Service
     */
    private final PersonInfoService personInfoService;

    @ApiOperation("人员信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:person:page")
    public Result<IPage<PersonInfoVO>> page(@RequestBody PersonInfoQry qry) {
        return Result.success(personInfoService.pageByQry(qry));
    }

    @ApiOperation("人员信息详情")
    @GetMapping("/detail/{personId}")
//    @SaCheckPermission("web:person:detail")
    public Result<PersonInfoVO> detail(@PathVariable @NotNull(message = "人员ID") Long personId) {
        return Result.success(personInfoService.detailById(personId));
    }
}

