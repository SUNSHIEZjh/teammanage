package com.team_manage.common;

/**
 * 常量定义
 *
 * @author XXX
 * @since 2023-11-09
 */
public class Constant {

    private Constant() {
    }

    /**
     * 返回操作成功
     */
    public static final String SUCCESS = "操作成功!";

    /**
     * 返回成功的CODE
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 返回操作失败
     */
    public static final String FAIL = "操作失败!";

    /**
     * 返回失败的CODE
     */
    public static final int FAIL_CODE = 1;

    /**
     * 返回未登录的CODE
     */
    public static final int NO_LOGIN_CODE = -1;

    /**
     * JWT请求头
     */
    public static final String JWT_HEADER = "saToken";

    /**
     * 未删除标志位
     */
    public static final Integer DELETE_FALSE = 0;

    /**
     * INTEGER类型0
     */
    public static final Integer INTEGER_ZERO = 0;

    /**
     * INTEGER类型1
     */
    public static final Integer INTEGER_ONE = 1;

    /**
     * INTEGER类型2
     */
    public static final Integer INTEGER_TWO = 2;

    /**
     * INTEGER类型3
     */
    public static final Integer INTEGER_THREE = 3;

    /**
     * INTEGER类型4
     */
    public static final Integer INTEGER_FOUR = 4;

    /**
     * INTEGER类型111
     */
    public static final Integer INTEGER_ONE_HUNDRED_ELEVEN = 111;


    /**
     * INTEGER类型222
     */
    public static final Integer INTEGER_WNE_HUNDRED_TWENTY_TWO = 222;

    /**
     * 5分钟秒数
     */
    public static final Integer FIVE_MINUTE = 300;

    /**
     * REDIS存储验证码头
     */
    public static final String SMS_CODE = "code:";

    /**
     * 消息编码CODE
     */
    public static final String CODE = "code";

    /**
     * 验证码图片值
     */
    public static final String CODE_VALUE = "codeValue";

    /**
     * 注册用户
     */
    public static final String REGISTER_USER = "REGISTER_USER";

    /**
     * LONG类型0
     */
    public static final Long LONG_ZERO = 0L;

    /**
     * 时间格式：年-月-日
     */
    public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 时间格式：年-月-日 时:分:秒
     */
    public static final String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * APPID_SECRET
     */
    public static final String APPID_SECRET = "APPID_SECRET";

    /**
     * APPID
     */
    public static final String APPID = "APPID";

    /**
     * SECRET
     */
    public static final String SECRET = "SECRET";

    /**
     * OPENID
     */
    public static final String OPEN_ID = "openid";

    /**
     * 微信注册用户默认名称
     */
    public static final String DEFAULT_WX_USER_NAME = "DEFAULT_WX_USER_NAME";

    /**
     * 微信注册用户默认头像
     */
    public static final String DEFAULT_WX_USER_IMG = "DEFAULT_WX_USER_IMG";

    /**
     * 微信注册用户默认角色
     */
    public static final String REGISTER_WX_USER_ROLE = "REGISTER_WX_USER_ROLE";

    /**
     * DOUBLE_ZERO
     */
    public static final Double DOUBLE_ZERO = 0.00;

    /**
     * 点赞类型：1、话题 2、评论 3、攻略
     */
    public static final Integer LIKE_TYPE_TOPIC = 1;
    public static final Integer LIKE_TYPE_COMMENT = 2;
    public static final Integer LIKE_TYPE_INTRODUCTION = 3;

    /**
     * 收藏类型：1、话题 2、攻略
     */
    public static final Integer COLLECT_TYPE_TOPIC = 1;
    public static final Integer COLLECT_TYPE_INTRODUCTION = 2;

    /**
     * 通知类型：1、话题 2、攻略
     */
    public static final Integer NOTIFY_TYPE_TOPIC = 1;
    public static final Integer  NOTIFY_TYPE_INTRODUCTION = 2;


}
