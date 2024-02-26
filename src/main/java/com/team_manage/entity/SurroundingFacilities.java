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
 * 周边设施表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SurroundingFacilities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设施ID
     */
    @TableId
    private Long facilitiesId;

    /**
     * 设施名称
     */
    private String facilitiesName;

    /**
     * 设施封面
     */
    private String facilitiesImg;

    /**
     * 设施类型
     */
    private Integer facilitiesType;

    /**
     * 设施描述
     */
    private String facilitiesDesc;

    /**
     * 设施经度
     */
    private Double facilitiesLongitude;

    /**
     * 设施维度
     */
    private Double facilitiesDimension;

    /**
     * 所属景点
     */
    private Long attractionsId;

    /**
     * 设施状态：1、正常营业 2、暂停营业
     */
    private Integer facilitiesStatus;

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
