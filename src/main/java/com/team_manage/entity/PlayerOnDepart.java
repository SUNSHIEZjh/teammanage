package com.team_manage.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 球员在职离职信息表实体
 *
 * @author zjh
 * @version V1.0
 * 说明：PlayerOnDepart实体层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:44
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("player_on_depart")
public class PlayerOnDepart implements Serializable {

    @TableId
    private Long KeyId;
    /**
     * 球员ID
     */
    private String playerId;


    /**
     * 籍贯
     */
    private String nativePlace;


    /**
     * 入职日期
     */
    private Date onDate;

    /**
     * 离职日期
     */
    private Date departDate;


    /**
     * 性别
     */
    private String sex;


    /**
     * 位置
     */
    private String plaryLocation;


    /**
     * 离职原因
     */
    private String departReson;

    /**
     * 是否在职： 0 -否 1-是'
     */
    private String onDepartFlag;


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
