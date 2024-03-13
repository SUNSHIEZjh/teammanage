package com.team_manage.controller.noticeinfo.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公告信息查询对象
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "公告信息查询对象Qry")
public class NoticeInfoQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 公告标题
     */
    @ApiModelProperty("公告标题")
    private String noticeTitle;

}
