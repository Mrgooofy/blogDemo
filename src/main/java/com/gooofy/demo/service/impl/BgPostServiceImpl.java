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

    @Override
    public int delete(Integer id) {
        return bgPostMapper.delete(id);
    }

    @Override
    public int addViews(BgPost bgPost) {
        return bgPostMapper.addViews(bgPost);
    }

    @Override
    public int addLikes(BgPost bgPost) {
        return bgPostMapper.addLikes(bgPost);
    }

    @Override
    public List<BgPost> recentReadlist(BgPost bgPost) {
        return bgPostMapper.recentReadlist(bgPost);
    }

    @Override
    public List<BgPost> getRecentLikeList(BgPost bgPost) {
        return bgPostMapper.getRecentLikeList(bgPost);
    }

    @Override
    public List<BgPost> getHotReadNumPost(BgPost bgPost) {
        return bgPostMapper.getHotReadNumPost(bgPost);
    }

    @Override
    public List<BgPost> getPopularLikeNumPost(BgPost bgPost) {
        return bgPostMapper.getPopularLikeNumPost(bgPost);
    }
}
