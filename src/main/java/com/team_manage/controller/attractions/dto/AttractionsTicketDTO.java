package com.team_manage.controller.attractions.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 景点门票信息DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "景点门票信息DTO")
@EqualsAndHashCode(callSuper = false)
public class AttractionsTicketDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 门票名称
     */
    @NotBlank(message = "门票名称")
    @ApiModelProperty("门票名称")
    private String ticketName;

    /**
     * 景点ID
     */
    @NotNull(message = "景点ID")
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 门票单价
     */
    @NotNull(message = "门票单价")
    @ApiModelProperty("门票单价")
    private BigDecimal ticketPrice;

    /**
     * 门票描述
     */
    @NotBlank(message = "门票描述")
    @ApiModelProperty("门票描述")
    private String ticketDesc;

    /**
     * 门票状态：1、正常 2、禁售
     */
    @NotNull(message = "门票状态")
    @ApiModelProperty("门票状态：1、正常 2、禁售")
    private Integer ticketStatus;

}
