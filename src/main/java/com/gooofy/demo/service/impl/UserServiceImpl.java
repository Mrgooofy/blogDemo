package com.gooofy.demo.service.impl;

import com.gooofy.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserServiceImpl implements com.gooofy.demo.service.UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int AddUser(User user) {
        String sql = "insert into t_user(username, password) values(?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    public Map<String, Object> getUser() {
        String sql = "select * from t_user limit 1";
        return jdbcTemplate.queryForMap(sql);
    }
}
