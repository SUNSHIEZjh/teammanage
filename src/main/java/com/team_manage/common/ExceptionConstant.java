package com.team_manage.common;

/**
 * 异常提示常量定义
 *
 * @author XXX
 * @since 2023-11-09
 */
public class ExceptionConstant {
    private ExceptionConstant() {
    }

    /**
     * 用户名或密码错误!
     */
    public static final String INCORRECT_USERNAME_OR_PASSWORD = "用户名或密码错误!";

    /**
     * 验证码错误!
     */
    public static final String VERIFICATION_CODE_ERROR = "验证码错误!";

    /**
     * 获取用户角色失败,请联系管理员!
     */
    public static final String FAILED_TO_OBTAIN_USER_ROLE = "获取用户角色失败,请联系管理员!";

    /**
     * 角色已存在,新增失败!
     */
    public static final String ROLE_ALREADY_EXISTS_ADD_FAILED = "角色已存在,新增失败!";

    /**
     * 角色已存在,角色修改失败!
     */
    public static final String ROLE_ALREADY_EXISTS_UPDATE_FAILED = "角色已存在,角色修改失败!";

    /**
     * 角色正在被用户使用,删除失败!
     */
    public static final String ROLE_USED_BY_USER_DELETE_FAILED = "角色正在被用户使用,删除失败!";

    /**
     * 获取登录用户菜单树失败!
     */
    public static final String FAILED_TO_OBTAIN_LOGIN_USER_MENU_TREE = "获取登录用户菜单树失败!";
}
