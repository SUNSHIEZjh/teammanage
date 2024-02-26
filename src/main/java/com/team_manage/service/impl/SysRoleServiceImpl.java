package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.ExceptionConstant;
import com.team_manage.controller.role.dto.RoleDTO;
import com.team_manage.controller.role.query.RoleQry;
import com.team_manage.controller.role.vo.RoleVO;
import com.team_manage.entity.SysRole;
import com.team_manage.entity.SysUserRole;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.SysRoleMapper;
import com.team_manage.mapper.SysUserRoleMapper;
import com.team_manage.service.SysRoleService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.SpecialCharacterUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    /**
     * 用户角色Mapper
     */
    private final SysUserRoleMapper userRoleMapper;

    /**
     * 角色分页列表
     *
     * @param roleQry 角色
     * @return IPage<RoleVO>
     */
    @Override
    public IPage<RoleVO> pageByQry(RoleQry roleQry) {
        IPage<SysRole> pages = new Page<>(roleQry.getCurrent(), roleQry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper)
                .like(StringUtils.isNotBlank(roleQry.getRoleName())
                        , SysRole::getRoleName
                        , SpecialCharacterUtil.escapeStr(roleQry.getRoleName())
                ).page(pages);
        return CopyUtils.covertPage(pages, RoleVO.class);
    }

    /**
     * 角色详情
     *
     * @param roleId 角色ID
     * @return RoleVO
     */
    @Override
    public RoleVO detailById(Long roleId) {
        SysRole role = this.getById(roleId);
        return CopyUtils.classCopy(role, RoleVO.class);
    }

    /**
     * 查询所有角色列表
     *
     * @return List<RoleVO>
     */
    @Override
    public List<RoleVO> roleList() {
        return CopyUtils.classCopyList(this.list(), RoleVO.class);
    }

    /**
     * 新增角色信息
     *
     * @param roleDTO 角色操作DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean save(RoleDTO roleDTO) {
        SysRole one = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(SysRole::getRoleName, roleDTO.getRoleName())
                .or()
                .eq(SysRole::getRoleFlag, roleDTO.getRoleFlag())
                .one();
        if (ObjectUtils.isEmpty(one)) {
            SysRole role = CopyUtils.classCopy(roleDTO, SysRole.class);
            return this.save(role);
        } else {
            throw new ServiceException(ExceptionConstant.ROLE_ALREADY_EXISTS_ADD_FAILED);
        }
    }

    /**
     * 修改角色信息
     *
     * @param roleId  角色ID
     * @param roleDTO 角色操作DTO
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean edit(Long roleId, RoleDTO roleDTO) {
        SysRole one = new LambdaQueryChainWrapper<>(baseMapper)
                .ne(SysRole::getRoleId, roleId)
                .and(a -> a.eq(SysRole::getRoleName, roleDTO.getRoleName())
                        .or()
                        .eq(SysRole::getRoleFlag, roleDTO.getRoleFlag()))
                .one();
        if (ObjectUtils.isEmpty(one)) {
            SysRole role = CopyUtils.classCopy(roleDTO, SysRole.class);
            role.setRoleId(roleId);
            return this.updateById(role);
        } else {
            throw new ServiceException(ExceptionConstant.ROLE_ALREADY_EXISTS_UPDATE_FAILED);
        }
    }

    /**
     * 删除角色信息
     *
     * @param roleId 角色ID
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean del(Long roleId) {
        List<SysUserRole> list = userRoleMapper.selectUserByRoleId(roleId);
        if (CollectionUtils.isEmpty(list)) {
            return this.removeById(roleId);
        } else {
            throw new ServiceException(ExceptionConstant.ROLE_USED_BY_USER_DELETE_FAILED);
        }
    }
}
