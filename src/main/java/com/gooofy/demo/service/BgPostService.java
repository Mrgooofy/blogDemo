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
}
