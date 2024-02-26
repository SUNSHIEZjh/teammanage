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
@ApiModel(value = "收藏信息DTO")
public class CollectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏类型：1、帖子 2、攻略
     */
    @NotNull(message = "收藏类型：1、帖子 2、攻略")
    @ApiModelProperty("收藏类型：1、帖子 2、攻略")
    private Integer collectType;

    /**
     * 业务ID：1为帖子ID 2为攻略ID
     */
    @NotNull(message = "业务ID：1为帖子ID 2为攻略ID")
    @ApiModelProperty("业务ID：1为帖子ID 2为攻略ID")
    private Long businessId;

}
