package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.playerinfo.dto.PlayerInfoDTO;
import com.team_manage.controller.playerinfo.dto.PlayerOnDepartDTO;
import com.team_manage.controller.playerinfo.query.PlayerInfoQry;
import com.team_manage.controller.playerinfo.vo.PlayerInfoVO;
import com.team_manage.controller.user.dto.WebUserDTO;
import com.team_manage.entity.PlayerInfo;
import com.team_manage.entity.PlayerOnDepart;
import com.team_manage.mapper.PlayerInfoMapper;
import com.team_manage.mapper.PlayerOnDepartMapper;
import com.team_manage.service.PlayerInfoService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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


    private final SysUserServiceImpl sysUserService;

    private final PlayerOnDepartMapper playerOnDepartMapper;

    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    @Override
    public IPage<PlayerInfoVO> pageByQry(PlayerInfoQry qry) {
        IPage<PlayerInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().playerInfoPageByQry(qry, pages);
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
        PlayerOnDepart playerOnDepart = playerOnDepartMapper.selectOne(new LambdaQueryWrapper<PlayerOnDepart>().eq(PlayerOnDepart::getPlayerId,playerId));
        playerOnDepart.setNativePlace(playerInfoDTO.getNativePlace());
        playerOnDepart.setSex(playerInfoDTO.getSex());
        playerOnDepart.setPlaryLocation(playerInfoDTO.getPlaryLocation());
        updateOnDepart(playerOnDepart);
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
        playerInfo.setKeyId(IdUtils.getLongId());
        //用户新增
        WebUserDTO webUserDTO = new WebUserDTO();
        webUserDTO.setUserName(playerInfo.getPlayerName());
        webUserDTO.setUserAccount(playerInfo.getAccount());
        webUserDTO.setUserPassword("Aa12345");
        webUserDTO.setRoleId(240306112439491L);
        webUserDTO.setUserBirthday(playerInfo.getBirthday());
        //人员在离职信息表
        PlayerOnDepartDTO playerOnDepartDTO = new PlayerOnDepartDTO();
        playerOnDepartDTO.setPlayerId(playerInfo.getKeyId().toString());
        playerOnDepartDTO.setOnDate(new Date());
        playerOnDepartDTO.setNativePlace(playerInfoDTO.getNativePlace());
        playerOnDepartDTO.setSex(playerOnDepartDTO.getSex());
        playerOnDepartDTO.setPlaryLocation(playerOnDepartDTO.getPlaryLocation()) ;
        addOnDepart(playerOnDepartDTO);
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
        PlayerInfoVO playerInfoVO = CopyUtils.classCopy(baseMapper.selectById(playerId), PlayerInfoVO.class);
        PlayerOnDepart playerOnDepart = playerOnDepartMapper.selectOne(new LambdaQueryWrapper<PlayerOnDepart>().eq(PlayerOnDepart::getPlayerId,playerId));
        playerInfoVO.setOnDate(playerOnDepart.getOnDate());
        playerInfoVO.setNativePlace(playerOnDepart.getNativePlace());
        playerInfoVO.setDepartDate(playerOnDepart.getDepartDate());
        playerInfoVO.setDepartDate(playerOnDepart.getDepartDate());
        return  playerInfoVO;
    }

    /**
     * 新增入职信息
     * @param playerOnDepartDTO
     * @return
     */
    public boolean addOnDepart( PlayerOnDepartDTO playerOnDepartDTO ){
        PlayerOnDepart playerOnDepart = CopyUtils.classCopy(playerOnDepartDTO, PlayerOnDepart.class);
        playerOnDepart.setOnDepartFlag("1");
        playerOnDepartMapper.insert(playerOnDepart);
        return true;
    }

    /**
     * 新增入职信息
     * @param playerOnDepart
     * @return
     */
    public boolean updateOnDepart( PlayerOnDepart playerOnDepart){
        playerOnDepartMapper.updateById(playerOnDepart);
        return true;
    }

    /**
     * 离职信息保存信息
     * @param playerId  用户ID
     * @param playerOnDepartDTO
     * @return
     */
    @Override
    public Boolean depart(Long playerId, PlayerOnDepartDTO playerOnDepartDTO ){
        PlayerOnDepart playerOnDepart = playerOnDepartMapper.selectOne(new LambdaQueryWrapper<PlayerOnDepart>().eq(PlayerOnDepart::getPlayerId,playerId));
        playerOnDepart.setDepartReson(playerOnDepartDTO.getDepartReson());
        playerOnDepart.setDepartDate(playerOnDepartDTO.getDepartDate());
        playerOnDepart.setOnDepartFlag("0");
        playerOnDepartMapper.updateById(playerOnDepart);
        return true;
    }

    @Override
    public List<PlayerInfoVO> getList(){
          return  CopyUtils.classCopyList(this.baseMapper.selectList(new LambdaQueryWrapper<>()),PlayerInfoVO.class);
    }

    @Override
    public PlayerInfoVO detailUserInfo(Long userId) {
        return getBaseMapper().detailUserInfo(String.valueOf(userId));
    }
}
