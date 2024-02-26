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
 * 景点信息表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AttractionsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 景点ID
     */
    @TableId
    private Long attractionsId;

    /**
     * 景点名称
     */
    private String attractionsName;

    /**
     * 景点描述
     */
    private String attractionsDesc;

    /**
     * 景点图片
     */
    private String attractionsImages;

    /**
     * 景点等级
     */
    private String attractionsGrade;

    /**
     * 开放状态：1、正常开放 2、未开放
     */
    private Integer openingStatus;

    /**
     * 开放时间
     */
    private String openingTime;

    /**
     * 景点所属省
     */
    private String attractionsProvince;

    /**
     * 景点所属市
     */
    private String attractionsCity;

    /**
     * 景点所属区/县
     */
    private String attractionsCounty;

    /**
     * 景点地址
     */
    private String attractionsAddress;

    /**
     * 景点经度
     */
    private Double attractionsLongitude;

    /**
     * 景点维度
     */
    private Double attractionsDimension;

    /**
     * 联系电话
     */
    private String attractionsPhone;

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
