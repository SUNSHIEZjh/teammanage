package com.team_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.order.vo.OrderItemVO;
import com.team_manage.entity.OrderItem;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface OrderItemService extends IService<OrderItem> {

    /**
     * 订单明细列表
     *
     * @param orderId 订单ID
     * @return List<OrderItem>
     */
    List<OrderItemVO> itemList(Long orderId);
}
