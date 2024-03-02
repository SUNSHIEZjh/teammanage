package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.matchinfo.dto.MatchInfoDTO;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.entity.MatchInfo;
import com.team_manage.mapper.MatchInfoMapper;
import com.team_manage.service.MatchInfoService;
import com.team_manage.utils.CopyUtils;
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
public class MatchInfoServiceImpl extends ServiceImpl<MatchInfoMapper, MatchInfo> implements MatchInfoService {


    /**
     * 赛事信息分页查询
     *
     * @param qry 查询Qry
     * @return MatchInfoVO
     */
    @Override
    public IPage<MatchInfoVO> pageByQry(MatchInfoQry qry) {
        IPage<MatchInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().matchInfoPageByQry(qry, pages);
    }


    /**
     * 删除赛事信息
     *
     * @param matchInfoId 赛事ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long matchInfoId) {
        // 删除用户信息
        return this.removeById(matchInfoId);
    }

    /**
     * 修改赛事信息
     *
     * @param matchId      赛事ID
     * @param matchInfoDTO 赛事DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long matchId, MatchInfoDTO matchInfoDTO) {
        // 修改用户信息
        MatchInfo matchInfo = CopyUtils.classCopy(matchInfoDTO, MatchInfo.class);
        matchInfo.setKeyId(matchId);
        return this.updateById(matchInfo);
    }

    /**
     * 新增赛事信息
     *
     * @param matchInfoDTO 赛事DTO
     * @return Boolean
     */
    @Override
    public Boolean add(MatchInfoDTO matchInfoDTO) {
        // 新增用户
        MatchInfo matchInfo = CopyUtils.classCopy(matchInfoDTO, MatchInfo.class);
        // // 新增用户信息
        this.save(matchInfo);
        return true;
    }

    /**
     * 赛事户信息详情
     *
     * @param matchId 赛事ID
     * @return MatchInfoVO
     */
    @Override
    public MatchInfoVO detail(Long matchId) {
        return CopyUtils.classCopy(baseMapper.selectById(matchId), MatchInfoVO.class);
    }

}
