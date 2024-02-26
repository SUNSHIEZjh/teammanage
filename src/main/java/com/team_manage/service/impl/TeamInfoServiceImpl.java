package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.matchinfo.dto.MatchInfoDTO;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.entity.MatchInfo;
import com.team_manage.entity.TeamInfo;
import com.team_manage.mapper.MatchInfoMapper;
import com.team_manage.mapper.TeamInfoMapper;
import com.team_manage.service.MatchInfoService;
import com.team_manage.service.TeamInfoService;
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
public class TeamInfoServiceImpl extends ServiceImpl<TeamInfoMapper, TeamInfo> implements TeamInfoService {

    /**
     * Redis工具
     */
    private final RedisUtil redisUtil;


    /**
     * 修改用户信息
     *
     * @param teamInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(TeamInfoDTO teamInfoDTO) {
        // 获取登录用户ID
        long teamInfoId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        TeamInfo teamInfo = CopyUtils.classCopy(teamInfoDTO, TeamInfo.class);
        // 设置用户ID
        teamInfo.setKeyId(teamInfoId);
        // 根据ID更新信息
        this.updateById(teamInfo);
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
    public IPage<TeamInfoVO> pageByQry(TeamInfoQry qry) {
        IPage<TeamInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().teamInfoPageByQry(qry, pages);
    }


    /**
     * 删除用户信息
     *
     * @param teamInfoId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long teamInfoId) {
        // 删除用户信息
        return this.removeById(teamInfoId);
    }

    /**
     * 修改用户信息
     *
     * @param teamInfoId  用户ID
     * @param teamInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long teamInfoId, TeamInfoDTO teamInfoDTO) {
        // 修改用户信息
        TeamInfo teamInfo = CopyUtils.classCopy(teamInfoDTO, TeamInfo.class);
        teamInfo.setKeyId(teamInfoId);
        return this.updateById(teamInfo);
    }

    /**
     * 新增用户信息
     *
     * @param teamInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean add(TeamInfoDTO teamInfoDTO) {
        // 新增用户
        TeamInfo teamInfo = CopyUtils.classCopy(teamInfoDTO, TeamInfo.class);
        // // 新增用户信息
        this.save(teamInfo);
        return true;
    }

    /**
     * 用户信息详情
     *
     * @param teamInfoId 用户ID
     * @return WebUserVO
     */
    @Override
    public TeamInfoVO detail(Long teamInfoId) {
        return CopyUtils.classCopy(baseMapper.selectById(teamInfoId), TeamInfoVO.class);
    }

}
