package com.team_manage.controller.playscore.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 技术得分查询对象
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "球员得分Qry")
public class PlayerScoreRecordQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 球员名称
     */
    @ApiModelProperty("球员名称")
    private String playerName;

}
