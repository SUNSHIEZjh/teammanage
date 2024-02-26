package com.team_manage.controller.order;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.order.query.WebOrderQry;
import com.team_manage.controller.order.query.WxOrderQry;
import com.team_manage.controller.order.vo.OrderInfoVO;
import com.team_manage.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 订单信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/web/order/info")
@Api(value = "WebOrderInfoController", tags = {"WEB-订单信息接口"})
public class WebOrderInfoController {

    /**
     * 订单信息Service
     */
    private final OrderInfoService orderInfoService;

    @ApiOperation("订单信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:order:page")
    public Result<IPage<OrderInfoVO>> page(@RequestBody WebOrderQry qry) {
        return Result.success(orderInfoService.pageByQry(qry));
    }

    @ApiOperation("订单信息详情")
    @PostMapping("/detail/{orderId}")
//    @SaCheckPermission("web:order:detail")
    public Result<OrderInfoVO> detail(@PathVariable @NotNull(message = "订单ID") Long orderId) {
        return Result.success(orderInfoService.detail(orderId));
    }

    @ApiOperation("设置订单完成")
    @PostMapping("/success/{orderId}")
//    @SaCheckPermission("web:order:success")
    public Result<Boolean> success(@PathVariable @NotNull(message = "订单ID") Long orderId) {
        return Result.success(orderInfoService.success(orderId));
    }
}

