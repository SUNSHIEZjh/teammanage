package com.team_manage.controller.attractions.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 景点门票查询Qry
 * </p>
 *
 * @author ZSL
 * @since 2023-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("景点门票查询Qry")
public class AttractionsTicketQry extends BaseParam {

    /**
     * 景点ID
     */
    @NotNull(message = "景点ID")
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 门票名称
     */
    @ApiModelProperty("门票名称")
    private String ticketName;

    /**
     * 门票状态：1、正常 2、禁售
     */
    @ApiModelProperty("门票状态：1、正常 2、禁售")
    private Integer ticketStatus;
}
