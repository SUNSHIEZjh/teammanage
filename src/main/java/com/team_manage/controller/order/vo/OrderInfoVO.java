package com.team_manage.controller.order.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "订单信息VO")
public class OrderInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @ApiModelProperty("订单ID")
    private Long orderId;

    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private String orderNum;

    /**
     * 下单时间
     */
    @ApiModelProperty("下单时间")
    private Date orderTime;

    /**
     * 景点ID
     */
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 景点名称
     */
    @ApiModelProperty("景点名称")
    private String attractionsName;

    /**
     * 预定时间
     */
    @ApiModelProperty("预定时间")
    private Date orderDate;

    /**
     * 下单用户
     */
    @ApiModelProperty("下单用户")
    private Long userId;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String userAvatar;

    /**
     * 订单总价
     */
    @ApiModelProperty("订单总价")
    private BigDecimal orderTotal;

    /**
     * 订单状态：1、未使用 2、已完成 3、已取消
     */
    @ApiModelProperty("订单状态：1、未使用 2、已完成 3、已取消")
    private Integer orderStatus;
}
