package com.gooofy.demo.service;

import com.gooofy.demo.domain.BgUser;
import org.springframework.stereotype.Service;

public interface BgUserService  {

    BgUser findByUsername(String username);

    int save(BgUser bgUser);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 操作结果
     */
    String login(String username, String password);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 操作结果
     */
    String register(BgUser user);

    /**
     * 刷新密钥
     *
     * @param oldToken 原密钥
     * @return 新密钥
     */
    String refreshToken(String oldToken);
}
