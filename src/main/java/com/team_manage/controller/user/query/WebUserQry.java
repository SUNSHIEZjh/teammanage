package com.team_manage.controller.user.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户信息Qry")
public class WebUserQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String userPhone;
}
