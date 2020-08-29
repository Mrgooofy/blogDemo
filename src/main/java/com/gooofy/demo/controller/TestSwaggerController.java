package com.gooofy.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户接口")
@RestController
@RequestMapping("/test-swaggerui")
public class TestSwaggerController {


    @RequestMapping(value = "/about-us2", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试",notes = "测试接口")
    public String test3(  @PathVariable String name)
    {
        return name;
    }
}
