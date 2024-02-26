package com.team_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.entity.SysUserRole;
import com.team_manage.mapper.SysUserRoleMapper;
import com.team_manage.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
