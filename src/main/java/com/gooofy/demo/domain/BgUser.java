package com.gooofy.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class BgUser {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp updateTime;

    private List<String> roles;

    public List<String> getRoles() {
        if(null == roles) {
            ArrayList<String> rolesArr = new ArrayList();
            rolesArr.add("ROLE_USER");
            roles = rolesArr;
        }
        return roles;
    }
}
