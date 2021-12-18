package com.gooofy.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp updateTime;
}
