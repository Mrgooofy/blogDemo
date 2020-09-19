package com.gooofy.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.gooofy.demo.domain.BgUser;
import com.gooofy.demo.service.BgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

/**
 * 登录控制器
 * @author Louis
 * @date Jun 29, 2019
 */
@RestController
public class LoginController {

    @Autowired
    private BgUserService bgUserService;

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody BgUser loginBean, HttpServletRequest request) throws IOException {
        return bgUserService.login(loginBean.getUsername(), loginBean.getPassword());
    }


    /**
     * 用户注册
     *
     * @param user          用户信息
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/register")
    public String register(@RequestBody BgUser user) throws AuthenticationException {
        return bgUserService.register(user);
    }

}