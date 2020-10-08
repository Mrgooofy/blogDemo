package com.gooofy.demo.mapper;

import com.gooofy.demo.domain.BgPost;
import com.gooofy.demo.domain.BgUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface BgPostMapper {


    @Select("<script> select * from bg_post </script>")
    List<BgPost> list(BgPost bgPost);

    @Insert("<script> insert into  bg_post (title, author, editor, content, tag, preview_img, brief) " +
            "values (#{title}, #{author}, #{editor}, #{content}, #{tag}, #{previewImg}, #{brief}) </script>")
    int save(BgPost bgPost);

    @Update("<script> update bg_post set title = #{title},  author = #{author}, editor = #{editor} , content = #{content}, " +
            "tag = #{tag}, preview_img = #{previewImg}, brief = #{brief} where id = #{id} " +
            "</script>")
    int edit(BgPost bgPost);

    @Delete("<script> delete bg_post  where id = #{id} </script>")
    int delete(Integer id);
}
