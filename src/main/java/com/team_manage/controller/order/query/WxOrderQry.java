package com.team_manage.controller.order.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 微信订单Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "微信订单Qry")
@EqualsAndHashCode(callSuper = false)
public class WxOrderQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private String orderNum;

    /**
     * 订单状态：1、未使用 2、已完成 3、已取消
     */
    @ApiModelProperty("订单状态：1、未使用 2、已完成 3、已取消")
    private Integer orderStatus;

    /**
     * 登录用户
     */
    @ApiModelProperty(hidden = true)
    private Long userId;

}
