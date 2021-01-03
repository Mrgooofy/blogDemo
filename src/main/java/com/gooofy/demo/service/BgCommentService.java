package com.gooofy.demo.service;


import com.gooofy.demo.domain.BgComment;
import com.gooofy.demo.domain.BgPost;

import java.util.List;

/**
 * post comment
 */
public interface BgCommentService {

    List<BgComment> list(BgComment bgComment);

    int save(BgComment bgComment);

    int delete(Long id);

}
