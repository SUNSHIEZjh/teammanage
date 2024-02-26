package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team_manage.entity.SysRole;
import com.team_manage.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 根据用户ID查询角色信息
     *
     * @param userId 用户ID
     * @return SysRole
     */
    SysRole selectRoleByUserId(@Param("userId") Long userId);

    /**
     * 根据角色ID查询用户信息
     *
     * @param roleId 用户ID
     * @return List<SysUserRole>
     */
    List<SysUserRole> selectUserByRoleId(@Param("roleId") Long roleId);
}
