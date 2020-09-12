package com.gooofy.demo.security;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Slf4j
@WebFilter(filterName = "JwtFilter", urlPatterns = "/user/*")
public class JwtFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        }
        // Except OPTIONS, other request should be checked by JWT
        else {

            if (token == null) {

                response.getWriter().write("{\"msg\": \"没有token！\", \"status\": 1}");
                return;
            }

            Claims userData = null;
            try {
                userData = JwtUtil.parseJWT(token);
            } catch (Exception e) {
                log.warn("没有token 合法");
                e.printStackTrace();
            }
            if (userData == null) {
                response.getWriter().write("token不合法！");
                return;
            }
            String nickname = userData.get("nickname", String.class);
            //拦截器 拿到用户信息，放到request中
            //request.setAttribute("id", id);
            //request.setAttribute("name", name);
            request.setAttribute("nickname", nickname);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}