package com.team_manage.controller.playscore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 球员技术得分信息表表现层
 *
 * @author zjh
 * @version V1.0
 * 说明：PlayerScoreRecord表现层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:43
 **/
@Data
@ApiModel("PlayerScoreRecordVO")
public class PlayerScoreRecordVO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty("业务主键")
    private String keyId;
    /**
     * 球员ID
     */
    @ApiModelProperty("球员ID")
    private String playerId;
    /**
     * 球员ID
     */
    @ApiModelProperty("球员名称")
    private String playerName;
    /**
     * 赛事
     */
    @ApiModelProperty("赛事")
    private String matchId;
    /**
     * 得分
     */
    @ApiModelProperty("得分")
    private Integer score;
    /**
     * 助攻
     */
    @ApiModelProperty("助攻")
    private Integer assistingScore;
    /**
     * 盖帽
     */
    @ApiModelProperty("盖帽")
    private Integer blockShotScore;
    /**
     * 篮板
     */
    @ApiModelProperty("篮板")
    private Integer backboardScore;
    /**
     * 抢断
     */
    @ApiModelProperty("抢断")
    private Integer tackleScore;
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
