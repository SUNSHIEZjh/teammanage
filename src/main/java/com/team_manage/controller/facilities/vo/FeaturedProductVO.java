
package com.team_manage.controller.facilities.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 特色商品表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "特色商品VO")
public class FeaturedProductVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @ApiModelProperty("商品ID")
    private Long productId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    private String productDescribe;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String productImg;

    /**
     * 所属设施
     */
    @ApiModelProperty("所属设施")
    private Long facilitiesId;

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
     * 设施状态：1、正常营业 2、暂停营业
     */
    @ApiModelProperty("设施状态：1、正常营业 2、暂停营业")
    private Integer facilitiesStatus;

    /**
     * 景点距离（单位：米）
     */
    @ApiModelProperty("景点距离（单位：米）")
    private Double distance;
}
