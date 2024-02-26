package com.team_manage.controller.user.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 关注信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "关注信息Qry")
public class FollowInfoQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 关联用户
     */
    @ApiModelProperty("关联用户")
    private Long userId;

    /**
     * 关联用户
     */
    @ApiModelProperty("关联用户")
    private Long beUserId;

    /**
     * 登录用户
     */
    @ApiModelProperty(hidden = true)
    private Long loginId;
}
