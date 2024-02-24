package com.lcs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 请求处理类
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }
}
