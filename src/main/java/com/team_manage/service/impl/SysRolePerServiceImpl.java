package com.team_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.entity.SysRolePer;
import com.team_manage.mapper.SysRolePerMapper;
import com.team_manage.service.SysRolePerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class SysRolePerServiceImpl extends ServiceImpl<SysRolePerMapper, SysRolePer> implements SysRolePerService {

    /**
     * 根据用户ID获取权限列表
     *
     * @param loginId 用户ID
     * @return List<String>
     */
    @Override
    public List<String> getPerListByUserId(Object loginId) {
        return baseMapper.getPerListByUserId(loginId);
    }
}
