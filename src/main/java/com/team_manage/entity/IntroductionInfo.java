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
 * 攻略信息表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IntroductionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略ID
     */
    @TableId
    private Long introductionId;

    /**
     * 攻略名称
     */
    private String introductionName;

    /**
     * 攻略封面
     */
    private String introductionImg;

    /**
     * 发布时间
     */
    private Date introductionTime;

    /**
     * 发布用户
     */
    private Long userId;

    /**
     * 攻略描述
     */
    private String introductionDesc;

    /**
     * 点赞数量
     */
    private Integer introductionLike;

    /**
     * 收藏数量
     */
    private Integer introductionCollect;

    /**
     * 攻略状态 1、未审核 2、已通过审核 3、未通过审核 4、重新提交审核
     */
    private Integer introductionStatus;

    /**
     * 审核结果
     */
    private String auditResult;

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
