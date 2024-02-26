package com.team_manage.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * sql like查询条件特殊字符处理工具类
 *
 * @author ZSL
 * @since 2023-08-11
 */
public class SpecialCharacterUtil {
    private SpecialCharacterUtil() {
        throw new IllegalStateException("SpecialCharacterUtil class");
    }

    /**
     * sql like查询条件特殊字符处理
     *
     * @param str 查询条件
     * @return 处理后的结果
     */
    public static String escapeStr(String str) {
        if (StringUtils.isNotBlank(str)) {
            // 替换
            str = str.replace("\\", "\\\\");
            str = str.replace("_", "\\_");
            str = str.replace("%", "\\%");
            str = str.replace("'", "\\'");
        }
        return str;
    }
}
