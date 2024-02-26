package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.facilities.dto.FeaturedProductDTO;
import com.team_manage.controller.facilities.query.FeaturedProductQry;
import com.team_manage.controller.facilities.query.WxFeaturedProductQry;
import com.team_manage.controller.facilities.vo.FeaturedProductVO;
import com.team_manage.entity.FeaturedProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 特色商品表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface FeaturedProductService extends IService<FeaturedProduct> {

    /**
     * 特色商品信息分页查询
     *
     * @param qry 商品查询Qry
     * @return IPage<FeaturedProductVO>
     */
    IPage<FeaturedProductVO> pageByQry(FeaturedProductQry qry);

    /**
     * 特色商品信息详情
     *
     * @param productId 商品ID
     * @return FeaturedProductVO
     */
    FeaturedProductVO detailById(Long productId);

    /**
     * 新增特色商品信息
     *
     * @param featuredProductDTO 商品DTO
     * @return Boolean
     */
    Boolean add(FeaturedProductDTO featuredProductDTO);

    /**
     * 修改特色商品信息
     *
     * @param productId          商品ID
     * @param featuredProductDTO 商品DTO
     * @return Boolean
     */
    Boolean edit(Long productId, FeaturedProductDTO featuredProductDTO);

    /**
     * 删除特色商品信息
     *
     * @param productId 商品ID
     * @return Boolean
     */
    Boolean del(Long productId);

    /**
     * 特色商品信息分页查询（带门店）
     *
     * @param qry 查询Qry
     * @return IPage<FeaturedProductVO>
     */
    IPage<FeaturedProductVO> pageByQry1(WxFeaturedProductQry qry);
}
