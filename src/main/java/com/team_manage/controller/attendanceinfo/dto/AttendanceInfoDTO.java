package com.team_manage.controller.attendanceinfo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author zjh
 * @version V1.0
 * 说明：AttendanceInfo传输层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:43
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "NoticeInfoDTO对象")
public class AttendanceInfoDTO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String keyId;
    /**
     * 球员ID
     */
    @ApiModelProperty(value = "球员ID")
    private Long playerId;

    /**
     * 考勤年份
     */
    @ApiModelProperty(value = "考勤年份")
    private Integer attendanceYear;

    /**
     * 考勤月份
     */
    @ApiModelProperty(value = "考勤月份")
    private Integer attendanceMonth;
    /**
     * 病假天数
     */
    @ApiModelProperty(value = "病假天数")
    private Integer sickLeaveDay;
    /**
     * 旷工天数
     */
    @ApiModelProperty(value = "旷工天数")
    private Integer absenteeismDay;
    /**
     * 事假天数
     */
    @ApiModelProperty(value = "事假天数")
    private Integer personalLeaveDay;
    /**
     * 删除标志，0未删除 1删除
     */
    @ApiModelProperty(value = "删除标志，0未删除 1删除")
    private Integer deleteFlag;
    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private Long createId;
    /**
     * 创建者名称
     */
    @ApiModelProperty(value = "创建者名称")
    private String createName;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 修改者ID
     */
    @ApiModelProperty(value = "修改者ID")
    private Long updateId;
    /**
     * 修改者名称
     */
    @ApiModelProperty(value = "修改者名称")
    private String updateName;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}
