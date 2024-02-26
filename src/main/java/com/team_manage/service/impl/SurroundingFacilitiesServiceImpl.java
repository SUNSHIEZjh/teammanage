package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.facilities.dto.SurroundingFacilitiesDTO;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry;
import com.team_manage.controller.facilities.query.SurroundingFacilitiesQry1;
import com.team_manage.controller.facilities.vo.FeaturedProductVO;
import com.team_manage.controller.facilities.vo.SurroundingFacilitiesVO;
import com.team_manage.entity.FeaturedProduct;
import com.team_manage.entity.SurroundingFacilities;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.AttractionsInfoMapper;
import com.team_manage.mapper.FeaturedProductMapper;
import com.team_manage.mapper.SurroundingFacilitiesMapper;
import com.team_manage.service.SurroundingFacilitiesService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.DistanceUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 周边设施表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class SurroundingFacilitiesServiceImpl extends ServiceImpl<SurroundingFacilitiesMapper, SurroundingFacilities> implements SurroundingFacilitiesService {

    /**
     * 特色商品Mapper
     */
    private final FeaturedProductMapper featuredProductMapper;

    /**
     * 景点mapper
     */
    private final AttractionsInfoMapper attractionsInfoMapper;

    /**
     * 周边设施信息分页查询
     *
     * @param qry 周边设施查询Qry
     * @return IPage<SurroundingFacilitiesVO>
     */
    @Override
    public IPage<SurroundingFacilitiesVO> pageByQry(SurroundingFacilitiesQry qry) {
        IPage<SurroundingFacilities> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper)
                .like(StringUtils.isNotEmpty(qry.getFacilitiesName()), SurroundingFacilities::getFacilitiesName, qry.getFacilitiesName())
                .eq(ObjectUtils.isNotEmpty(qry.getFacilitiesType()), SurroundingFacilities::getFacilitiesType, qry.getFacilitiesType())
                .eq(ObjectUtils.isNotEmpty(qry.getFacilitiesStatus()), SurroundingFacilities::getFacilitiesStatus, qry.getFacilitiesStatus())
                .eq(ObjectUtils.isNotEmpty(qry.getAttractionsId()), SurroundingFacilities::getAttractionsId, qry.getAttractionsId())
                .page(pages);
        IPage<SurroundingFacilitiesVO> voPages = CopyUtils.covertPage(pages, SurroundingFacilitiesVO.class);
        if (CollectionUtils.isEmpty(pages.getRecords())){
            return voPages;
        }
        // 循环赋值景点名称
        for (SurroundingFacilitiesVO record : voPages.getRecords()) {
            // 设置景点名称
            record.setAttractionsName(attractionsInfoMapper.selectById(record.getAttractionsId()).getAttractionsName());
        }
        return voPages;
    }

    /**
     * 周边设施信息详情
     *
     * @param facilitiesId 设施ID
     * @return SurroundingFacilitiesVO
     */
    @Override
    public SurroundingFacilitiesVO detailById(Long facilitiesId) {
        return CopyUtils.classCopy(baseMapper.selectById(facilitiesId), SurroundingFacilitiesVO.class);
    }

    /**
     * 新增周边设施信息
     *
     * @param surroundingFacilitiesDTO 周边设施DTO
     * @return Boolean
     */
    @Override
    public Boolean add(SurroundingFacilitiesDTO surroundingFacilitiesDTO) {
        List<SurroundingFacilities> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(SurroundingFacilities::getAttractionsId, surroundingFacilitiesDTO.getAttractionsId())
                .eq(SurroundingFacilities::getFacilitiesName, surroundingFacilitiesDTO.getFacilitiesName())
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("周边设施信息已存在,新增失败!");
        }
        // 保存周边设施信息
        SurroundingFacilities surroundingFacilities = CopyUtils.classCopy(surroundingFacilitiesDTO, SurroundingFacilities.class);
        return this.save(surroundingFacilities);
    }

    /**
     * 修改周边设施信息
     *
     * @param facilitiesId             设施ID
     * @param surroundingFacilitiesDTO 周边设施DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(Long facilitiesId, SurroundingFacilitiesDTO surroundingFacilitiesDTO) {
        List<SurroundingFacilities> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(SurroundingFacilities::getAttractionsId, surroundingFacilitiesDTO.getAttractionsId())
                .eq(SurroundingFacilities::getFacilitiesName, surroundingFacilitiesDTO.getFacilitiesName())
                .ne(SurroundingFacilities::getFacilitiesId, facilitiesId)
                .list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("周边设施信息已存在,修改失败!");
        }
        // 修改周边设施信息
        SurroundingFacilities surroundingFacilities = CopyUtils.classCopy(surroundingFacilitiesDTO, SurroundingFacilities.class);
        surroundingFacilities.setFacilitiesId(facilitiesId);
        return this.updateById(surroundingFacilities);
    }

    /**
     * 删除周边设施信息
     *
     * @param facilitiesId 设施ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long facilitiesId) {
        return this.removeById(facilitiesId);
    }

    /**
     * 修改周边设施状态
     *
     * @param facilitiesId     设施ID
     * @param facilitiesStatus 设施状态：1、正常营业 2、暂停营业
     * @return Boolean
     */
    @Override
    public Boolean status(Long facilitiesId, Integer facilitiesStatus) {
        return new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(SurroundingFacilities::getFacilitiesId, facilitiesId)
                .set(SurroundingFacilities::getFacilitiesStatus, facilitiesStatus)
                .update();
    }

    /**
     * 周边设施信息分页查询
     *
     * @param qry 周边设施查询Qry
     * @return IPage<SurroundingFacilitiesVO>
     */
    @Override
    public IPage<SurroundingFacilitiesVO> pageByQry1(SurroundingFacilitiesQry1 qry) {
        List<SurroundingFacilities> list = new LambdaQueryChainWrapper<>(baseMapper)
                .like(StringUtils.isNotEmpty(qry.getFacilitiesName()), SurroundingFacilities::getFacilitiesName, qry.getFacilitiesName())
                .eq(ObjectUtils.isNotEmpty(qry.getFacilitiesType()), SurroundingFacilities::getFacilitiesType, qry.getFacilitiesType())
                .eq(ObjectUtils.isNotEmpty(qry.getFacilitiesStatus()), SurroundingFacilities::getFacilitiesStatus, qry.getFacilitiesStatus())
                .eq(SurroundingFacilities::getAttractionsId, qry.getAttractionsId())
                .list();
        // 判断周边设施列表是否为空
        if (CollectionUtils.isEmpty(list)) {
            return new Page<>();
        }
        // 计算景点距离
        List<SurroundingFacilitiesVO> surroundingFacilitiesVOList = CopyUtils.classCopyList(list, SurroundingFacilitiesVO.class);
        for (SurroundingFacilitiesVO surroundingFacilitiesVO : surroundingFacilitiesVOList) {
            if (ObjectUtils.isNotEmpty(qry.getAttractionsDimension()) && ObjectUtils.isNotEmpty(qry.getAttractionsLongitude())) {
                // 计算距离
                surroundingFacilitiesVO.setDistance(DistanceUtils.getDistance(qry.getAttractionsDimension(), qry.getAttractionsLongitude(), surroundingFacilitiesVO.getFacilitiesDimension(), surroundingFacilitiesVO.getFacilitiesLongitude()));
            } else {
                surroundingFacilitiesVO.setDistance(Constant.DOUBLE_ZERO);
            }
        }
        // 由近到远排序
        surroundingFacilitiesVOList = surroundingFacilitiesVOList.stream().sorted(Comparator.comparing(SurroundingFacilitiesVO::getDistance)).collect(Collectors.toList());
        // 通过内存分页类转换成分页返回前端
        IPage<SurroundingFacilitiesVO> surroundingFacilitiesPages = CopyUtils.covertPage(surroundingFacilitiesVOList, qry.getCurrent(), qry.getLimit(), SurroundingFacilitiesVO.class);
        // 获取周边设施ID列表
        List<Long> facilitiesIds = surroundingFacilitiesPages.getRecords().stream().map(SurroundingFacilitiesVO::getFacilitiesId).collect(Collectors.toList());
        List<FeaturedProduct> featuredProducts = new LambdaQueryChainWrapper<>(featuredProductMapper)
                .in(FeaturedProduct::getFacilitiesId, facilitiesIds)
                .list();
        Map<Long, List<FeaturedProduct>> collect = featuredProducts.stream().collect(Collectors.groupingBy(FeaturedProduct::getFacilitiesId));
        // 组装特色商品信息
        for (SurroundingFacilitiesVO record : surroundingFacilitiesPages.getRecords()) {
            if (collect.containsKey(record.getFacilitiesId())) {
                record.setFeaturedProductList(CopyUtils.classCopyList(collect.get(record.getFacilitiesId()), FeaturedProductVO.class));
            }
        }
        // 返回分页信息
        return surroundingFacilitiesPages;
    }
}
