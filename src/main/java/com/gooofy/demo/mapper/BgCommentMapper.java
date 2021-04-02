package com.gooofy.demo.mapper;

import com.gooofy.demo.domain.BgComment;
import com.gooofy.demo.domain.BgPost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface BgCommentMapper {

    @Select("<script> select * from bg_comment where   </script>")
    List<BgComment> list(BgComment bgComment);

    @Insert("<script> insert into  bg_comment (post_id, reply_id, content) " +
            "values (#{postId}, #{replyId},#{content}) </script>")
    int save(BgComment bgComment);


    @Delete("<script> delete bg_comment  where id = #{id} </script>")
    int delete(Long id);

    @Update("<script>UPDATE bg_comment SET like = like + 1 where id = #{id} </script>")
    int addLike(BgComment bgComment);
}
