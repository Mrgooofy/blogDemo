package com.gooofy.demo.common;

/**
 * 全局接口状态码
 */
public enum ApiCode {
    /**
     * 通用成功
     */
    API_OK(200, "ok"),
    /**
     * 用户名已存在
     */
    API_USERNAME_EXIST(1001, "username exists");

    private final int code;

    private final String msg;

    ApiCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}