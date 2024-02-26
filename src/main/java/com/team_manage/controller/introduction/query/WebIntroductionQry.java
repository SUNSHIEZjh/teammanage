package com.team_manage.controller.introduction.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * WEB攻略信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WEB攻略信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WebIntroductionQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略名称
     */
    @ApiModelProperty("攻略名称")
    private String introductionName;

    /**
     * 发布用户
     */
    @ApiModelProperty("发布用户")
    private Long userId;

    /**
     * 攻略状态 1、未审核 2、已通过审核 3、未通过审核 4、重新提交审核
     */
    @ApiModelProperty("攻略状态 1、未审核 2、已通过审核 3、未通过审核 4、重新提交审核")
    private Integer introductionStatus;

    /**
     * 攻略排序 1、最新 2、最热 3、收藏
     */
    @ApiModelProperty("攻略排序 1、最新 2、最热 3、收藏")
    private Integer sorted;

}
