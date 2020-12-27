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

    @Update("<script> update bg_post set readNum = readNum + 1, read_time = NOW() where id = #{id} " +
            "</script>")
    int addViews(BgPost bgPost);

    @Update("<script> update bg_post set likeNum = likeNum + 1 where id = #{id} " +
            "</script>")
    int addLikes(BgPost bgPost);

    @Select("<script> select * from bg_post order by read_time desc limit 20 </script>")
    List<BgPost> recentReadlist(BgPost bgPost);

    @Select("<script> select * from bg_post order by read_nums desc limit 30 </script>")
    List<BgPost> getHotReadNumPost(BgPost bgPost);

    @Select("<script> select * from bg_post order by like_nums desc limit 30 </script>")
    List<BgPost> getPopularLikeNumPost(BgPost bgPost);

    @Select("<script> select * from bg_post order by like_time desc limit 20 </script>")
    List<BgPost> getRecentLikeList(BgPost bgPost);
}
