package com.team_manage.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.team_manage.utils.IdUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Mybatis-Plus分页插件配置
 *
 * @author XXX
 * @since 2023-11-09
 *
 */
@Configuration
@MapperScan("com.team_manage.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /**
     * 自定义ID生成
     *
     * @return GlobalConfig
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig conf = new GlobalConfig();
        conf.setDbConfig(new GlobalConfig.DbConfig().setKeyGenerator(new H2KeyGenerator()));
        return conf;
    }
}

/**
 * 替换老ID生成，使用自定义生成的方式
 */
@Component
class CustomerIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        // 填充自己的Id生成器，
        return IdUtils.getLongId();
    }
}
