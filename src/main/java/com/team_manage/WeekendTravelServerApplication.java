package com.team_manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author XXX
 */
@SpringBootApplication
@EnableTransactionManagement
public class WeekendTravelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekendTravelServerApplication.class, args);
    }

}
