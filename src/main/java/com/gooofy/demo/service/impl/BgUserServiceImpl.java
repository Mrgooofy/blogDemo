package com.gooofy.demo.service.impl;

import com.gooofy.demo.domain.BgUser;
import com.gooofy.demo.mapper.BgUserMapper;
import com.gooofy.demo.security.JwtTokenUtil;
import com.gooofy.demo.security.JwtUserDetailsServiceImpl;
import com.gooofy.demo.service.BgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BgUserServiceImpl implements BgUserService {

    @Autowired
    private BgUserMapper bgUserMapper;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Autowired
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String register(BgUser user) {
        String username = user.getUsername();
        if (this.findByUsername(username) != null) {
            return "用户已存在";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassword();
        //user.setPassword(encoder.encode(rawPassword));
        user.setPassword(rawPassword);
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
