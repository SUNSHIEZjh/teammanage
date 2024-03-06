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
 * 球员信息表实体
 *
 * @author zjh
 * @version V1.0
 * 说明：PlayerInfo实体层对象
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
@TableName("player_info")
public class PlayerInfo implements Serializable {

    @TableId
    private Long keyId;
    /**
     * 名称
     */
    private String playerName;


    /**
     * 球组ID
     */
    private Long teamId;


    /**
     * 球衣号
     */
    private String plyerNo;


    /**
     * 性别
     */
    private String sex;


    /**
     * 出生日期
     */
    private Date birthday;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 学历
     */
    private String education;


    /**
     * 身高
     */
    private Integer height;


    /**
     * 体重
     */
    private Integer weight;

    /**
     * 账号
     */
    private String account;;


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
