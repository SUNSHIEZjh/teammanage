package com.team_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.entity.SysRolePer;

import java.util.List;

/**
 * <p>
 * 角色权限表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysRolePerService extends IService<SysRolePer> {

    /**
     * 根据用户ID获取权限列表
     *
     * @param loginId 用户ID
     * @return List<String>
     */
    List<String> getPerListByUserId(Object loginId);
}
