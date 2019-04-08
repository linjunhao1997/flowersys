package com.junhow.gp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Wang926454
 * @date 2018/11/16 19:29
 */
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.junhow.gp.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
