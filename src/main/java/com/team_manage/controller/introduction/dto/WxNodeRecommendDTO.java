package com.team_manage.controller.introduction.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * WX节点推荐DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WX节点推荐DTO")
public class WxNodeRecommendDTO implements Serializable {

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
    @NotNull(message = "商品ID")
    @ApiModelProperty("商品ID")
    private Long productId;

}
