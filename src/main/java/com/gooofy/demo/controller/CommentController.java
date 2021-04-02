package com.gooofy.demo.controller;

import com.gooofy.demo.common.ApiResponse;
import com.gooofy.demo.domain.BgComment;
import com.gooofy.demo.domain.BgPost;
import com.gooofy.demo.service.BgCommentService;
import com.gooofy.demo.service.BgPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * post Add comment controller
 * POST controller
 */
@RestController
@Api(value = "post add comment controller")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private BgCommentService bgCommentService;


    @ApiOperation("comment list")
    @GetMapping("")
    public ApiResponse list( BgComment bgComment) {

        // need post id
        List<BgComment> list = bgCommentService.list(bgComment);
        return ApiResponse.success(list);
    }

    @ApiOperation("add post comment")
    @PostMapping("")
    public ApiResponse add(@RequestBody BgComment bgComment) {

        return ApiResponse.success(bgCommentService.save(bgComment));
    }

    @ApiOperation("add post like")
    @PostMapping("/add-like")
    public ApiResponse addLike(@RequestBody BgComment bgComment) {

        return ApiResponse.success(bgCommentService.addLike(bgComment));
    }

    @ApiOperation("delete post comment")
    @DeleteMapping("")
    public ApiResponse delete(Long id) {

        return ApiResponse.success(bgCommentService.delete(id));
    }

}