package com.gooofy.demo.service.impl;

import com.gooofy.demo.domain.BgPost;
import com.gooofy.demo.mapper.BgPostMapper;
import com.gooofy.demo.service.BgPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BgPostServiceImpl implements BgPostService {

    @Autowired
    private BgPostMapper bgPostMapper;

    @Override
    public List<BgPost> list(BgPost bgPost) {
        return bgPostMapper.list(bgPost);
    }

    @Override
    public int save(BgPost bgPost) {
        return bgPostMapper.save(bgPost);
    }

    @Override
    public int edit(BgPost bgPost) {
        return bgPostMapper.edit(bgPost);
    }
}
