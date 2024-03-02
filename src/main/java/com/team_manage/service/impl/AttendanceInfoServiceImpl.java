package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.attendanceinfo.dto.AttendanceInfoDTO;
import com.team_manage.controller.attendanceinfo.query.AttendanceInfoQry;
import com.team_manage.controller.attendanceinfo.vo.AttendanceInfoVO;
import com.team_manage.entity.AttendanceInfo;
import com.team_manage.mapper.AttendanceInfoMapper;
import com.team_manage.service.AttendanceInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 考勤 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class AttendanceInfoServiceImpl extends ServiceImpl<AttendanceInfoMapper, AttendanceInfo> implements AttendanceInfoService {

    /**
     * 修改考勤信息
     *
     * @param attendanceInfoDTO 考勤DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(AttendanceInfoDTO attendanceInfoDTO) {
        // 获取登录用户ID
        long attendanceId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        AttendanceInfo attendanceInfo = CopyUtils.classCopy(attendanceInfoDTO, AttendanceInfo.class);
        // 设置用户ID
        attendanceInfo.setKeyId(attendanceId);
        // 根据ID更新信息
        this.updateById(attendanceInfo);
        // 返回成功
        return true;
    }


    /**
     * 用户考勤信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    @Override
    public IPage<AttendanceInfoVO> pageByQry(AttendanceInfoQry qry) {
        IPage<AttendanceInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().attendanceInfoPageByQry(qry, pages);
    }


    /**
     * 删除考勤信息
     *
     * @param attendanceId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long attendanceId) {
        // 删除用户信息
        return this.removeById(attendanceId);
    }

    /**
     * 修改考勤信息
     *
     * @param attendanceId      考勤ID
     * @param attendanceInfoDTO 考勤DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long attendanceId, AttendanceInfoDTO attendanceInfoDTO) {
        // 修改用户信息
        AttendanceInfo attendanceInfo = CopyUtils.classCopy(attendanceInfoDTO, AttendanceInfo.class);
        attendanceInfo.setKeyId(attendanceId);
        return this.updateById(attendanceInfo);
    }

    /**
     * 新增考勤信息
     *
     * @param attendanceInfoDTO 考勤DTO
     * @return Boolean
     */
    @Override
    public Boolean add(AttendanceInfoDTO attendanceInfoDTO) {
        // 新增勤
        AttendanceInfo attendanceInfo = CopyUtils.classCopy(attendanceInfoDTO, AttendanceInfo.class);
        // // 新增勤信息
        this.save(attendanceInfo);
        return true;
    }

    /**
     * 用户考勤信息详情
     *
     * @param playerId 用户ID
     * @return WebUserVO
     */
    @Override
    public List<AttendanceInfoVO> detail(Long playerId) {
        return CopyUtils.classCopyList(baseMapper.selectList(new LambdaQueryWrapper<AttendanceInfo>().eq(AttendanceInfo::getPlayerId, playerId)), AttendanceInfoVO.class);
    }

}
