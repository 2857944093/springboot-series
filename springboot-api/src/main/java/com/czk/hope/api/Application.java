package com.czk.hope.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 11:01
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.czk.hope") //用于扫描@Controller @Service
//@EnableJpaRepositories("com.czk.hope.entity.repository")   // 用于扫描Dao @Repository
//@EntityScan("com.czk.hope.entity.model") // 用于扫描JPA实体类 @Entity
@EnableSwagger2
@MapperScan("com.czk.hope.entity.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}