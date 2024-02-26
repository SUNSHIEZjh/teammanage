package com.team_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.role.dto.RoleMenuDTO;
import com.team_manage.controller.role.vo.RoleMenuVO;
import com.team_manage.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 根据角色ID获取菜单列表
     *
     * @param roleId 角色ID
     * @return List<RoleMenuVO>
     */
    List<RoleMenuVO> listTree(Long roleId);

    /**
     * 角色菜单授权
     *
     * @param roleMenuDTO 角色菜单操作DTO
     * @return Boolean
     */
    Boolean empower(RoleMenuDTO roleMenuDTO);

    /**
     * 登录用户的菜单树
     *
     * @return List<RoleMenuVO>
     */
    List<RoleMenuVO> user();

    /**
     * 登录用户的菜单列表
     *
     * @return List<RoleMenuVO>
     */
    List<RoleMenuVO> userList();
}
