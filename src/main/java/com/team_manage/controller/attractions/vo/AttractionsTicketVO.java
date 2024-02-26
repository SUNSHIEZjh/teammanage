package com.team_manage.controller.attractions.vo;

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
 * 景点门票信息VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "景点门票信息VO")
@EqualsAndHashCode(callSuper = false)
public class AttractionsTicketVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 景点ID
     */
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 门票单价
     */
    @ApiModelProperty("门票单价")
    private BigDecimal ticketPrice;

    /**
     * 门票描述
     */
    @ApiModelProperty("门票描述")
    private String ticketDesc;

    /**
     * 已售门票
     */
    @ApiModelProperty("已售门票")
    private Integer soldQuantity;

    /**
     * 门票状态：1、正常 2、禁售
     */
    @ApiModelProperty("门票状态：1、正常 2、禁售")
    private Integer ticketStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;



}
