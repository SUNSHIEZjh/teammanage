package com.team_manage.controller.playerinfo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author zjh
 * @version V1.0
 * 说明：AttendanceInfo传输层对象
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
@ApiModel(description = "PlayerInfoDTO对象")
public class PlayerInfoDTO implements Serializable {

    /**
     * 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String keyId;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String playerName;
    /**
     * 球组ID
     */
    @ApiModelProperty(value = "球组ID")
    private Long teamId;
    /**
     * 球衣号
     */
    @ApiModelProperty(value = "球衣号")
    private String plyerNo;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;
    /**
     * 学历
     */
    @ApiModelProperty(value = "学历")
    private String education;
    /**
     * 身高
     */
    @ApiModelProperty(value = "身高")
    private Integer height;
    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private Integer weight;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String account;


    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;
    /**
     * 入职日期
     */
    @ApiModelProperty(value = "入职日期")
    private Date onDate;
    /**
     * 离开日期
     */
    @ApiModelProperty("离开日期")
    private Date departDate;
    /**
     * 位置
     */
    @ApiModelProperty(value = "位置")
    private String plaryLocation;
    /**
     * 离职原因
     */
    @ApiModelProperty(value = "离职原因")
    private String departReson;
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
