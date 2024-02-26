package com.team_manage.controller.introduction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 攻略节点表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WX攻略节点VO")
public class WxIntroductionNodeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    @ApiModelProperty("节点ID")
    private Long nodeId;

    /**
     * 攻略ID
     */
    @ApiModelProperty("攻略ID")
    private Long introductionId;

    /**
     * 节点名称
     */
    @ApiModelProperty("节点名称")
    private String nodeName;

    /**
     * 景点ID
     */
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 景点名称
     */
    @ApiModelProperty("景点名称")
    private String attractionsName;

    /**
     * 景点描述
     */
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
    @ApiModelProperty("景点等级")
    private String attractionsGrade;

    /**
     * 开放状态：1、正常开放 2、未开放
     */
    @ApiModelProperty("开放状态：1、正常开放 2、未开放")
    private Integer openingStatus;

    /**
     * 开放时间
     */
    @ApiModelProperty("开放时间")
    private String openingTime;

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

    /**
     * 景点经度
     */
    @ApiModelProperty("景点经度")
    private Double attractionsLongitude;

    /**
     * 景点维度
     */
    @ApiModelProperty("景点维度")
    private Double attractionsDimension;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String attractionsPhone;

    /**
     * 节点描述
     */
    @ApiModelProperty("节点描述")
    private String nodeDesc;

    /**
     * 节点顺序
     */
    @ApiModelProperty("节点顺序")
    private Integer nodeSort;

    /**
     * 景点距离（单位：米）
     */
    @ApiModelProperty("景点距离（单位：米）")
    private Double distance;

    /**
     * 节点推荐列表
     */
    @ApiModelProperty("节点推荐列表")
    private List<WxNodeRecommendVO> nodeRecommendList;
}
