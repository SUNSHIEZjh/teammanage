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
public class FeaturedProductQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 所属设施
     */
    @NotNull(message = "所属设施")
    @ApiModelProperty("所属设施")
    private Long facilitiesId;

}
