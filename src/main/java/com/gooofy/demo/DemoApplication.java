package com.gooofy.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
// @ComponentScan(basePackages={"com.gooofy.demo.controller","com.gooofy.demo.service"})
@Component
@SpringBootApplication(scanBasePackages = {"com.gooofy.demo.*"})
@MapperScan(basePackages ={"com.gooofy.demo.mapper"})
@ServletComponentScan(basePackages = "com.gooofy.demo.security")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
