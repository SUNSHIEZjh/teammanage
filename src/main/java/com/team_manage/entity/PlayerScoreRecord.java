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
 * 球员技术得分信息表实体
 *
 * @author zjh
 * @version V1.0
 * 说明：PlayerScoreRecord实体层对象
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
@TableName("player_score_record")
public class PlayerScoreRecord implements Serializable {

    @TableId
    private Long KeyId;
    /**
     * 球员ID
     */
    private Long playerId;


    /**
     * 赛事
     */
    private Long matchId;


    /**
     * 得分
     */
    private Integer score;


    /**
     * 助攻
     */
    private Integer assistingScore;


    /**
     * 盖帽
     */
    private Integer blockShotScore;


    /**
     * 篮板
     */
    private Integer backboardScore;


    /**
     * 抢断
     */
    private Integer tackleScore;


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
