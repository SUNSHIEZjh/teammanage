package com.team_manage.controller.topic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 消息通知VO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "消息通知VO")
public class NotifyInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知ID
     */
    @ApiModelProperty("通知ID")
    private Long notifyId;

    /**
     * 通知类型：1、话题 2、攻略
     */
    @ApiModelProperty("通知类型：1、话题 2、攻略")
    private Integer notifyType;

    /**
     * 通知用户
     */
    @ApiModelProperty("通知用户")
    private Long userId;

    /**
     * 业务ID
     */
    @ApiModelProperty("业务ID")
    private Long businessId;

    /**
     * 通知时间
     */
    @ApiModelProperty("通知时间")
    private Date notifyTime;

    /**
     * 通知内容
     */
    @ApiModelProperty("通知内容")
    private String notifyContent;

    /**
     * 通知状态：1、未读 2、已读
     */
    @ApiModelProperty("通知状态：1、未读 2、已读")
    private Integer notifyStatus;
}
