package com.team_manage.controller.introduction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * WX节点推荐VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WX节点推荐VO")
public class WxNodeRecommendVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推荐ID
     */
    @ApiModelProperty("推荐ID")
    private Long recommendId;

    /**
     * 节点ID
     */
    @ApiModelProperty("节点ID")
    private Long nodeId;

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
     * 景点距离（单位：米）
     */
    @ApiModelProperty("景点距离（单位：米）")
    private Double distance;

}
