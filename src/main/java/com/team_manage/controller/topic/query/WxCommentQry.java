package com.team_manage.controller.topic.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 评论信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "评论信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WxCommentQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 话题ID
     */
    @NotNull(message = "话题ID")
    @ApiModelProperty("话题ID")
    private Long topicId;

    /**
     * 登录用户
     */
    @ApiModelProperty(hidden = true)
    private Long userId;

}
