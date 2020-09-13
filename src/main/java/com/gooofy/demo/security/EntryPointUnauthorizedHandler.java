package com.gooofy.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定401返回值
 *
 */
@Component
@Slf4j
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {

        log.info("验证失败.请重新登录");

        log.info(e.getMessage());
        e.printStackTrace();

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(401);

    }

}