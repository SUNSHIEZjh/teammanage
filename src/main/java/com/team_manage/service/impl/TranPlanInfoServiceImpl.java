package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
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
import com.team_manage.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class TranPlanInfoServiceImpl extends ServiceImpl<TranPlanInfoMapper, TranPlanInfo> implements TranPlanInfoService {

    /**
     * Redis工具
     */
    private final RedisUtil redisUtil;


    /**
     * 修改用户信息
     *
     * @param tranPlanInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(TranPlanInfoDTO tranPlanInfoDTO) {
        // 获取登录用户ID
        long tranPlanInfoId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        TranPlanInfo tranPlanInfo = CopyUtils.classCopy(tranPlanInfoDTO, TranPlanInfo.class);
        // 设置用户ID
        tranPlanInfo.setKeyId(tranPlanInfoId);
        // 根据ID更新信息
        this.updateById(tranPlanInfo);
        // 返回成功
        return true;
    }


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
     * 删除用户信息
     *
     * @param tranPlanInfoId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long tranPlanInfoId) {
        // 删除用户信息
        return this.removeById(tranPlanInfoId);
    }

    /**
     * 修改用户信息
     *
     * @param tranPlanInfoId  用户ID
     * @param tranPlanInfoDTO 用户DTO
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
     * 新增用户信息
     *
     * @param tranPlanInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean add(TranPlanInfoDTO tranPlanInfoDTO) {
        // 新增用户
        TranPlanInfo tranPlanInfo = CopyUtils.classCopy(tranPlanInfoDTO, TranPlanInfo.class);
        // // 新增用户信息
        this.save(tranPlanInfo);
        return true;
    }

    /**
     * 用户信息详情
     *
     * @param userId 用户ID
     * @return WebUserVO
     */
    @Override
    public TranPlanInfoVO detail(Long userId) {
        return CopyUtils.classCopy(baseMapper.selectById(userId), TranPlanInfoVO.class);
    }

}
