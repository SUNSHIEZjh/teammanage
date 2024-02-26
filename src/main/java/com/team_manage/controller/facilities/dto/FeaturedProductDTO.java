
package com.team_manage.controller.facilities.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 特色商品DTO
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "特色商品DTO")
public class FeaturedProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称")
    @ApiModelProperty("商品名称")
    private String productName;

    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    private String productDescribe;

    /**
     * 商品图片
     */
    @NotBlank(message = "商品图片")
    @ApiModelProperty("商品图片")
    private String productImg;

    /**
     * 所属设施
     */
    @NotNull(message = "所属设施")
    @ApiModelProperty("所属设施")
    private Long facilitiesId;

}
