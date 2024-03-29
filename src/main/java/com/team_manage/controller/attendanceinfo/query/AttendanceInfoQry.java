package com.team_manage.controller.attendanceinfo.query;

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
@ApiModel(value = "考勤信息Qry")
public class AttendanceInfoQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 公告标题
     */
    @ApiModelProperty("球员名称")
    private String userName;

    /**
     * 查询月份
     */
    @ApiModelProperty("查询年份")
    private String selectYear;

    /**
     * 查询月份
     */
    @ApiModelProperty("查询月份")
    private String selectMonth;

}
