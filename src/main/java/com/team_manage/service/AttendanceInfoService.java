package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.attendanceinfo.dto.AttendanceInfoDTO;
import com.team_manage.controller.attendanceinfo.query.AttendanceInfoQry;
import com.team_manage.controller.attendanceinfo.vo.AttendanceInfoVO;
import com.team_manage.entity.AttendanceInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface AttendanceInfoService extends IService<AttendanceInfo> {


    /**
     * 修改用户信息
     *
     * @param attendanceInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(AttendanceInfoDTO attendanceInfoDTO);


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<AttendanceInfoVO> pageByQry(AttendanceInfoQry qry);


    /**
     * 删除用户信息
     *
     * @param attendanceId 用户ID
     * @return Boolean
     */
    Boolean del(Long attendanceId);

    /**
     * 修改用户信息
     *
     * @param attendanceId      用户ID
     * @param attendanceInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long attendanceId, AttendanceInfoDTO attendanceInfoDTO);

    /**
     * 新增用户信息
     *
     * @param attendanceInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(AttendanceInfoDTO attendanceInfoDTO);

    /**
     * 用户信息详情
     *
     * @param attendanceId 用户ID
     * @return WebUserVO
     */
    AttendanceInfoVO detail(Long attendanceId);
}
