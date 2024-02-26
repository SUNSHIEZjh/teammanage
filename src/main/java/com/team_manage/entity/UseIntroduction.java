package com.team_manage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 攻略使用表
 * </p>
 *
 * @author XXX
 * @since 2023-11-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UseIntroduction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 使用ID
     */
    @TableId
    private Long useId;

    /**
     * 使用人
     */
    private Long userId;

    /**
     * 攻略ID
     */
    private Long introductionId;

    /**
     * 使用时间
     */
    private Date introductionTime;

    /**
     * 使用状态：1、使用中 2、已结束
     */
    private Integer introductionStatus;

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
