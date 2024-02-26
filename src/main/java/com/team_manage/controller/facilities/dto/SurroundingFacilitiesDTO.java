package com.team_manage.controller.facilities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value = "周边设施DTO")
@EqualsAndHashCode(callSuper = false)
public class SurroundingFacilitiesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设施名称
     */
    @NotBlank(message = "设施名称")
    @ApiModelProperty("设施名称")
    private String facilitiesName;

    /**
     * 设施封面
     */
    @ApiModelProperty("设施封面")
    private String facilitiesImg;

    /**
     * 设施类型
     */
    @NotNull(message = "设施类型")
    @ApiModelProperty("设施类型")
    private Integer facilitiesType;

    /**
     * 设施描述
     */
    @NotBlank(message = "设施描述")
    @ApiModelProperty("设施描述")
    private String facilitiesDesc;

    /**
     * 设施经度
     */
    @NotNull(message = "设施经度")
    @ApiModelProperty("设施经度")
    private Double facilitiesLongitude;

    /**
     * 设施纬度
     */
    @NotNull(message = "设施纬度")
    @ApiModelProperty("设施纬度")
    private Double facilitiesDimension;

    /**
     * 所属景点
     */
    @NotNull(message = "所属景点")
    @ApiModelProperty("所属景点")
    private Long attractionsId;

    /**
     * 设施状态：1、正常营业 2、暂停营业
     */
    @NotNull(message = "设施状态：1、正常营业 2、暂停营业")
    @ApiModelProperty("设施状态：1、正常营业 2、暂停营业")
    private Integer facilitiesStatus;
}
