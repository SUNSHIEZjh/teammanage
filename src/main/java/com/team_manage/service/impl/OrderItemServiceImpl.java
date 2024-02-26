package com.team_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.order.vo.OrderItemVO;
import com.team_manage.entity.OrderItem;
import com.team_manage.mapper.OrderItemMapper;
import com.team_manage.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

    /**
     * 订单明细列表
     *
     * @param orderId 订单ID
     * @return List<OrderItem>
     */
    @Override
    public List<OrderItemVO> itemList(Long orderId) {
        return baseMapper.itemList(orderId);
    }
}
