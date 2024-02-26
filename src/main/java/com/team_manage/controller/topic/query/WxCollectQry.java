package com.team_manage.controller.topic.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收藏信息Qry
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "收藏信息Qry")
@EqualsAndHashCode(callSuper = false)
public class WxCollectQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 关键字
     */
    @ApiModelProperty("关键字")
    private String keyWord;

    /**
     * 用户ID：为空默认登录用户
     */
    @ApiModelProperty("用户ID：为空默认登录用户")
    private Long user;

    /**
     * 登录用户
     */
    @ApiModelProperty(hidden = true)
    private Long userId;

}
