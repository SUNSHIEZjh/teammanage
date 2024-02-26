package com.team_manage.controller.user;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.attractions.dto.AttractionsInfoDTO;
import com.team_manage.controller.attractions.query.AttractionsInfoQry;
import com.team_manage.controller.attractions.vo.AttractionsInfoVO;
import com.team_manage.controller.user.dto.PersonInfoDTO;
import com.team_manage.controller.user.query.PersonInfoQry;
import com.team_manage.controller.user.vo.PersonInfoVO;
import com.team_manage.service.AttractionsInfoService;
import com.team_manage.service.PersonInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/wx/person/info")
@RequiredArgsConstructor
@Api(value = "WxPersonInfoController", tags = {"WX-人员信息接口"})
public class WxPersonInfoController {
    /**
     * 人员信息Service
     */
    private final PersonInfoService personInfoService;

    @ApiOperation("人员信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:person:page")
    public Result<IPage<PersonInfoVO>> page(@RequestBody PersonInfoQry qry) {
        // 设置登录用户ID
        qry.setUserId(StpUtil.getLoginIdAsLong());
        return Result.success(personInfoService.pageByQry(qry));
    }

    @ApiOperation("人员信息详情")
    @GetMapping("/detail/{personId}")
//    @SaCheckPermission("wx:person:detail")
    public Result<PersonInfoVO> detail(@PathVariable @NotNull(message = "人员ID") Long personId) {
        return Result.success(personInfoService.detailById(personId));
    }

    @ApiOperation("新增人员信息")
    @PostMapping("/add")
//    @SaCheckPermission("wx:person:add")
    public Result<Boolean> add(@RequestBody @Valid PersonInfoDTO personInfoDTO) {
        return Result.success(personInfoService.add(personInfoDTO));
    }

    @ApiOperation("修改人员信息")
    @PostMapping("/edit/{personId}")
//    @SaCheckPermission("wx:person:edit")
    public Result<Boolean> edit(@NotNull(message = "人员ID") @PathVariable Long personId,
                                @RequestBody @Valid PersonInfoDTO personInfoDTO) {
        return Result.success(personInfoService.edit(personId, personInfoDTO));
    }

    @ApiOperation("删除人员信息")
    @DeleteMapping("/del/{personId}")
//    @SaCheckPermission("wx:person:del")
    public Result<Boolean> del(@NotNull(message = "人员ID") @PathVariable Long personId) {
        return Result.success(personInfoService.del(personId));
    }
}

