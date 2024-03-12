package com.team_manage.controller.matchinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 赛事信息表表现层
 *
 * @author zjh
 * @version V1.0
 * 说明：MatchInfo表现层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:43
 **/
@Data
@ApiModel("MatchInfoVO")
public class MatchInfoVO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty("业务主键")
    private Long keyId;
    /**
     * 赛事名称
     */
    @ApiModelProperty("赛事名称")
    private String matchName;
    /**
     * 赛事时间
     */
    @ApiModelProperty("赛事时间")
    private Date matchDate;
    /**
     * 赛事等级
     */
    @ApiModelProperty("赛事等级")
    private String matchLevel;
    /**
     * 赛事对手
     */
    @ApiModelProperty("赛事对手")
    private String matchTeam;
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
