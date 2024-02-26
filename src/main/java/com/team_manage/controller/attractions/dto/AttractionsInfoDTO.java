package com.team_manage.controller.attractions.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 景点信息操作DTO
 * </p>
 *
 * @author ZSL
 * @since 2023-11-29
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "景点信息操作DTO")
@EqualsAndHashCode(callSuper = false)
public class AttractionsInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 景点名称
     */
    @NotBlank(message = "景点名称")
    @ApiModelProperty("景点名称")
    private String attractionsName;

    /**
     * 景点描述
     */
    @NotBlank(message = "景点描述")
    @ApiModelProperty("景点描述")
    private String attractionsDesc;

    /**
     * 景点图片
     */
    @ApiModelProperty("景点图片")
    private String attractionsImages;

    /**
     * 景点等级
     */
    @NotBlank(message = "景点等级")
    @ApiModelProperty("景点等级")
    private String attractionsGrade;

    /**
     * 开放状态：1、正常开放 2、未开放
     */
    @NotNull(message = "开放状态")
    @ApiModelProperty("开放状态")
    private Integer openingStatus;

    /**
     * 开放时间
     */
    @NotBlank(message = "开放时间")
    @ApiModelProperty("开放时间")
    private String openingTime;

    /**
     * 景点所属省
     */
    @NotBlank(message = "景点所属省")
    @ApiModelProperty("景点所属省")
    private String attractionsProvince;

    /**
     * 景点所属市
     */
    @NotBlank(message = "景点所属市")
    @ApiModelProperty("景点所属市")
    private String attractionsCity;

    /**
     * 景点所属区/县
     */
    @NotBlank(message = "景点所属区/县")
    @ApiModelProperty("景点所属区/县")
    private String attractionsCounty;

    /**
     * 景点地址
     */
    @NotBlank(message = "景点地址")
    @ApiModelProperty("景点地址")
    private String attractionsAddress;

    /**
     * 景点经度
     */
    @NotNull(message = "景点经度")
    @ApiModelProperty("景点经度")
    private Double attractionsLongitude;

    /**
     * 景点维度
     */
    @NotNull(message = "景点维度")
    @ApiModelProperty("景点维度")
    private Double attractionsDimension;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String attractionsPhone;


}
