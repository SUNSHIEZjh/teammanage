package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.tranplaninfo.dto.TranPlanInfoDTO;
import com.team_manage.controller.tranplaninfo.query.TranPlanInfoQry;
import com.team_manage.controller.tranplaninfo.vo.TranPlanInfoVO;
import com.team_manage.entity.TranPlanInfo;
import com.team_manage.mapper.TranPlanInfoMapper;
import com.team_manage.service.TranPlanInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 训练计划表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class TranPlanInfoServiceImpl extends ServiceImpl<TranPlanInfoMapper, TranPlanInfo> implements TranPlanInfoService {

    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    @Override
    public IPage<TranPlanInfoVO> pageByQry(TranPlanInfoQry qry) {
        IPage<TranPlanInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().tranPlanInfoPageByQry(qry, pages);
    }


    /**
     * 删除训练计划信息
     *
     * @param tranPlanInfoId 训练计划ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long tranPlanInfoId) {
        // 删除用户信息
        return this.removeById(tranPlanInfoId);
    }

    /**
     * 修改训练计划信息
     *
     * @param tranPlanInfoId  训练计划ID
     * @param tranPlanInfoDTO 训练计划DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long tranPlanInfoId, TranPlanInfoDTO tranPlanInfoDTO) {
        // 修改用户信息
        TranPlanInfo tranPlanInfo = CopyUtils.classCopy(tranPlanInfoDTO, TranPlanInfo.class);
        tranPlanInfo.setKeyId(tranPlanInfoId);
        return this.updateById(tranPlanInfo);
    }

    /**
     * 新增训练计划信息
     *
     * @param tranPlanInfoDTO 训练计划DTO
     * @return Boolean
     */
    @Override
    public Boolean add(TranPlanInfoDTO tranPlanInfoDTO) {
        // 新增训练计划
        TranPlanInfo tranPlanInfo = CopyUtils.classCopy(tranPlanInfoDTO, TranPlanInfo.class);
        // // 新增训练计划信息
        this.save(tranPlanInfo);
        return true;
    }

    /**
     * 训练计划信息详情
     *
     * @param userId 训练计划ID
     * @return TranPlanInfoVO
     */
    @Override
    public TranPlanInfoVO detail(Long userId) {
        return CopyUtils.classCopy(baseMapper.selectById(userId), TranPlanInfoVO.class);
    }

    /**
     * 完成训练计划
     *
     * @param tranPlanID 训练计划ID
     * @return Boolean
     */
    @Override
    public Boolean complete(Long tranPlanID) {
        TranPlanInfo tranPlanInfo = baseMapper.selectById(tranPlanID);
        tranPlanInfo.setCompleteFlag(1);
        return this.updateById(tranPlanInfo);
    }

}
