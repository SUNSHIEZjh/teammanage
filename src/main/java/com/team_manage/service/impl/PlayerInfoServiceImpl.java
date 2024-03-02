package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.attendanceinfo.dto.AttendanceInfoDTO;
import com.team_manage.controller.attendanceinfo.query.AttendanceInfoQry;
import com.team_manage.controller.attendanceinfo.vo.AttendanceInfoVO;
import com.team_manage.controller.playerinfo.dto.PlayerInfoDTO;
import com.team_manage.controller.playerinfo.query.PlayerInfoQry;
import com.team_manage.controller.playerinfo.vo.PlayerInfoVO;
import com.team_manage.controller.user.dto.WebUserDTO;
import com.team_manage.entity.AttendanceInfo;
import com.team_manage.entity.PlayerInfo;
import com.team_manage.mapper.AttendanceInfoMapper;
import com.team_manage.mapper.PlayerInfoMapper;
import com.team_manage.service.AttendanceInfoService;
import com.team_manage.service.PlayerInfoService;
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
public class PlayerInfoServiceImpl extends ServiceImpl<PlayerInfoMapper, PlayerInfo> implements PlayerInfoService {

    /**
     * Redis工具
     */
    private final RedisUtil redisUtil;

    private final SysUserServiceImpl sysUserService;


    /**
     * 修改用户信息
     *
     * @param playerInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(PlayerInfoDTO playerInfoDTO) {
        // 获取登录用户ID
        long attendanceId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        PlayerInfo playerInfo = CopyUtils.classCopy(playerInfoDTO, PlayerInfo.class);
        // 设置用户ID
        playerInfo.setKeyId(attendanceId);
        // 根据ID更新信息
        this.updateById(playerInfo);
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
    public IPage<PlayerInfoVO> pageByQry(PlayerInfoQry qry) {
        IPage<PlayerInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().attendanceInfoPageByQry(qry, pages);
    }


    /**
     * 删除用户信息
     *
     * @param playerId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long playerId) {
        // 删除用户信息
        return this.removeById(playerId);
    }

    /**
     * 修改用户信息
     *
     * @param playerId  用户ID
     * @param playerInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long playerId, PlayerInfoDTO playerInfoDTO) {
        // 修改用户信息
        PlayerInfo playerInfo = CopyUtils.classCopy(playerInfoDTO, PlayerInfo.class);
        playerInfo.setKeyId(playerId);
        return this.updateById(playerInfo);
    }

    /**
     * 新增用户信息
     *
     * @param playerInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean add(PlayerInfoDTO playerInfoDTO) {
        // 新增用户
        PlayerInfo playerInfo = CopyUtils.classCopy(playerInfoDTO, PlayerInfo.class);
        WebUserDTO webUserDTO = new WebUserDTO();
        webUserDTO.setUserName(playerInfo.getPlayerName());
        webUserDTO.setUserAccount(playerInfo.getPlayerName());
        webUserDTO.setUserBirthday(playerInfo.getBirthday());
        sysUserService.add(webUserDTO);
        // // 新增用户信息
        this.save(playerInfo);
        return true;
    }

    /**
     * 用户信息详情
     *
     * @param playerId 用户ID
     * @return WebUserVO
     */
    @Override
    public PlayerInfoVO detail(Long playerId) {
        return CopyUtils.classCopy(baseMapper.selectById(playerId), PlayerInfoVO.class);
    }

}
