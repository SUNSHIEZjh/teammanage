package com.team_manage.controller.topic.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 话题信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "用户话题信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WxUserTopicQry extends BaseParam {

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
