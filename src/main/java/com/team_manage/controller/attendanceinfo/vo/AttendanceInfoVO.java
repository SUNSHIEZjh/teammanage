package com.team_manage.controller.attendanceinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤管理表表现层
 *
 * @author zjh
 * @version V1.0
 * 说明：AttendanceInfo表现层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:43
 **/
@Data
@ApiModel("AttendanceInfoVO")
public class AttendanceInfoVO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty("业务主键")
    private Long keyId;
    /**
     * 球员ID
     */
    @ApiModelProperty("球员ID")
    private Long playerId;

    /**
     * 考勤年份
     */
    @ApiModelProperty(value = "考勤年份")
    private Integer attendanceYear;
    /**
     * 考勤月份
     */
    @ApiModelProperty("考勤月份")
    private Integer attendanceMonth;

    /**
     * 考勤月份（YYYY-MM）
     */
    @ApiModelProperty("考勤月份（YYYY-MM）")
    private String  attendanceYearMonth;
    /**
     * 病假天数
     */
    @ApiModelProperty("病假天数")
    private Integer sickLeaveDay;
    /**
     * 旷工天数
     */
    @ApiModelProperty("旷工天数")
    private Integer absenteeismDay;
    /**
     * 事假天数
     */
    @ApiModelProperty("事假天数")
    private Integer personalLeaveDay;
    /**
     * 删除标志，0未删除 1删除
     */
    @ApiModelProperty("删除标志，0未删除 1删除")
    private Integer deleteFlag;
    /**
     * 创建者ID
     */
    @ApiModelProperty("创建者ID")
    private String createId;
    /**
     * 创建者名称
     */
    @ApiModelProperty("创建者名称")
    private String createName;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 修改者ID
     */
    @ApiModelProperty("修改者ID")
    private String updateId;
    /**
     * 修改者名称
     */
    @ApiModelProperty("修改者名称")
    private String updateName;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateTime;

}
