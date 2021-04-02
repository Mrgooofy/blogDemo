package com.gooofy.demo.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * POST comment
 */
@Data
public class BgComment {

    private Long id;
    /** post id */
    private Long postId;
    /** reply comment id */
    private Long replyId;
    /** comment title */
    private String title;
    /** comment author */
    private String author;

    /** the commonet like nums */
    private Long like;

    /** comment content */
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;
}
