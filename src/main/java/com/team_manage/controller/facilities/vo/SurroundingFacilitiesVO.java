package com.team_manage.controller.facilities.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class SurroundingFacilitiesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设施ID
     */
    @ApiModelProperty("设施ID")
    private Long facilitiesId;

    /**
     * 设施名称
     */
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
    @ApiModelProperty("设施类型")
    private Integer facilitiesType;

    /**
     * 设施描述
     */
    @ApiModelProperty("设施描述")
    private String facilitiesDesc;

    /**
     * 设施经度
     */
    @ApiModelProperty("设施经度")
    private Double facilitiesLongitude;

    /**
     * 设施维度
     */
    @ApiModelProperty("设施维度")
    private Double facilitiesDimension;

    /**
     * 所属景点
     */
    @ApiModelProperty("所属景点")
    private Long attractionsId;

    /**
     * 景点名称
     */
    @ApiModelProperty("景点名称")
    private String attractionsName;

    /**
     * 设施状态：1、正常营业 2、暂停营业
     */
    @ApiModelProperty("设施状态：1、正常营业 2、暂停营业")
    private Integer facilitiesStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 景点距离（单位：米）
     */
    @ApiModelProperty("景点距离（单位：米）")
    private Double distance;

    /**
     * 特色商品列表
     */
    @ApiModelProperty("特色商品列表")
    private List<FeaturedProductVO> featuredProductList;

}
