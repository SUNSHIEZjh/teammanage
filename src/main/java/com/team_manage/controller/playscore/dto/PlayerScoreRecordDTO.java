package com.team_manage.controller.playscore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 成都思致科技有限公司
 *
 * @author zjh
 * @version V1.0
 * 说明：PlayerScoreRecord传输层对象
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
@ApiModel(description = "PlayerScoreRecordDTO对象")
public class PlayerScoreRecordDTO implements Serializable {

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
     * 赛事
     */
    @ApiModelProperty(value = "赛事")
    private Long matchId;
    /**
     * 球衣号
     */
    @ApiModelProperty(value = "球衣号")
    private Integer score;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer assistingScore;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer blockShotScore;
    /**
     * 身高
     */
    @ApiModelProperty(value = "身高")
    private Integer backboardScore;
    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private Integer tackleScore;
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
