package com.team_manage.controller.teaminfo.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 训练计划查询对象
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "球队信息Qry")
public class TeamInfoQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 公告标题
     */
    @ApiModelProperty("球队名称")
    private String teamName;

}
