package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.order.query.WebOrderQry;
import com.team_manage.controller.order.query.WxOrderQry;
import com.team_manage.controller.order.vo.OrderInfoVO;
import com.team_manage.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    /**
     * 分页查询我的订单数据
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<OrderInfoVO>
     */
    IPage<OrderInfoVO> mine(@Param("qry") WxOrderQry qry, @Param("pages") IPage<OrderInfoVO> pages);

    /**
     * 订单信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<OrderInfoVO>
     */
    IPage<OrderInfoVO> pageByQry(@Param("qry") WebOrderQry qry, @Param("pages") IPage<OrderInfoVO> pages);

    /**
     * 订单信息详情
     *
     * @param orderId 订单ID
     * @return OrderInfoVO
     */
    OrderInfoVO detail(@Param("orderId") Long orderId);
}
