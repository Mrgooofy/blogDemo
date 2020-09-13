package com.gooofy.demo.controller;


import com.gooofy.demo.domain.BgUser;
import com.gooofy.demo.service.BgUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BgUserService bgUserService;

    @ApiOperation("用户注册")
    @PostMapping("/signup")
    public void signUp(@RequestBody BgUser bgUser) {
        bgUserService.save(bgUser);
    }


    /**
     * 用户登录
     *
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/login")
    @ApiOperation("登录测试")
    public String getToken(@RequestBody BgUser bgUser) throws AuthenticationException {
        return bgUserService.login(bgUser.getUsername(), bgUser.getPassword());
    }

    /**
     * 用户注册
     *
     * @param user          用户信息
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/register")
    public String register(BgUser user) throws AuthenticationException {
        return bgUserService.register(user);
    }

    /**
     * 刷新密钥
     *
     * @param authorization 原密钥
     * @return 新密钥
     * @throws AuthenticationException 错误信息
     */
    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization) throws AuthenticationException {
        return bgUserService.refreshToken(authorization);
    }

}
