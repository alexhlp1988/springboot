package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//以json响应数据，无需配置jackson
@RestController
//@Controller
public class HelloController {
    @RequestMapping("hellospringboot")
    public String hello(){
        return "Hello Spring Boot.";
    }


}
