package com.team_manage.controller.introduction;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.introduction.query.WxIntroductionNodeQry;
import com.team_manage.controller.introduction.vo.WxIntroductionNodeVO;
import com.team_manage.service.IntroductionNodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 攻略节点表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/introduction/node")
@Api(value = "WxIntroductionNodeController", tags = {"WX-攻略节点接口"})
public class WxIntroductionNodeController {

    /**
     * 攻略节点表
     */
    private final IntroductionNodeService introductionNodeService;

    @ApiOperation("攻略节点分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:introduction:node:page")
    public Result<IPage<WxIntroductionNodeVO>> page(@RequestBody @Valid WxIntroductionNodeQry nodeQry) {
        return Result.success(introductionNodeService.pageByQry(nodeQry));
    }
}

