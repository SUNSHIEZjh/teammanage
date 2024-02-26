package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.user.query.WebUserQry;
import com.team_manage.controller.user.vo.WebUserVO;
import com.team_manage.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 用户信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return WebUserVO
     */
    IPage<WebUserVO> pageByQry(@Param("qry") WebUserQry qry, @Param("pages") IPage<WebUserVO> pages);

    /**
     * 用户信息详情
     *
     * @param userId 用户ID
     * @return WebUserVO
     */
    WebUserVO detail(@Param("userId") Long userId);
}
