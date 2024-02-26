package com.team_manage.controller.order;


import com.team_manage.common.Result;
import com.team_manage.controller.order.vo.OrderItemVO;
import com.team_manage.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 订单明细表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/order/item")
@Api(value = "WxOrderItemController", tags = {"WX-订单明细接口"})
public class WxOrderItemController {

    /**
     * 订单详情Service
     */
    private final OrderItemService orderItemService;

    @ApiOperation("订单详情列表")
    @PostMapping("/list/{orderId}")
//    @SaCheckPermission("wx:order:item:list")
    public Result<List<OrderItemVO>> itemList(@PathVariable @NotNull(message = "订单ID") Long orderId) {
        return Result.success(orderItemService.itemList(orderId));
    }
}

