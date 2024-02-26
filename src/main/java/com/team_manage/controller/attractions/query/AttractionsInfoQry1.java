package com.team_manage.controller.attractions.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 景点查询Qry
 * </p>
 *
 * @author ZSL
 * @since 2023-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("景点查询Qry")
public class AttractionsInfoQry1 extends BaseParam {

    /**
     * 景点名称
     */
    @ApiModelProperty("景点名称")
    private String attractionsName;

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
