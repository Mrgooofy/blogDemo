package com.gooofy.demo.service;

import com.gooofy.demo.domain.User;

import java.util.Map;

public interface UserService {
    int AddUser(User user);

    Map<String, Object> getUser();
}
