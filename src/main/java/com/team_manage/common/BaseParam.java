package com.team_manage.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 基础分页参数
 *
 * @author ZSL
 * @since 2023-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "基础分页参数")
public class BaseParam implements Serializable {

    private static final long serialVersionUID = 2683699207835074667L;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "current")
    private Integer current;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "limit")
    private Integer limit;

    /**
     * 开始数据
     */
    @ApiModelProperty(hidden = true)
    private Integer start;

    /**
     * 结束数据
     */
    @ApiModelProperty(hidden = true)
    private Integer end;

    /**
     * 构造器，设置不传分页的默认参数
     */
    public BaseParam() {
        setParam();
    }

    /**
     * 设置查询参数
     */
    public void setStartAndEnd() {
        setParam();
    }

    /**
     * 设置查询分页默认值及参数
     */
    private void setParam() {
        if (this.current == null || this.current <= Constant.INTEGER_ZERO) {
            this.current = 1;
        }
        if (this.limit == null || this.limit <= Constant.INTEGER_ZERO) {
            this.limit = 10;
        }
        this.start = (this.current - Constant.INTEGER_ONE) * this.limit;
        this.end = this.start + this.limit;
    }
}
