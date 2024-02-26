package com.team_manage.controller.topic.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 话题信息表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "点赞信息DTO")
public class LikeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属话题
     */
    @ApiModelProperty("所属话题")
    private Long topicId;

    /**
     * 点赞类型：1、话题 2、评论 3、攻略
     */
    @NotNull(message = "点赞类型：1、话题 2、评论 3、攻略")
    @ApiModelProperty("点赞类型：1、话题 2、评论 3、攻略")
    private Integer likeType;

    /**
     * 业务ID：1为话题ID 2为评论ID 3为攻略ID
     */
    @NotNull(message = "业务ID：1为话题ID 2为评论ID 3为攻略ID")
    @ApiModelProperty("业务ID：1为话题ID 2为评论ID 3为攻略ID")
    private Long businessId;

}
