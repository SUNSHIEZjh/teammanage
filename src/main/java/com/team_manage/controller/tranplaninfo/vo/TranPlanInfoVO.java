package com.team_manage.controller.tranplaninfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 训练计划表表现层
 *
 * @author zjh
 * @version V1.0
 * 说明：TranPlanInfo表现层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:43
 **/
@Data
@ApiModel("TranPlanInfoVO")
public class TranPlanInfoVO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty("业务主键")
    private Long keyId;
    /**
     * 训练事项
     */
    @ApiModelProperty("训练事项")
    private String planObject;
    /**
     * 所属球员ID
     */
    @ApiModelProperty("所属球员ID")
    private Long playerId;

    /**
     * 所属球员名称
     */
    @ApiModelProperty("所属球员名称")
    private String playerName;
    /**
     * 计划时间
     */
    @ApiModelProperty("计划时间")
    private Date planDate;
    /**
     * 完成情况 0-未完成 1-已完成
     */
    @ApiModelProperty("完成情况 0-未完成 1-已完成")
    private Integer completeFlag;
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
