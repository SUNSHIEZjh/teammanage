package com.team_manage.controller.introduction.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * WX攻略信息DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WX攻略信息DTO")
public class WxIntroductionInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略名称
     */
    @NotBlank(message = "攻略名称")
    @ApiModelProperty("攻略名称")
    private String introductionName;

    /**
     * 攻略封面
     */
    @NotBlank(message = "攻略封面")
    @ApiModelProperty("攻略封面")
    private String introductionImg;
    /**
     * 攻略描述
     */
    @NotBlank(message = "攻略描述")
    @ApiModelProperty("攻略描述")
    private String introductionDesc;

    /**
     * 攻略节点列表
     */
    @Valid
    @NotEmpty(message = "攻略节点列表")
    @ApiModelProperty("攻略节点列表")
    private List<WxIntroductionNodeDTO> introductionNodeList;

}
