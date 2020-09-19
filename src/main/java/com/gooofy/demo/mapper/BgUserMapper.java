package com.gooofy.demo.mapper;

import com.gooofy.demo.domain.BgUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface BgUserMapper {

    @Insert("<script> insert into bg_user (username, password) values (#{username}, #{password}) </script>")
    int save(BgUser bgUser);

    @Select("<script> select * from bg_user where username = #{usernmae} order by id desc limit 1 </script>")
    BgUser findByUsername(String username);

}
