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
@ApiModel(value = "话题信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WebTopicQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 话题标题
     */
    @ApiModelProperty("话题标题")
    private String keyWord;

    /**
     * 话题排序：0、最热（默认） 1、最新 2、收藏最多 3、点赞最多
     */
    @ApiModelProperty("话题排序：0、最热（默认） 1、最新 2、收藏最多 3、点赞最多")
    private Integer sort;

    /**
     * 登录用户
     */
    @ApiModelProperty(hidden = true)
    private Long userId;

}
