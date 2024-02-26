package com.team_manage.controller.introduction.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * WEB攻略审核DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "WEB攻略审核DTO")
public class AuditDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 攻略ID
     */
    @NotNull(message = "攻略ID")
    @ApiModelProperty("攻略ID")
    private Long introductionId;

    /**
     * 审核状态 1、通过 2、不通过
     */
    @NotNull(message = "审核状态")
    @ApiModelProperty("审核状态 1、通过 2、不通过")
    private Integer auditStatus;

    /**
     * 审核结果
     */
    @ApiModelProperty("审核结果")
    private String auditResult;


}
