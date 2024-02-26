package com.team_manage.controller.param;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 参数表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/param")
@Api(value = "SysParamController", tags = {"参数信息接口"})
public class SysParamController {

}

