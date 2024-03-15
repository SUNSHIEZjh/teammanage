package com.team_manage.controller.tranplaninfo.query;

import com.team_manage.common.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 训练计划查询对象
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "训练计划Qry")
public class TranPlanInfoQry extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 人员名称
     */
    @ApiModelProperty("人员名称")
    private String personName;

}
