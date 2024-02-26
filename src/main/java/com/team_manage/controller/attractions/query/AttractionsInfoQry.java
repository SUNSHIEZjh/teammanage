package com.team_manage.controller.attractions.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class AttractionsInfoQry extends BaseParam {

    /**
     * 景点名称
     */
    @ApiModelProperty("景点名称")
    private String attractionsName;

    /**
     * 景点等级
     */
    @ApiModelProperty("景点等级")
    private String attractionsGrade;

    /**
     * 开放状态：1、正常开放 2、未开放
     */
    @ApiModelProperty("开放状态")
    private Integer openingStatus;


    /**
     * 景点所属省
     */
    @ApiModelProperty("景点所属省")
    private String attractionsProvince;

    /**
     * 景点所属市
     */
    @ApiModelProperty("景点所属市")
    private String attractionsCity;

    /**
     * 景点所属区/县
     */
    @ApiModelProperty("景点所属区/县")
    private String attractionsCounty;

    /**
     * 景点地址
     */
    @ApiModelProperty("景点地址")
    private String attractionsAddress;
}
