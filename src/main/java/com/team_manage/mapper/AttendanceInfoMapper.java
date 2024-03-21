package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.attendanceinfo.query.AttendanceInfoQry;
import com.team_manage.controller.attendanceinfo.vo.AttendanceInfoVO;
import com.team_manage.entity.AttendanceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface AttendanceInfoMapper extends BaseMapper<AttendanceInfo> {

    /**
     * 用户信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return WebUserVO
     */
    IPage<AttendanceInfoVO> attendanceInfoPageByQry(@Param("qry") AttendanceInfoQry qry, @Param("pages") IPage<AttendanceInfoVO> pages);



    List<AttendanceInfoVO> attendanceInfoList(@Param("playerId") String playerId,@Param("attendanceYear")String attendanceYear ,@Param("attendanceMonth")String attendanceMonth);


}
