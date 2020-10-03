package com.gooofy.demo.domain;


import lombok.Data;

import java.sql.Timestamp;

/**
 * 文章
 */
@Data
public class BgArticle {

    private Long id;

    private String title;

    private String author;

    private String content;

    private String tags;
    private Timestamp createTime;
    private Timestamp updateTime;


}
