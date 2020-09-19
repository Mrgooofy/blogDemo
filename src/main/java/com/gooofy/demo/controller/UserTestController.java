package com.gooofy.demo.controller;

import com.gooofy.demo.domain.User;
import com.gooofy.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/test")
@Api(value = "SpringBoot测试接口")
public class UserTestController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/jdbc")
    @ApiOperation(value = "整合jdbc测试")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "旧密码", required = true, dataType = "String")
    })
    public String test1(String username, String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        return userService.AddUser(u) + "";

    }


    @ResponseBody
    @PostMapping(value = "/jdbc2")
    @ApiOperation(value = "整合jdbc测试 select")
    public Map<String, Object> test2() {

        return userService.getUser();
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){

        log.info("检测 hello ");

        return "hello";
    }


}
