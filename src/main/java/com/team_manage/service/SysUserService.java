package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.user.dto.LoginDTO;
import com.team_manage.controller.user.dto.WebUserDTO;
import com.team_manage.controller.user.dto.WxLoginDTO;
import com.team_manage.controller.user.dto.WxUserDTO;
import com.team_manage.controller.user.query.WebUserQry;
import com.team_manage.controller.user.vo.WebLoginVO;
import com.team_manage.controller.user.vo.WebUserVO;
import com.team_manage.controller.user.vo.WxUserVO;
import com.team_manage.controller.user.vo.WxUserVO1;
import com.team_manage.entity.SysUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 用户登录
     *
     * @param loginDTO 用户登录DTO
     * @return WebLoginVO
     */
    WebLoginVO login(LoginDTO loginDTO);

    /**
     * 微信用户登录
     *
     * @param loginDTO 微信登录DTO
     * @return WebLoginVO
     */
    WebLoginVO wxLogin(WxLoginDTO loginDTO);

    /**
     * 修改用户信息
     *
     * @param userDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(WxUserDTO userDTO);

    /**
     * 获取登录用户信息
     *
     * @return WxUserVO
     */
    WxUserVO mine();

    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<WebUserVO> pageByQry(WebUserQry qry);

    /**
     * 查询用户信息
     *
     * @param userId 用户ID
     * @return WxUserVO1
     */
    WxUserVO1 user(Long userId);

    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return Boolean
     */
    Boolean del(Long userId);

    /**
     * 修改用户信息
     *
     * @param userId  用户ID
     * @param userDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long userId, WebUserDTO userDTO);

    /**
     * 新增用户信息
     *
     * @param userDTO 用户DTO
     * @return Boolean
     */
    Boolean add(WebUserDTO userDTO);

    /**
     * 用户信息详情
     *
     * @param userId 用户ID
     * @return WebUserVO
     */
    WebUserVO detail(Long userId);
}
