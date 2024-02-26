package com.team_manage.controller.introduction.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ApiModel(value = "WX攻略节点DTO")
public class WxIntroductionNodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    @ApiModelProperty("节点ID")
    private Long nodeId;

    /**
     * 节点名称
     */
    @NotBlank(message = "节点名称")
    @ApiModelProperty("节点名称")
    private String nodeName;

    /**
     * 景点ID
     */
    @NotNull(message = "景点ID")
    @ApiModelProperty("景点ID")
    private Long attractionsId;

    /**
     * 节点描述
     */
    @NotBlank(message = "节点描述")
    @ApiModelProperty("节点描述")
    private String nodeDesc;

    /**
     * 节点推荐列表
     */
    @Valid
    @ApiModelProperty("节点推荐列表")
    private List<WxNodeRecommendDTO> nodeRecommendList;
}
