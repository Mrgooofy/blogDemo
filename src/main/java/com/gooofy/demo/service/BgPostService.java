package com.gooofy.demo.service;


import com.gooofy.demo.domain.BgPost;

import java.util.List;

/**
 * post
 */
public interface BgPostService {

    List<BgPost> list(BgPost bgPost);

    int save(BgPost bgPost);

    int edit(BgPost bgPost);

    int delete(Integer id);

    int addViews(BgPost bgPost);

    int addLikes(BgPost bgPost);

    List<BgPost> recentReadlist(BgPost bgPost);

    List<BgPost> getRecentLikeList(BgPost bgPost);

    List<BgPost> getHotReadNumPost(BgPost bgPost);

    List<BgPost> getPopularLikeNumPost(BgPost bgPost);
}
