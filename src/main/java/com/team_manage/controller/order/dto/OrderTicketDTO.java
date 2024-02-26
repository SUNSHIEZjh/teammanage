package com.team_manage.controller.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 预定门票DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "预定门票DTO")
public class OrderTicketDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 景点ID
     */
    @NotNull(message = "景点ID")
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 预定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "预定时间")
    @ApiModelProperty("预定时间")
    private Date orderDate;

    /**
     * 订单总价
     */
    @NotNull(message = "订单总价")
    @ApiModelProperty("订单总价")
    private BigDecimal orderTotal;

    /**
     * 门票ID
     */
    @NotNull(message = "门票ID")
    @ApiModelProperty("门票ID")
    private Long ticketId;

    /**
     * 人员ID列表
     */
    @NotEmpty(message = "人员ID列表")
    @ApiModelProperty("人员ID列表")
    private List<Long> personIds;


}
