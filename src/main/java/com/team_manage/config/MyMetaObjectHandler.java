package com.team_manage.config;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.team_manage.common.Constant;
import com.team_manage.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 配置自动填充时间
 *
 * @author XXX
 * @since 2023-11-09
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增数据时对字段的自动填充
     *
     * @param metaObject metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        SysUser user;
        try {
            user = JSON.parseObject(String.valueOf(JSON.toJSON(StpUtil.getSession().get("user"))), SysUser.class);
        } catch (Exception e) {
            user = null;
        }
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createId", Long.class, user == null ? 0L : user.getUserId());
        this.strictInsertFill(metaObject, "createName", String.class, user == null ? "系统" : user.getUserName());
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "deleteFlag", Integer.class, Constant.INTEGER_ZERO);
        this.setFieldValByName("deleteFlag", Constant.DELETE_FALSE, metaObject);
        // 修改一起填充
        updateFill(metaObject);
    }

    /**
     * 修改数据时对字段的自动填充
     *
     * @param metaObject metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        SysUser user;
        try {
            user = JSON.parseObject(String.valueOf(JSON.toJSON(StpUtil.getSession().get("user"))), SysUser.class);
        } catch (Exception e) {
            user = null;
        }
        // 起始版本 3.3.0(推荐)
        this.strictUpdateFill(metaObject, "updateId", Long.class, user == null ? 0L : user.getUserId());
        this.strictUpdateFill(metaObject, "updateName", String.class, user == null ? "系统" : user.getUserName());
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        // 增加方法，防止更新时存在该字段不覆盖原值
        this.setFieldValByName("updateId", user == null ? 0L : user.getUserId(), metaObject);
        this.setFieldValByName("updateName", user == null ? "系统" : user.getUserName(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }


}
