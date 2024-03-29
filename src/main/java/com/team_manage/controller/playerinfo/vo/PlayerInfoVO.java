package com.team_manage.controller.playerinfo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤管理表表现层
 *
 * @author zjh
 * @version V1.0
 * 说明：AttendanceInfo表现层对象
 * =========================================================================
 * 变更履历：
 * -------------------------------------------------------------------------
 * 变更编号     变更时间    变更人   变更原因    变更内容
 * -------------------------------------------------------------------------
 * <p>
 * @date 2024-02-26 10:34:43
 **/
@Data
@ApiModel("PlayerInfoVO")
public class PlayerInfoVO implements Serializable {
    /**
     * 业务主键
     */
    @ApiModelProperty("业务主键")
    private Long keyId;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long userId;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 性别 0、未知 1、男 2、女
     */
    @ApiModelProperty("性别 0、未知 1、男 2、女")
    private String userSex;
    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private String userBirthday;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String playerName;
    /**
     * 球组ID
     */
    @ApiModelProperty("球组ID")
    private String teamId;
    /**
     * 球衣号
     */
    @ApiModelProperty("球衣号")
    private String plyerNo;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private Date birthday;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
     * 学历
     */
    @ApiModelProperty("学历")
    private String education;
    /**
     * 身高
     */
    @ApiModelProperty("身高")
    private Integer height;
    /**
     * 体重
     */
    @ApiModelProperty("体重")
    private Integer weight;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String account;


    /**
     * 用户表账号
     */
    @ApiModelProperty(value = "用户表账号")
    private String userAccount;

    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    /**
     * 球队名称
     */
    @ApiModelProperty(value = "球队名称")
    private  String teamName;

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

    /**
     * 是否在职 0 - 离职 1- 在职
     */
    @ApiModelProperty("是否在职 0 - 离职 1- 在职")
    private String onDepartFlag;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String userAvatar;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String userPhone;

}
