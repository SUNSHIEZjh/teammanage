package com.team_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.entity.SysParam;

import java.util.Map;

/**
 * <p>
 * 参数表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysParamService extends IService<SysParam> {
    /**
     * 获取appId和secret
     *
     * @return Map<String, String>
     */
    Map<String, String> getAppIdAndSecret();

    /**
     * 获取注册用户信息
     *
     * @return Map<String, String>
     */
    Map<String, String> getRegisterUser();
}
