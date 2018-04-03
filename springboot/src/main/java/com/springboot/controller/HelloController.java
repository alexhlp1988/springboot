package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//以json响应数据，无需配置jackson
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "Hello Spring Boot.";
    }
}
