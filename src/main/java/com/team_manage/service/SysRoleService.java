package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.role.dto.RoleDTO;
import com.team_manage.controller.role.query.RoleQry;
import com.team_manage.controller.role.vo.RoleVO;
import com.team_manage.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 角色分页列表
     *
     * @param roleQry 角色
     * @return IPage<RoleVO>
     */
    IPage<RoleVO> pageByQry(RoleQry roleQry);

    /**
     * 角色详情
     *
     * @param roleId 角色ID
     * @return RoleVO
     */
    RoleVO detailById(Long roleId);

    /**
     * 查询所有角色列表
     *
     * @return List<RoleVO>
     */
    List<RoleVO> roleList();

    /**
     * 新增角色信息
     *
     * @param roleDTO 角色操作DTO
     * @return Boolean
     */
    Boolean save(RoleDTO roleDTO);

    /**
     * 修改角色信息
     *
     * @param roleId  角色ID
     * @param roleDTO 角色操作DTO
     * @return Boolean
     */
    Boolean edit(Long roleId, RoleDTO roleDTO);

    /**
     * 删除角色信息
     *
     * @param roleId 角色ID
     * @return Boolean
     */
    Boolean del(Long roleId);
}
