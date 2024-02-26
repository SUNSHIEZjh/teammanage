package com.team_manage.controller.introduction.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * WX攻略信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WX攻略信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WxIntroductionQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略名称/攻略描述
     */
    @ApiModelProperty("攻略名称/攻略描述")
    private String keyWord;

    /**
     * 攻略排序 1、最新 2、最热 3、收藏
     */
    @ApiModelProperty("攻略排序 1、最新 2、最热 3、收藏")
    private Integer sorted;

    /**
     * 用户ID
     */
    @ApiModelProperty(hidden = true)
    private Long userId;

}
