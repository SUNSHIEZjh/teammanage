package com.team_manage.controller.playerinfo.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 球员查询对象
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "考球员查询Qry")
public class PlayerInfoQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 公告标题
     */
    @ApiModelProperty("姓名")
    private String userName;

    /**
     * 查询月份
     */
    @ApiModelProperty("球队名称")
    private Date teamName;

}
