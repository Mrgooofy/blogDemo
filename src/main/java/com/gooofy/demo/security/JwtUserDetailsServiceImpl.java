package com.gooofy.demo.security;


import com.gooofy.demo.domain.BgUser;
import com.gooofy.demo.service.BgUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * 用户验证方法
 *
 * @author hackyo
 * Created on 2017/12/8 9:18.
 */
@Slf4j
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private BgUserService bgUserService;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BgUser user = bgUserService.findByUsername(username);
        if (user == null) {
            log.info("未找到用户");
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new JwtUser(user.getUsername(), user.getPassword());
        }
    }

}