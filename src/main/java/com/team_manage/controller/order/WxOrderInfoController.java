package com.team_manage.controller.order;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.order.dto.OrderTicketDTO;
import com.team_manage.controller.order.query.WxOrderQry;
import com.team_manage.controller.order.vo.OrderInfoVO;
import com.team_manage.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/wx/order/info")
@Api(value = "WxOrderInfoController", tags = {"WX-订单信息接口"})
public class WxOrderInfoController {

    /**
     * 订单信息Service
     */
    private final OrderInfoService orderInfoService;

    @ApiOperation("景点门票预定")
    @PostMapping("/order")
//    @SaCheckPermission("wx:order:order")
    public Result<Boolean> order(@RequestBody @Valid OrderTicketDTO orderTicketDTO) {
        return Result.success(orderInfoService.order(orderTicketDTO));
    }

    @ApiOperation("景点门票退票")
    @PostMapping("/refund/{orderId}")
//    @SaCheckPermission("wx:order:refund")
    public Result<Boolean> refund(@PathVariable @NotNull(message = "订单ID") Long orderId) {
        return Result.success(orderInfoService.refund(orderId));
    }

    @ApiOperation("我的订单信息分页查询")
    @PostMapping("/mine")
//    @SaCheckPermission("wx:order:mine")
    public Result<IPage<OrderInfoVO>> mine(@RequestBody WxOrderQry qry) {
        return Result.success(orderInfoService.mine(qry));
    }

    @ApiOperation("订单信息详情")
    @PostMapping("/detail/{orderId}")
//    @SaCheckPermission("wx:order:detail")
    public Result<OrderInfoVO> detail(@PathVariable @NotNull(message = "订单ID") Long orderId) {
        return Result.success(orderInfoService.detail(orderId));
    }
}

