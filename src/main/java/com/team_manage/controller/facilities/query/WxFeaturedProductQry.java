package com.team_manage.controller.facilities.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 特色商品Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "特色商品Qry")
@EqualsAndHashCode(callSuper = false)
public class WxFeaturedProductQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 景点ID
     */
    @NotNull(message = "景点ID")
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 当前经度
     */
    @ApiModelProperty("当前经度")
    private Double attractionsLongitude;

    /**
     * 当前维度
     */
    @ApiModelProperty("当前维度")
    private Double attractionsDimension;

}
