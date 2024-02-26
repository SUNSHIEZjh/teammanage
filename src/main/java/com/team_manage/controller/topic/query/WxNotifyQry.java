package com.team_manage.controller.topic.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 消息通知Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "消息通知Qry")
@EqualsAndHashCode(callSuper = false)
public class WxNotifyQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 通知状态：1、未读 2、已读
     */
    @ApiModelProperty("通知状态：1、未读 2、已读")
    private Integer notifyStatus;

    /**
     * 登录用户
     */
    @ApiModelProperty(hidden = true)
    private Long userId;

}
