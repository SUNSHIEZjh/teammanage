package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.attractions.dto.AttractionsInfoDTO;
import com.team_manage.controller.attractions.query.AttractionsInfoQry;
import com.team_manage.controller.attractions.query.AttractionsInfoQry1;
import com.team_manage.controller.attractions.vo.AttractionsInfoVO;
import com.team_manage.entity.AttractionsInfo;
import com.team_manage.entity.IntroductionNode;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.AttractionsInfoMapper;
import com.team_manage.mapper.AttractionsTicketMapper;
import com.team_manage.mapper.IntroductionNodeMapper;
import com.team_manage.service.AttractionsInfoService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.DistanceUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 景点信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class AttractionsInfoServiceImpl extends ServiceImpl<AttractionsInfoMapper, AttractionsInfo> implements AttractionsInfoService {

    /**
     * 攻略节点Mapper
     */
    private final IntroductionNodeMapper introductionNodeMapper;

    /**
     * 景点门票Mapper
     */
    private final AttractionsTicketMapper attractionsTicketMapper;

    /**
     * 景点信息分页查询
     *
     * @param qry 查询条件
     * @return IPage<AttractionsInfoVO>
     */
    @Override
    public IPage<AttractionsInfoVO> pageByQry(AttractionsInfoQry qry) {
        IPage<AttractionsInfo> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper).like(StringUtils.isNotEmpty(qry.getAttractionsName()), AttractionsInfo::getAttractionsName, qry.getAttractionsName()).eq(StringUtils.isNotEmpty(qry.getAttractionsProvince()), AttractionsInfo::getAttractionsProvince, qry.getAttractionsProvince()).eq(StringUtils.isNotEmpty(qry.getAttractionsCity()), AttractionsInfo::getAttractionsCity, qry.getAttractionsCity()).eq(StringUtils.isNotEmpty(qry.getAttractionsCounty()), AttractionsInfo::getAttractionsCounty, qry.getAttractionsCounty()).eq(StringUtils.isNotEmpty(qry.getAttractionsGrade()), AttractionsInfo::getAttractionsGrade, qry.getAttractionsGrade()).like(StringUtils.isNotEmpty(qry.getAttractionsAddress()), AttractionsInfo::getAttractionsAddress, qry.getAttractionsAddress()).eq(ObjectUtils.isNotEmpty(qry.getOpeningStatus()) && !Constant.INTEGER_ZERO.equals(qry.getOpeningStatus()), AttractionsInfo::getOpeningStatus, qry.getOpeningStatus()).orderByDesc(AttractionsInfo::getAttractionsId).page(pages);
        return CopyUtils.covertPage(pages, AttractionsInfoVO.class);
    }

    /**
     * 景点信息详情
     *
     * @param attractionsId 景点ID
     * @return AttractionsInfoVO
     */
    @Override
    public AttractionsInfoVO detailById(Long attractionsId) {
        AttractionsInfo attractionsInfo = baseMapper.selectById(attractionsId);
        if (ObjectUtils.isEmpty(attractionsInfo)) {
            throw new ServiceException("未查询到景点信息");
        }
        // 返回景点门票详情
        return CopyUtils.classCopy(attractionsInfo, AttractionsInfoVO.class);
    }

    /**
     * 新增景点信息
     *
     * @param attractionsInfoDTO 景点信息操作DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(AttractionsInfoDTO attractionsInfoDTO) {
        List<AttractionsInfo> list = new LambdaQueryChainWrapper<>(baseMapper).eq(AttractionsInfo::getAttractionsName, attractionsInfoDTO.getAttractionsName()).list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("景点信息已存在,新增失败!");
        }
        // 处理景点信息
        AttractionsInfo attractionsInfo = CopyUtils.classCopy(attractionsInfoDTO, AttractionsInfo.class);
        // 新增景点信息
        return this.save(attractionsInfo);
    }

    /**
     * 修改景点信息
     *
     * @param attractionsId      景点ID
     * @param attractionsInfoDTO 景点信息操作DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean edit(Long attractionsId, AttractionsInfoDTO attractionsInfoDTO) {
        List<AttractionsInfo> list = new LambdaQueryChainWrapper<>(baseMapper).eq(AttractionsInfo::getAttractionsName, attractionsInfoDTO.getAttractionsName()).ne(AttractionsInfo::getAttractionsId, attractionsId).list();
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("景点信息已存在,修改失败!");
        }
        // 处理景点信息
        AttractionsInfo attractionsInfo = CopyUtils.classCopy(attractionsInfoDTO, AttractionsInfo.class);
        attractionsInfo.setAttractionsId(attractionsId);
        // 新增景点信息
        return this.updateById(attractionsInfo);
    }

    /**
     * 删除景点信息
     *
     * @param attractionsId 景点ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean del(Long attractionsId) {
        List<IntroductionNode> list = new LambdaQueryChainWrapper<>(introductionNodeMapper).eq(IntroductionNode::getAttractionsId, attractionsId).list();
        // 判断是否被攻略使用过该景点
        if (!CollectionUtils.isEmpty(list)) {
            throw new ServiceException("该景点已被攻略使用，无法删除!");
        }
        // 删除景点信息
        return this.removeById(attractionsId);
    }

    /**
     * 分页查询景点列表
     *
     * @param qry 景点查询Qry1
     * @return IPage<AttractionsInfoVO>
     */
    @Override
    public IPage<AttractionsInfoVO> pageByQry1(AttractionsInfoQry1 qry) {
        List<AttractionsInfo> list = new LambdaQueryChainWrapper<>(baseMapper).eq(StringUtils.isNotEmpty(qry.getAttractionsName()), AttractionsInfo::getAttractionsName, qry.getAttractionsName()).list();
        // 判断景点列表是否为空
        if (CollectionUtils.isEmpty(list)) {
            return new Page<>();
        }
        // 计算景点距离
        List<AttractionsInfoVO> attractionsInfoList = CopyUtils.classCopyList(list, AttractionsInfoVO.class);
        for (AttractionsInfoVO attractionsInfoVO : attractionsInfoList) {
            if (ObjectUtils.isNotEmpty(qry.getAttractionsDimension()) && ObjectUtils.isNotEmpty(qry.getAttractionsLongitude())) {
                // 计算距离
                attractionsInfoVO.setDistance(DistanceUtils.getDistance(qry.getAttractionsDimension(), qry.getAttractionsLongitude(), attractionsInfoVO.getAttractionsDimension(), attractionsInfoVO.getAttractionsLongitude()));
            } else {
                attractionsInfoVO.setDistance(Constant.DOUBLE_ZERO);
            }
        }
        // 由近到远排序
        attractionsInfoList = attractionsInfoList.stream().sorted(Comparator.comparing(AttractionsInfoVO::getDistance)).collect(Collectors.toList());
        // 通过内存分页类转换成分页返回前端
        return CopyUtils.covertPage(attractionsInfoList, qry.getCurrent(), qry.getLimit(), AttractionsInfoVO.class);
    }

    /**
     * 修改景点开放状态
     *
     * @param attractionsId 景点ID
     * @param openingStatus 开放状态：1、正常开放 2、未开放
     * @return Boolean
     */
    @Override
    public Boolean status(Long attractionsId, Integer openingStatus) {
        return new LambdaUpdateChainWrapper<>(baseMapper).eq(AttractionsInfo::getAttractionsId, attractionsId).set(AttractionsInfo::getOpeningStatus, openingStatus).update();
    }
}
