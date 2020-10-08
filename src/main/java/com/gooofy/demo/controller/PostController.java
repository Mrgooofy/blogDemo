package com.gooofy.demo.controller;

import com.gooofy.demo.common.ApiResponse;
import com.gooofy.demo.domain.BgPost;
import com.gooofy.demo.domain.BgUser;
import com.gooofy.demo.service.BgPostService;
import com.gooofy.demo.service.BgUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * post控制器
 */
@RestController
@Api(value = "post接口")
@RequestMapping("/post")
public class PostController {

    @Autowired
    private BgPostService bgPostService;


    @ApiOperation("文章列表")
    @GetMapping("")
    public ApiResponse list( BgPost bgPost) {
    //public ApiResponse list() {
        List<BgPost> list = bgPostService.list(bgPost);

        return ApiResponse.success(list);

    }

    @ApiOperation("新增文章")
    @PostMapping("")
    public ApiResponse add(@RequestBody BgPost bgPost) {

        return ApiResponse.success(bgPostService.save(bgPost));
    }

    @ApiOperation("新增文章")
    @PutMapping("")
    public ApiResponse edit(@RequestBody BgPost bgPost) {

        return ApiResponse.success(bgPostService.edit(bgPost));
    }

    @ApiOperation("新增文章")
    @DeleteMapping("")
    public ApiResponse delete(Integer id) {

        return ApiResponse.success(bgPostService.delete(id));
    }

}