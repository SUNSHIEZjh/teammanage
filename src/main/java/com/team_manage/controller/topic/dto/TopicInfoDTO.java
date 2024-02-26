package com.team_manage.controller.topic.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value = "话题信息DTO")
public class TopicInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 话题标题
     */
    @NotBlank(message = "话题标题")
    @ApiModelProperty("话题标题")
    private String topicTitle;

    /**
     * 话题内容
     */
    @NotBlank(message = "话题封面")
    @ApiModelProperty("话题内容")
    private String topicContent;

    /**
     * 话题图片
     */
    @ApiModelProperty("话题图片")
    private String topicImg;

}
