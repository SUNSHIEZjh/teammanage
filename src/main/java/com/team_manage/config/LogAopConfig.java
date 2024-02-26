package com.team_manage.config;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.team_manage.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 切面日志
 *
 * @author ZSL
 * @since 2023-08-11
 */
@Aspect
@Configuration
public class LogAopConfig {
    private static final Logger logger = LoggerFactory.getLogger(LogAopConfig.class);

    @Pointcut(value = "execution(public * com.team_manage.controller..*(..))")
    public void execute() {
    }

    @Around("execute()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        assert servletRequestAttributes != null;
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        // 获取当前请求对象
        String uri = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        String queryString = httpServletRequest.getQueryString();
        Object[] args = pjp.getArgs();
        StringBuilder params = new StringBuilder();
        if (args.length > 0) {
            if ("POST".equals(method)) {
                // 获取请求参数
                for (Object o : args) {
                    if (null != o) {
                        Map<String, Object> map = getKeyAndValue(o);
                        if (!map.isEmpty()) {
                            params.append(map);
                        }
                    }
                }
            } else if ("GET".equals(method)) {
                params = new StringBuilder(StringUtils.isBlank(queryString) ? StringUtils.EMPTY : queryString);
            }
        }
        SysUser user;
        try {
            user = JSON.parseObject(String.valueOf(JSON.toJSON(StpUtil.getSession().get("user"))), SysUser.class);
        } catch (Exception e) {
            user = null;
        }
        long beginTime = System.currentTimeMillis();
        logger.info("用户：[{}-{}],请求URI:[{}],请求方式:[{}],参数:[{}]",
                user != null ? user.getUserId() : "-1",
                user != null ? user.getUserName() : "系统",
                uri, method, params);
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - beginTime;
        logger.info("请求结束，返回参数:[{}],执行时长：{}毫秒", result, time);
        return result;
    }

    public static Map<String, Object> getKeyAndValue(Object object) {
        Map<String, Object> map = new HashMap<>();
        Class<?> uCla = object.getClass();

        if (!(uCla.getPackage().getName().startsWith("com.team_manage")
                || uCla.getPackage().getName().startsWith("java."))) {
            return map;
        }

        Field[] fs = uCla.getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            Object val;
            try {
                val = f.get(object);
                map.put(f.getName(), val);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return map;
    }
}
