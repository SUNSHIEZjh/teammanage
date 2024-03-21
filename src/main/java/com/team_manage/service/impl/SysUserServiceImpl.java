package com.team_manage.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.common.ExceptionConstant;
import com.team_manage.controller.user.dto.LoginDTO;
import com.team_manage.controller.user.dto.WebUserDTO;
import com.team_manage.controller.user.dto.WxLoginDTO;
import com.team_manage.controller.user.dto.WxUserDTO;
import com.team_manage.controller.user.query.WebUserQry;
import com.team_manage.controller.user.vo.*;
import com.team_manage.entity.SysRole;
import com.team_manage.entity.SysUser;
import com.team_manage.entity.SysUserRole;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.FollowInfoMapper;
import com.team_manage.mapper.SysUserMapper;
import com.team_manage.mapper.SysUserRoleMapper;
import com.team_manage.service.SysParamService;
import com.team_manage.service.SysUserService;
import com.team_manage.utils.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * Redis工具
     */
    private final RedisUtil redisUtil;

    /**
     * 用户角色Mapper
     */
    private final SysUserRoleMapper userRoleMapper;

    /**
     * 参数Service
     */
    private final SysParamService paramService;

    private final FollowInfoMapper followInfoMapper;


    /**
     * Web用户登录
     *
     * @param loginDTO 用户登录DTO
     * @return WebLoginVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WebLoginVO login(LoginDTO loginDTO) {
        // 密码登录
        if (redisUtil.hasKey(Constant.SMS_CODE + loginDTO.getCode().toLowerCase())) {
            // 清除验证码
            redisUtil.del(Constant.SMS_CODE + loginDTO.getCode().toLowerCase());
            // 登录校验
            SysUser user = new LambdaQueryChainWrapper<>(baseMapper)
                    .eq(SysUser::getUserAccount, loginDTO.getUserAccount())
                    .one();
            // 判断用户是否为空
            if (user != null) {
                // 密码校验
                if (SaltUtils.verify(loginDTO.getUserPassword(), user.getUserSalt(), user.getUserPassword())) {
                    return getWebLoginVO(user);
                } else {
                    // 如果密码错误，返回消息
                    throw new ServiceException(ExceptionConstant.INCORRECT_USERNAME_OR_PASSWORD);
                }
            } else {
                throw new ServiceException(ExceptionConstant.INCORRECT_USERNAME_OR_PASSWORD);
            }
        } else {
            throw new ServiceException(ExceptionConstant.VERIFICATION_CODE_ERROR);
        }
    }

    /**
     * 微信用户登录
     *
     * @param loginDTO 微信登录DTO
     * @return WebLoginVO
     */
    @Override
    public WebLoginVO wxLogin(WxLoginDTO loginDTO) {
        // 微信登录授权
        Map<String, String> map = paramService.getAppIdAndSecret();
        Map<String, String> param = new HashMap<>(4);
        param.put("appid", map.get(Constant.APPID));
        param.put("secret", map.get(Constant.SECRET));
        param.put("js_code", loginDTO.getCode());
        param.put("grant_type", "authorization_code");
        String str = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/jscode2session", param);
        JSONObject json = JSON.parseObject(str);
        String openId = null;
        if (json.get(Constant.OPEN_ID) != null) {
            openId = json.getString(Constant.OPEN_ID);
        }
        // 判断openId是否获取成功
        if (StringUtils.isBlank(openId)) {
            throw new ServiceException("openId获取失败!");
        }
        // 根据openId查询用户信息是否存在
        SysUser user = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(SysUser::getUserAccount, openId)
                .one();
        // 判断用户是否存在
        if (ObjectUtils.isEmpty(user)) {
            // 不存在，新增逻辑
            Map<String, String> registerMaps = paramService.getRegisterUser();
            // 预生成用户ID
            Long userId = IdUtils.getLongId();
            // 设置用户信息
            user = new SysUser()
                    .setUserId(userId)
                    .setUserAccount(openId)
                    .setUserName(registerMaps.get(Constant.DEFAULT_WX_USER_NAME))
                    .setUserAvatar(registerMaps.get(Constant.DEFAULT_WX_USER_IMG))
                    .setLastLoginTime(new Date());
            // 保存用户信息
            this.save(user);
            // 保存用户角色关系
            userRoleMapper.insert(new SysUserRole()
                    .setUserId(userId)
                    .setRoleId(Long.valueOf(registerMaps.get(Constant.REGISTER_WX_USER_ROLE)))
            );
        }
        // 调用登录信息
        return getWebLoginVO(user);
    }

    /**
     * 修改用户信息
     *
     * @param userDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(WxUserDTO userDTO) {
        // 获取登录用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        SysUser user = CopyUtils.classCopy(userDTO, SysUser.class);
        // 设置用户ID
        user.setUserId(userId);
        // 根据ID更新信息
        this.updateById(user);
        // 更新redis中缓存
        StpUtil.getSession().set("user", this.getById(userId));
        // 返回成功
        return true;
    }

    /**
     * 获取登录用户信息
     *
     * @return WxUserVO
     */
    @Override
    public WxUserVO mine() {
        return CopyUtils.classCopy(this.getById(StpUtil.getLoginIdAsLong()), WxUserVO.class);
    }

    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    @Override
    public IPage<WebUserVO> pageByQry(WebUserQry qry) {
        IPage<WebUserVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return baseMapper.pageByQry(qry, pages);
    }

    /**
     * 查询用户信息
     *
     * @param userId 用户ID
     * @return WxUserVO1
     */
    @Override
    public WxUserVO1 user(Long userId) {
        WxUserVO1 user = CopyUtils.classCopy(this.getById(userId), WxUserVO1.class);
        // 用户ID
        long loginId;
        try {
            loginId = StpUtil.getLoginIdAsLong();
        } catch (Exception e) {
            loginId = Constant.LONG_ZERO;
        }
        // 判断是否关注用户
        FollowInfoVO check = followInfoMapper.check(loginId, userId);
        if (ObjectUtils.isNotEmpty(check)) {
            user.setFollowId(check.getFollowId());
        } else {
            user.setFollowId(Constant.LONG_ZERO);
        }
        return user;
    }

    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long userId) {
        // 登出当前用户
        StpUtil.logout(userId);
        // 删除用户信息
        return this.removeById(userId);
    }

    /**
     * 修改用户信息
     *
     * @param userId  用户ID
     * @param userDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long userId, WebUserDTO userDTO) {
        SysUser one = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(SysUser::getUserAccount, userDTO.getUserAccount())
                .ne(SysUser::getUserId, userId)
                .one();
        if (ObjectUtils.isNotEmpty(one)) {
            throw new ServiceException("用户账号已存在，修改失败!");
        }
        // 登出当前用户 -- 自己修改 暂不做退出登录
//        StpUtil.logout(userId);
        // 修改用户信息
        SysUser user = CopyUtils.classCopy(userDTO, SysUser.class);
        user.setUserId(userId);
        // 删除用户角色信息
        new LambdaUpdateChainWrapper<>(userRoleMapper)
                .eq(SysUserRole::getUserId, userId)
                .remove();
        // 新增用户角色信息
        userRoleMapper.insert(new SysUserRole().setUserId(user.getUserId()).setRoleId(userDTO.getRoleId()));
        // 修改用户信息
        return this.updateById(user);
    }

    /**
     * 新增用户信息
     *
     * @param userDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean add(WebUserDTO userDTO) {
        SysUser one = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(SysUser::getUserAccount, userDTO.getUserAccount())
                .one();
        if (ObjectUtils.isNotEmpty(one)) {
            throw new ServiceException("用户账号已存在，新增失败!");
        }
        // 新增用户
        SysUser user = CopyUtils.classCopy(userDTO, SysUser.class);
        // // 新增用户信息
        this.save(user);
        // 新增用户角色信息
        userRoleMapper.insert(new SysUserRole().setUserId(user.getUserId()).setRoleId(userDTO.getRoleId()));
        return true;
    }

    /**
     * 用户信息详情
     *
     * @param userId 用户ID
     * @return WebUserVO
     */
    @Override
    public WebUserVO detail(Long userId) {
        return baseMapper.detail(userId);
    }

    @Override
    public Boolean editPassword(Long userId, String oldPassword, String newPassword) {
        SysUser sysUser = baseMapper.selectById(userId);
        if (ObjectUtils.isNotEmpty(sysUser)) {
            if (SaltUtils.verify(oldPassword, sysUser.getUserSalt(), sysUser.getUserPassword())) {
                if (StringUtils.isNotEmpty(sysUser.getUserSalt())) {
                    sysUser.setUserPassword(SaltUtils.md5Password(newPassword, sysUser.getUserSalt()));
                } else {
                    sysUser.setUserPassword(newPassword);
                }
                return baseMapper.updateById(sysUser) > 0;
            } else {
                throw new ServiceException("旧密码错误，请确认!");
            }
        } else {
            throw new ServiceException(ExceptionConstant.INCORRECT_USERNAME_OR_PASSWORD);
        }
    }

    /**
     * 获取微信登录用户信息
     *
     * @param user 用户信息
     * @return WxLoginVO
     */
    private WebLoginVO getWebLoginVO(SysUser user) {
        // 初始化
        WebLoginVO webLoginVO = new WebLoginVO();
        // 存在，登录逻辑
        StpUtil.login(user.getUserId());
        // 缓存用户信息
        StpUtil.getSession().set("user", user);
        // 存入返回VO
        webLoginVO.setUserId(user.getUserId())
                .setUserName(user.getUserName())
                .setUserAvatar(user.getUserAvatar());
        // 查询用户角色
        SysRole role = userRoleMapper.selectRoleByUserId(user.getUserId());
        if (ObjectUtils.isNotEmpty(role)) {
            // 存入返回VO
            webLoginVO.setRoleId(role.getRoleId()).setRoleName(role.getRoleName()).setRoleFlag(role.getRoleFlag());
        } else {
            throw new ServiceException(ExceptionConstant.FAILED_TO_OBTAIN_USER_ROLE);
        }
        // 获取登录用户信息
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 设置tokenInfo信息和saToken信息
        webLoginVO.setTokenInfo(tokenInfo).setSaToken(tokenInfo.getTokenValue());
        // 更新登录时间
        new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(SysUser::getUserId, user.getUserId())
                .set(SysUser::getLastLoginTime, new Date())
                .update();
        // 返回登录信息
        return webLoginVO;
    }
}
