package com.team_manage.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 考勤管理表实体
 *
 * @author zjh
 * @version V1.0
 * 说明：AttendanceInfo实体层对象
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
@TableName("attendance_info")
public class AttendanceInfo {

    @TableId
    private Long KeyId;
    /**
     * 球员ID
     */
    private Long playerId;


    /**
     * 考勤月份
     */
    private Integer attendanceMonth;


    /**
     * 病假天数
     */
    private Integer sickLeaveDay;


    /**
     * 旷工天数
     */
    private Integer absenteeismDay;


    /**
     * 事假天数
     */
    private Integer personalLeaveDay;


    /**
     * 删除标志，0未删除 1删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlag;

    /**
     * 创建者ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createId;

    /**
     * 创建者名称
     */
    @TableField(fill = FieldFill.INSERT)
    private String createName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改者ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateId;

    /**
     * 修改者名称
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateName;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
