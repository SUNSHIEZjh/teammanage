package com.team_manage.controller.topic.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 评论信息DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "评论信息DTO")
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论父ID
     */
    @NotNull(message = "评论父ID")
    @ApiModelProperty("评论父ID")
    private Long commentParent;

    /**
     * 帖子ID
     */
    @NotNull(message = "帖子ID")
    @ApiModelProperty("帖子ID")
    private Long topicId;

    /**
     * 评论内容
     */
    @NotBlank(message = "评论内容")
    @ApiModelProperty("评论内容")
    private String commentContent;
}
