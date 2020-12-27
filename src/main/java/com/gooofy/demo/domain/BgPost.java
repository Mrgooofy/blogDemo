package com.gooofy.demo.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BgPost {

    private Long id;
    private String title;
    private String author;
    private String editor;
    private String content;
    private String tag;
    private Integer readNum;
    private Integer likeNum;
    private String brief;
    private String previewImg;
    private Timestamp createTime;
    private Timestamp updateTime;

    /** recent read time  */
    private Timestamp readTime;
    /** recent like time */
    private Timestamp likeTime;

}
