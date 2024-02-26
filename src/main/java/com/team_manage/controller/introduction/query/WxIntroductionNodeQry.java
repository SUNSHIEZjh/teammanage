package com.team_manage.controller.introduction.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * WX攻略节点Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WX攻略节点Qry")
@EqualsAndHashCode(callSuper = false)
public class WxIntroductionNodeQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略ID
     */
    @NotNull(message = "攻略ID")
    @ApiModelProperty("攻略ID")
    private Long introductionId;

    /**
     * 当前经度
     */
    @ApiModelProperty("当前经度")
    private Double attractionsLongitude;

    /**
     * 当前维度
     */
    @ApiModelProperty("当前维度")
    private Double attractionsDimension;

}
