package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team_manage.common.Constant;
import com.team_manage.controller.facilities.dto.FeaturedProductDTO;
import com.team_manage.controller.facilities.query.FeaturedProductQry;
import com.team_manage.controller.facilities.query.WxFeaturedProductQry;
import com.team_manage.controller.facilities.vo.FeaturedProductVO;
import com.team_manage.controller.introduction.vo.WxNodeRecommendVO;
import com.team_manage.entity.FeaturedProduct;
import com.team_manage.entity.NodeRecommend;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.FeaturedProductMapper;
import com.team_manage.mapper.NodeRecommendMapper;
import com.team_manage.service.FeaturedProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.DistanceUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 特色商品表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class FeaturedProductServiceImpl extends ServiceImpl<FeaturedProductMapper, FeaturedProduct> implements FeaturedProductService {

    /**
     * 节点推荐Mapper
     */
    private final NodeRecommendMapper nodeRecommendMapper;

    /**
     * 特色商品信息分页查询
     *
     * @param qry 商品查询Qry
     * @return IPage<FeaturedProductVO>
     */
    @Override
    public IPage<FeaturedProductVO> pageByQry(FeaturedProductQry qry) {
        IPage<FeaturedProduct> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(FeaturedProduct::getFacilitiesId, qry.getFacilitiesId())
                .like(StringUtils.isNotEmpty(qry.getProductName()), FeaturedProduct::getProductName, qry.getProductName())
                .orderByAsc(FeaturedProduct::getProductId)
                .page(pages);
        return CopyUtils.covertPage(pages, FeaturedProductVO.class);
    }

    /**
     * 特色商品信息详情
     *
     * @param productId 商品ID
     * @return FeaturedProductVO
     */
    @Override
    public FeaturedProductVO detailById(Long productId) {
        FeaturedProduct featuredProduct = baseMapper.selectById(productId);
        return CopyUtils.classCopy(featuredProduct, FeaturedProductVO.class);
    }

    /**
     * 新增特色商品信息
     *
     * @param featuredProductDTO 商品DTO
     * @return Boolean
     */
    @Override
    public Boolean add(FeaturedProductDTO featuredProductDTO) {
        List<FeaturedProduct> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(FeaturedProduct::getProductName, featuredProductDTO.getProductName())
                .eq(FeaturedProduct::getFacilitiesId, featuredProductDTO.getFacilitiesId())
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("商品信息已存在,新增失败!");
        }
        FeaturedProduct featuredProduct = CopyUtils.classCopy(featuredProductDTO, FeaturedProduct.class);
        return this.save(featuredProduct);
    }

    /**
     * 修改特色商品信息
     *
     * @param productId          商品ID
     * @param featuredProductDTO 商品DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(Long productId, FeaturedProductDTO featuredProductDTO) {
        List<FeaturedProduct> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(FeaturedProduct::getProductName, featuredProductDTO.getProductName())
                .eq(FeaturedProduct::getFacilitiesId, featuredProductDTO.getFacilitiesId())
                .ne(FeaturedProduct::getProductId, productId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("商品信息已存在,修改失败!");
        }
        FeaturedProduct featuredProduct = CopyUtils.classCopy(featuredProductDTO, FeaturedProduct.class);
        featuredProduct.setProductId(productId);
        return this.updateById(featuredProduct);
    }

    /**
     * 删除特色商品信息
     *
     * @param productId 商品ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long productId) {
        List<NodeRecommend> list = new LambdaQueryChainWrapper<>(nodeRecommendMapper)
                .eq(NodeRecommend::getProductId, productId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("该特色商品已被使用,无法删除!");
        }
        return this.removeById(productId);
    }

    /**
     * 特色商品信息分页查询（带门店）
     *
     * @param qry 查询Qry
     * @return IPage<FeaturedProductVO>
     */
    @Override
    public IPage<FeaturedProductVO> pageByQry1(WxFeaturedProductQry qry) {
        // 实例化分页page
        IPage<FeaturedProductVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 获取分页信息
        pages = baseMapper.pageByQry1(qry, pages);
        if (CollectionUtils.isEmpty(pages.getRecords())){
            return pages;
        }
        // 循环计算距离
        for (FeaturedProductVO record : pages.getRecords()) {
            // 计算距离
            if (ObjectUtils.isNotEmpty(qry.getAttractionsDimension()) && ObjectUtils.isNotEmpty(qry.getAttractionsLongitude())) {
                // 计算距离
                record.setDistance(DistanceUtils.getDistance(qry.getAttractionsDimension(), qry.getAttractionsLongitude(),
                        record.getFacilitiesDimension(), record.getFacilitiesLongitude()));
            } else {
                record.setDistance(Constant.DOUBLE_ZERO);
            }
        }
        return pages;
    }
}
