package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.teaminfo.dto.TeamInfoDTO;
import com.team_manage.controller.teaminfo.dto.TeamPlayerInfoDTO;
import com.team_manage.controller.teaminfo.query.TeamInfoQry;
import com.team_manage.controller.teaminfo.vo.TeamInfoVO;
import com.team_manage.controller.teaminfo.vo.TeamPlayerInfoVO;
import com.team_manage.entity.TeamInfo;
import com.team_manage.entity.TeamPlayerInfo;
import com.team_manage.mapper.TeamInfoMapper;
import com.team_manage.mapper.TeamPlayerInfoMapper;
import com.team_manage.service.TeamInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 球队表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class TeamInfoServiceImpl extends ServiceImpl<TeamInfoMapper, TeamInfo> implements TeamInfoService {


    private final TeamPlayerInfoMapper teamPlayerInfoMapper;


    /**
     * 球队信息分页查询
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
     * 删除球队信息
     *
     * @param teamInfoId 球队ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long teamInfoId) {
        // 删除用户信息
        return this.removeById(teamInfoId);
    }

    /**
     * 修改球队信息
     *
     * @param teamInfoId  球队ID
     * @param teamInfoDTO 球队DTO
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
     * 新增球队信息
     *
     * @param teamInfoDTO 球队DTO
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
     * 球队信息详情
     *
     * @param teamInfoId 球队ID
     * @return WebUserVO
     */
    @Override
    public TeamInfoVO detail(Long teamInfoId) {
        return CopyUtils.classCopy(baseMapper.selectById(teamInfoId), TeamInfoVO.class);
    }

    /**
     * 球队球员列表
     *
     * @param teamId
     * @return
     */
    @Override
    public List<TeamPlayerInfoVO> teamPlayerList(Long teamId) {
        List<TeamPlayerInfo> teamPlayerInfos = teamPlayerInfoMapper.selectList(new LambdaQueryWrapper<TeamPlayerInfo>().eq(TeamPlayerInfo::getTeamId, teamId));
        return CopyUtils.classCopyList(teamPlayerInfos, TeamPlayerInfoVO.class);
    }

    /**
     * 球队球员新增
     *
     * @param teamId            球队ID
     * @param teamPlayerInfoDTO 球队球员信息
     * @return 成功/失败
     */
    @Override
    public Boolean teamPlayerAdd(Long teamId, TeamPlayerInfoDTO teamPlayerInfoDTO) {
        teamPlayerInfoDTO.setTeamId(teamId);
        TeamPlayerInfo teamPlayerInfo = CopyUtils.classCopy(teamPlayerInfoDTO, TeamPlayerInfo.class);
        teamPlayerInfoMapper.insert(teamPlayerInfo);
        return true;
    }

    /**
     * 球队球员移除
     *
     * @param teamPlayerId 球队球员ID
     * @return 成功/失败
     */
    @Override
    public Boolean teamPlayerRemove(Long teamPlayerId) {
        return teamPlayerInfoMapper.deleteById(teamPlayerId) > 0;
    }

    /**
     * 球队列表
     * @return  TeamInfoVO
     */
    @Override
    public List<TeamInfoVO> teamList() {
        return CopyUtils.classCopyList(this.baseMapper.selectList(new LambdaQueryWrapper<>()),TeamInfoVO.class);
    }

}
