package com.team_manage.mapper;

import com.team_manage.controller.order.vo.OrderItemVO;
import com.team_manage.entity.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

    /**
     * 订单明细列表
     *
     * @param orderId 订单ID
     * @return List<OrderItem>
     */
    List<OrderItemVO> itemList(@Param("orderId") Long orderId);
}
