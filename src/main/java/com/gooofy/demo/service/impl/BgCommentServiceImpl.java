package com.gooofy.demo.service.impl;

import com.gooofy.demo.domain.BgComment;
import com.gooofy.demo.domain.BgPost;
import com.gooofy.demo.mapper.BgCommentMapper;
import com.gooofy.demo.mapper.BgPostMapper;
import com.gooofy.demo.service.BgCommentService;
import com.gooofy.demo.service.BgPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BgCommentServiceImpl implements BgCommentService {

    @Autowired
    private BgCommentMapper bgCommentMapper;

    @Override
    public List<BgComment> list(BgComment bgComment) {
        return bgCommentMapper.list(bgComment);
    }

    @Override
    public int save(BgComment bgComment) {
        return bgCommentMapper.save(bgComment);
    }

    @Override
    public int delete(Long id) {
        return bgCommentMapper.delete(id);
    }

    @Override
    public int addLike(BgComment bgComment) {
        return bgCommentMapper.addLike(bgComment);
    }
}
