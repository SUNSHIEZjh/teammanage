package com.team_manage.controller.order.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单明细VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "订单明细VO")
public class OrderItemVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 明细ID
     */
    @ApiModelProperty("明细ID")
    private Long itemId;

    /**
     * 订单ID
     */
    @ApiModelProperty("订单ID")
    private Long orderId;

    /**
     * 门票ID
     */
    @ApiModelProperty("门票ID")
    private Long ticketId;

    /**
     * 门票名称
     */
    @ApiModelProperty("门票名称")
    private String ticketName;

    /**
     * 门票单价
     */
    @ApiModelProperty("门票单价")
    private BigDecimal ticketPrice;

    /**
     * 人员ID
     */
    @ApiModelProperty("人员ID")
    private Long personId;

    /**
     * 人员名称
     */
    @ApiModelProperty("人员名称")
    private String personName;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String personCard;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String personPhone;

    /**
     * 门票数量
     */
    @ApiModelProperty("门票数量")
    private Integer itemNum;

    /**
     * 小计
     */
    @ApiModelProperty("小计")
    private BigDecimal itemTotal;

}
