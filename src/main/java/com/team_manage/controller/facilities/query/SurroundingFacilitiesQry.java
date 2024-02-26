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
 * 周边设施VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "周边设施VO")
@EqualsAndHashCode(callSuper = false)
public class SurroundingFacilitiesQry extends BaseParam {

    private static final long serialVersionUID = 1L;


    /**
     * 设施名称
     */
    @ApiModelProperty("设施名称")
    private String facilitiesName;

    /**
     * 设施类型
     */
    @ApiModelProperty("设施类型")
    private Integer facilitiesType;

    /**
     * 所属景点
     */
    @NotNull(message = "所属景点")
    @ApiModelProperty("所属景点")
    private Long attractionsId;

    /**
     * 设施状态：1、正常营业 2、暂停营业
     */
    @ApiModelProperty("设施状态：1、正常营业 2、暂停营业")
    private Integer facilitiesStatus;

}
