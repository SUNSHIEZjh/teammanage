package com.team_manage.controller.playerinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 球员在职离职信息表表现层
 *
 * @author zjh
 * @version V1.0
 * 说明：PlayerOnDepart表现层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:44
 **/
@Data
@ApiModel("PlayerOnDepartVO")
public class PlayerOnDepartVO implements Serializable {

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
     * 籍贯
     */
    @ApiModelProperty("籍贯")
    private String nativePlace;
    /**
     * 入职日期
     */
    @ApiModelProperty("入职日期")
    private Date onDate;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 位置
     */
    @ApiModelProperty("位置")
    private String plaryLocation;
    /**
     * 离职原因
     */
    @ApiModelProperty("离职原因")
    private String departReson;
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
