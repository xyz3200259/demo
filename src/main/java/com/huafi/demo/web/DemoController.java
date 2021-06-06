package com.huafi.demo.web;

import org.reap.support.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${test.parameter}")
    private String parameter;
    @GetMapping
    public void dempDatasource(){

    }
    @GetMapping("/parameter")
    public Result<String> demoParameter(){
    return Result.newResult(parameter);
    }
}
