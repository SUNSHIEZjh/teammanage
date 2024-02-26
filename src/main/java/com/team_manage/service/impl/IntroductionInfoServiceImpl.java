package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.introduction.dto.AuditDTO;
import com.team_manage.controller.introduction.dto.WxIntroductionInfoDTO;
import com.team_manage.controller.introduction.dto.WxIntroductionNodeDTO;
import com.team_manage.controller.introduction.dto.WxNodeRecommendDTO;
import com.team_manage.controller.introduction.query.WebIntroductionQry;
import com.team_manage.controller.introduction.query.WxIntroductionQry;
import com.team_manage.controller.introduction.query.WxUserIntroductionQry;
import com.team_manage.controller.introduction.vo.WxIntroductionInfoVO;
import com.team_manage.entity.IntroductionInfo;
import com.team_manage.entity.IntroductionNode;
import com.team_manage.entity.NodeRecommend;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.IntroductionInfoMapper;
import com.team_manage.service.IntroductionInfoService;
import com.team_manage.service.IntroductionNodeService;
import com.team_manage.service.NodeRecommendService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 攻略信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class IntroductionInfoServiceImpl extends ServiceImpl<IntroductionInfoMapper, IntroductionInfo> implements IntroductionInfoService {

    /**
     * 攻略节点Service
     */
    private final IntroductionNodeService introductionNodeService;

    /**
     * 节点推荐Service
     */
    private final NodeRecommendService nodeRecommendService;

    /**
     * 攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    @Override
    public IPage<WxIntroductionInfoVO> pageByQry(WxIntroductionQry qry) {
        // 设置登录用户ID
        try {
            qry.setUserId(StpUtil.getLoginIdAsLong());
        } catch (Exception e) {
            qry.setUserId(Constant.LONG_ZERO);
        }
        IPage<WxIntroductionInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 返回查询数据
        return baseMapper.pageByQry(qry, pages);
    }

    /**
     * 攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    @Override
    public IPage<WxIntroductionInfoVO> pageByQry(WebIntroductionQry qry) {
        IPage<WxIntroductionInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 返回查询数据
        return baseMapper.pageByQry1(qry, pages);
    }

    /**
     * 我的攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    @Override
    public IPage<WxIntroductionInfoVO> mine(WxIntroductionQry qry) {
        // 设置登录用户ID
        qry.setUserId(StpUtil.getLoginIdAsLong());
        IPage<WxIntroductionInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return baseMapper.mine(qry, pages);
    }

    /**
     * 攻略信息详情
     *
     * @param introductionId 攻略ID
     * @return WxIntroductionInfoVO
     */
    @Override
    public WxIntroductionInfoVO detail(Long introductionId) {
        // 设置登录用户ID
        long userId;
        try {
            userId = StpUtil.getLoginIdAsLong();
        } catch (Exception e) {
            userId = Constant.LONG_ZERO;
        }
        return baseMapper.detail(introductionId, userId);
    }

    /**
     * 新增攻略信息
     *
     * @param introductionInfoDTO 攻略新增DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(WxIntroductionInfoDTO introductionInfoDTO) {
        // 获取登录用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 节点数组
        List<IntroductionNode> nodeList = new ArrayList<>();
        // 节点推荐数组
        List<NodeRecommend> nodeRecommendList = new ArrayList<>();
        // 初始化攻略信息实体类
        IntroductionInfo introductionInfo = CopyUtils.classCopy(introductionInfoDTO, IntroductionInfo.class);
        introductionInfo.setIntroductionCollect(Constant.INTEGER_ZERO)
                .setIntroductionLike(Constant.INTEGER_ZERO)
                .setUserId(userId)
                .setIntroductionTime(new Date())
                .setIntroductionStatus(Constant.INTEGER_ONE)
                .setIntroductionId(IdUtils.getLongId());
        // 循环初始化节点实体类
        int sort = 1;
        for (WxIntroductionNodeDTO wxIntroductionNodeDTO : introductionInfoDTO.getIntroductionNodeList()) {
            IntroductionNode introductionNode = new IntroductionNode()
                    .setIntroductionId(introductionInfo.getIntroductionId())
                    .setNodeName(wxIntroductionNodeDTO.getNodeName())
                    .setNodeDesc(wxIntroductionNodeDTO.getNodeDesc())
                    .setAttractionsId(wxIntroductionNodeDTO.getAttractionsId())
                    .setNodeSort(sort++)
                    .setNodeId(IdUtils.getLongId());
            // 放入节点列表
            nodeList.add(introductionNode);
            // 处理节点推荐列表
            if (!CollectionUtils.isEmpty(wxIntroductionNodeDTO.getNodeRecommendList())) {
                for (WxNodeRecommendDTO wxNodeRecommendDTO : wxIntroductionNodeDTO.getNodeRecommendList()) {
                    nodeRecommendList.add(
                            new NodeRecommend()
                                    .setNodeId(introductionNode.getNodeId())
                                    .setProductId(wxNodeRecommendDTO.getProductId())
                    );
                }
            }
        }
        // 保存攻略信息
        this.save(introductionInfo);
        // 保存节点信息
        introductionNodeService.saveBatch(nodeList);
        // 保存推荐信息
        nodeRecommendService.saveBatch(nodeRecommendList);
        // 返回成功
        return true;
    }

    /**
     * 编辑攻略信息
     *
     * @param introductionId      攻略ID
     * @param introductionInfoDTO 攻略DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean edit(Long introductionId, WxIntroductionInfoDTO introductionInfoDTO) {
        // 获取登录用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 节点数组
        List<IntroductionNode> nodeList = new ArrayList<>();
        // 节点推荐数组
        List<NodeRecommend> nodeRecommendList = new ArrayList<>();
        // 查询攻略信息
        IntroductionInfo introduction = baseMapper.selectById(introductionId);
        if (ObjectUtils.isEmpty(introduction)) {
            throw new ServiceException("攻略信息不存在!");
        }
        // 判断攻略是否通过审核
        if (Constant.INTEGER_TWO.equals(introduction.getIntroductionStatus())) {
            throw new ServiceException("攻略信息已通过审核，无法修改!");
        }
        // 组装攻略信息
        IntroductionInfo introductionInfo = CopyUtils.classCopy(introductionInfoDTO, IntroductionInfo.class);
        introductionInfo.setUserId(userId)
                .setIntroductionStatus(Constant.INTEGER_FOUR)
                .setIntroductionTime(new Date())
                .setIntroductionId(introductionId);
        // 循环初始化节点实体类
        int sort = 1;
        for (WxIntroductionNodeDTO wxIntroductionNodeDTO : introductionInfoDTO.getIntroductionNodeList()) {
            IntroductionNode introductionNode = new IntroductionNode()
                    .setIntroductionId(introductionInfo.getIntroductionId())
                    .setNodeName(wxIntroductionNodeDTO.getNodeName())
                    .setNodeDesc(wxIntroductionNodeDTO.getNodeDesc())
                    .setAttractionsId(wxIntroductionNodeDTO.getAttractionsId())
                    .setNodeSort(sort++)
                    .setNodeId(IdUtils.getLongId());
            // 放入节点列表
            nodeList.add(introductionNode);
            // 处理节点推荐列表
            if (!CollectionUtils.isEmpty(wxIntroductionNodeDTO.getNodeRecommendList())) {
                for (WxNodeRecommendDTO wxNodeRecommendDTO : wxIntroductionNodeDTO.getNodeRecommendList()) {
                    nodeRecommendList.add(
                            new NodeRecommend()
                                    .setNodeId(introductionNode.getNodeId())
                                    .setProductId(wxNodeRecommendDTO.getProductId())
                                    .setRecommendId(IdUtils.getLongId())
                    );
                }
            }
        }
        // 查询需要删除的节点列表
        List<IntroductionNode> removeNodeList = new LambdaQueryChainWrapper<>(introductionNodeService.getBaseMapper())
                .eq(IntroductionNode::getIntroductionId, introductionId)
                .list();
        // 获取需要删除的nodeId
        List<Long> removeNodeIds = removeNodeList.stream().map(IntroductionNode::getNodeId).collect(Collectors.toList());
        // 删除节点列表
        new LambdaUpdateChainWrapper<>(introductionNodeService.getBaseMapper())
                .in(IntroductionNode::getNodeId, removeNodeIds)
                .remove();
        // 删除推荐列表
        new LambdaUpdateChainWrapper<>(nodeRecommendService.getBaseMapper())
                .in(NodeRecommend::getNodeId, removeNodeIds)
                .remove();
        // 修改攻略信息
        this.updateById(introductionInfo);
        // 保存节点信息
        introductionNodeService.saveBatch(nodeList);
        // 保存推荐信息
        nodeRecommendService.saveBatch(nodeRecommendList);
        // 返回成功
        return true;
    }

    /**
     * 攻略信息审核
     *
     * @param auditDTO 审核DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean audit(AuditDTO auditDTO) {
        // 查询攻略信息
        IntroductionInfo introductionInfo = baseMapper.selectById(auditDTO.getIntroductionId());
        if (ObjectUtils.isEmpty(introductionInfo)) {
            throw new ServiceException("攻略信息不存在!");
        }
        // 判断攻略是否通过审核
        if (Constant.INTEGER_TWO.equals(introductionInfo.getIntroductionStatus())) {
            throw new ServiceException("攻略信息已通过审核，无法再次审核!");
        }
        return new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(IntroductionInfo::getIntroductionId, auditDTO.getIntroductionId())
                .set(IntroductionInfo::getAuditResult, auditDTO.getAuditResult())
                .set(IntroductionInfo::getIntroductionStatus, Constant.INTEGER_ONE.equals(auditDTO.getAuditStatus()) ? Constant.INTEGER_TWO : Constant.INTEGER_THREE)
                .update();
    }

    /**
     * 用户攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    @Override
    public IPage<WxIntroductionInfoVO> user(WxUserIntroductionQry qry) {
        // 设置登录用户ID
        try {
            qry.setLoginId(StpUtil.getLoginIdAsLong());
        } catch (Exception e){
            qry.setLoginId(Constant.LONG_ZERO);
        }
        IPage<WxIntroductionInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return baseMapper.user(qry, pages);
    }

    /**
     * 删除攻略信息
     *
     * @param introductionId 攻略ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean del(Long introductionId) {
        // 查询攻略节点信息
        List<IntroductionNode> list = new LambdaQueryChainWrapper<>(introductionNodeService.getBaseMapper())
                .eq(IntroductionNode::getIntroductionId, introductionId)
                .list();
        // 获取节点ID
        List<Long> collect = list.stream().map(IntroductionNode::getNodeId).collect(Collectors.toList());
        // 删除攻略信息
        this.removeById(introductionId);
        // 删除节点信息
        introductionNodeService.removeByIds(collect);
        // 删除节点推荐信息
        new LambdaUpdateChainWrapper<>(nodeRecommendService.getBaseMapper())
                .in(NodeRecommend::getNodeId,collect)
                .remove();
        // 返回成功
        return true;
    }
}
