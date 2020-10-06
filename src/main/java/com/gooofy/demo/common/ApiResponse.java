package com.gooofy.demo.common;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @param <T>
 */
@Data
@AllArgsConstructor
@JsonPropertyOrder({"code", "msg", "data"})
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自定义返回码
     */
    private int code;

    /**
     * 自定义返回说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功返回，无数据
     *
     * @return 自定义的 ApiResponse 对象
     */
    public static ApiResponse<Object> success() {
        return new ApiResponse<>(ApiCode.API_OK.code(), ApiCode.API_OK.getMsg(), "");
    }

    /**
     * 成功返回，有数据
     *
     * @param object 返回数据
     * @param <T>  返回数据类型
     * @return 自定义的 ApiResponse 对象
     */
    public static <T> ApiResponse<T> success(T object) {
        return new ApiResponse<>(ApiCode.API_OK.code(), ApiCode.API_OK.getMsg(), object);
    }

    /**
     * 失败返回
     *
     * @param apiCode 错误码
     * @return 自定义的 ApiResponse 对象
     */
    public static ApiResponse<Object> fail(ApiCode apiCode) {
        return new ApiResponse<>(apiCode.code(), apiCode.getMsg(), "");
    }
}

