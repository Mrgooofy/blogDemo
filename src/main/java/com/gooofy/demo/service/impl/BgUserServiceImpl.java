package com.gooofy.demo.service.impl;

import com.gooofy.demo.domain.BgUser;
import com.gooofy.demo.mapper.BgUserMapper;
import com.gooofy.demo.security.JwtTokenUtil;
import com.gooofy.demo.security.JwtUser;
import com.gooofy.demo.security.JwtUserDetailsServiceImpl;
import com.gooofy.demo.service.BgUserService;
import io.jsonwebtoken.Jwt;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BgUserServiceImpl implements BgUserService {

    @Autowired
    private BgUserMapper bgUserMapper;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtTokenUtil jwtTokenUtil;



    @Override
    public BgUser findByUsername(String username) {
        return bgUserMapper.findByUsername(username);
    }

    @Override
    public int save(BgUser bgUser) {
        return bgUserMapper.save(bgUser);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(upToken);

        System.out.println(authentication);
        if(!authentication.isAuthenticated()) {
            return "认证不通过";
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenUtil.generateToken(new JwtUser(authentication.getName()));
    }

    @Override
    public String register(BgUser user) {
        String username = user.getUsername();
        if (this.findByUsername(username) != null) {
            return "用户已存在";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String rawPassword = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(rawPassword));
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        user.setRoles(roles);
        this.save(user);
        return "success";
    }

    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring("Bearer ".length());
        if (!jwtTokenUtil.isTokenExpired(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return "error";
    }


}
