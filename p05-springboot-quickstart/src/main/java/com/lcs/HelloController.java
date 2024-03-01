package com.lcs;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 请求处理类
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        System.out.println(name + ":" + age);
        return "Hello, simpleParam: " + name + ":" + age;
    }

    /**
     * 简单参数示例
     *
     * @param userName 字符串 演示RequestParam；默认required=true，不填报错400
     * @param age 整形，封装类型好处：不传时不会报错，如果用int，不传时报错500
     * @return str
     */
    @RequestMapping("/simpleParamBySpringBoot")
    public String simpleParamBySpringBoot(@RequestParam(name = "name", required = false) String userName, Integer age) {
        System.out.println(userName + ":" + age);
        return "Hello, simpleParamBySpringBoot: " + userName + ":" + age;
    }

}
