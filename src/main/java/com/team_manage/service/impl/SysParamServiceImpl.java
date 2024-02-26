package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.entity.SysParam;
import com.team_manage.mapper.SysParamMapper;
import com.team_manage.service.SysParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 参数表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParam> implements SysParamService {

    /**
     * 获取appId和secret
     *
     * @return Map<String, String>
     */
    @Override
    public Map<String, String> getAppIdAndSecret() {
        LambdaQueryWrapper<SysParam> qw = new LambdaQueryWrapper<>();
        qw.eq(SysParam::getParamClass, Constant.APPID_SECRET);
        List<SysParam> list = this.list(qw);
        Map<String, String> map = new HashMap<>(2);
        for (SysParam param : list) {
            map.put(param.getParamName(), param.getParamValue());
        }
        return map;
    }

    /**
     * 获取注册用户信息
     *
     * @return Map<String, String>
     */
    @Override
    public Map<String, String> getRegisterUser() {
        LambdaQueryWrapper<SysParam> qw = new LambdaQueryWrapper<>();
        qw.eq(SysParam::getParamClass, Constant.REGISTER_USER);
        List<SysParam> list = this.list(qw);
        Map<String, String> map = new HashMap<>(3);
        for (SysParam param : list) {
            map.put(param.getParamName(), param.getParamValue());
        }
        return map;
    }
}
