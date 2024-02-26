package com.team_manage.controller.introduction.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * WX用户攻略信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WX用户攻略信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WxUserIntroductionQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long userId;

    /**
     * 登录用户ID
     */
    @ApiModelProperty(hidden = true)
    private Long loginId;

}
