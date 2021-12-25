package com.gooofy.demo.service;

import com.gooofy.demo.domain.BgUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BgUserServiceTest {

    @Autowired
    private BgUserService bgUserService;

    @Test
    void findByUsername() {
        BgUser bgUser =  bgUserService.findByUsername("testusername");
        Assertions.assertNotNull(bgUser);
    }

    @Test
    void save() {
        BgUser bgUser = new BgUser();
        bgUser.setEmail("xx@xx.com");
        bgUser.setNickname("nickname");
        bgUser.setPassword("1234");
        int num = bgUserService.save(bgUser);
        Assertions.assertTrue(num > 0);
    }
}