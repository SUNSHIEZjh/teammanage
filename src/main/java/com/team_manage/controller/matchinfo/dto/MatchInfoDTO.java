package com.team_manage.controller.matchinfo.dto;

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
 * 说明：MatchInfo传输层对象
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
@ApiModel(description = "MatchInfoDTO对象")
public class MatchInfoDTO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String keyId;
    /**
     * 赛事名称
     */
    @ApiModelProperty(value = "赛事名称")
    private String playerName;
    /**
     * 赛事时间
     */
    @ApiModelProperty(value = "赛事时间")
    private Date matchDate;
    /**
     * 赛事等级
     */
    @ApiModelProperty(value = "赛事等级")
    private String matchLevel;
    /**
     * 赛事对手
     */
    @ApiModelProperty(value = "赛事对手")
    private String matchTeam;
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
