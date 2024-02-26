package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.introduction.query.WxIntroductionNodeQry;
import com.team_manage.controller.introduction.vo.WxIntroductionNodeVO;
import com.team_manage.controller.introduction.vo.WxNodeRecommendVO;
import com.team_manage.entity.IntroductionNode;
import com.team_manage.mapper.IntroductionNodeMapper;
import com.team_manage.mapper.NodeRecommendMapper;
import com.team_manage.service.IntroductionNodeService;
import com.team_manage.utils.DistanceUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 攻略节点表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class IntroductionNodeServiceImpl extends ServiceImpl<IntroductionNodeMapper, IntroductionNode> implements IntroductionNodeService {

    /**
     * 节点推荐Mapper
     */
    private final NodeRecommendMapper nodeRecommendMapper;

    /**
     * 攻略节点分页查询
     *
     * @param nodeQry 查询Qry
     * @return IPage<WxIntroductionNodeVO>
     */
    @Override
    public IPage<WxIntroductionNodeVO> pageByQry(WxIntroductionNodeQry nodeQry) {
        IPage<WxIntroductionNodeVO> pages = new Page<>(nodeQry.getCurrent(), nodeQry.getLimit());
        // 分页查询节点信息
        pages = baseMapper.pageByQry(nodeQry, pages);
        // 判断节点信息是否为空
        if (CollectionUtils.isEmpty(pages.getRecords())) {
            return pages;
        }
        for (WxIntroductionNodeVO record : pages.getRecords()) {
            // 计算距离
            if (ObjectUtils.isNotEmpty(nodeQry.getAttractionsDimension()) && ObjectUtils.isNotEmpty(nodeQry.getAttractionsLongitude())) {
                // 计算距离
                record.setDistance(DistanceUtils.getDistance(nodeQry.getAttractionsDimension(), nodeQry.getAttractionsLongitude(), record.getAttractionsDimension(), record.getAttractionsLongitude()));
            } else {
                record.setDistance(Constant.DOUBLE_ZERO);
            }
            // 查询攻略推荐商品
            List<WxNodeRecommendVO> nodeRecommendList = nodeRecommendMapper.getListByNodeId(record.getNodeId());
            for (WxNodeRecommendVO wxNodeRecommendVO : nodeRecommendList) {
                // 计算距离
                if (ObjectUtils.isNotEmpty(nodeQry.getAttractionsDimension()) && ObjectUtils.isNotEmpty(nodeQry.getAttractionsLongitude())) {
                    // 计算距离
                    wxNodeRecommendVO.setDistance(DistanceUtils.getDistance(nodeQry.getAttractionsDimension(), nodeQry.getAttractionsLongitude(),
                            wxNodeRecommendVO.getFacilitiesDimension(), wxNodeRecommendVO.getFacilitiesLongitude()));
                } else {
                    wxNodeRecommendVO.setDistance(Constant.DOUBLE_ZERO);
                }
            }
            // 由近到远排序
            nodeRecommendList = nodeRecommendList.stream().sorted(Comparator.comparing(WxNodeRecommendVO::getDistance)).collect(Collectors.toList());
            // 放入记录列表中
            record.setNodeRecommendList(nodeRecommendList);
        }
        // 返回分页信息
        return pages;
    }
}
