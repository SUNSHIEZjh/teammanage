package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.attendanceinfo.dto.AttendanceInfoDTO;
import com.team_manage.controller.attendanceinfo.query.AttendanceInfoQry;
import com.team_manage.controller.attendanceinfo.vo.AttendanceInfoVO;
import com.team_manage.entity.AttendanceInfo;

import java.util.List;

/**
 * <p>
 * 考勤 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface AttendanceInfoService extends IService<AttendanceInfo> {


    /**
     * 修改考勤信息
     *
     * @param attendanceInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(AttendanceInfoDTO attendanceInfoDTO);


    /**
     * 考勤汇总信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<AttendanceInfoVO> pageByQry(AttendanceInfoQry qry);


    /**
     * 删除考勤信息
     *
     * @param attendanceId 用户ID
     * @return Boolean
     */
    Boolean del(Long attendanceId);

    /**
     * 修改考勤信息
     *
     * @param attendanceId      用户ID
     * @param attendanceInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long attendanceId, AttendanceInfoDTO attendanceInfoDTO);

    /**
     * 新增考勤信息
     *
     * @param attendanceInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(AttendanceInfoDTO attendanceInfoDTO);

    /**
     * 用户考勤详情
     *
     * @param playerId 球员ID
     * @return 考情集合
     */
    List<AttendanceInfoVO> detail(Long playerId);
}
