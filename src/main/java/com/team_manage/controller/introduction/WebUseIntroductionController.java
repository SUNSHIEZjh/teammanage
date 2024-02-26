package com.team_manage.controller.introduction;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 攻略使用表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/use/introduction")
@Api(value = "WebUseIntroductionController", tags = {"WEB-攻略使用接口"})
public class WebUseIntroductionController {

}

