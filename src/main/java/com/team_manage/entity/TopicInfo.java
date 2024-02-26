package com.team_manage.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 话题信息表
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TopicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 话题ID
     */
    @TableId
    private Long topicId;

    /**
     * 话题标题
     */
    private String topicTitle;

    /**
     * 发布时间
     */
    private Date topicTime;

    /**
     * 话题内容
     */
    private String topicContent;

    /**
     * 话题图片
     */
    private String topicImg;

    /**
     * 发布人
     */
    private Long userId;

    /**
     * 话题热度
     */
    private Integer topicHot;

    /**
     * 话题收藏数
     */
    private Integer collectNum;

    /**
     * 点赞数量
     */
    private Integer likeNum;

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
