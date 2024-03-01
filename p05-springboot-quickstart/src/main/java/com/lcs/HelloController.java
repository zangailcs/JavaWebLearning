package com.lcs;

import com.lcs.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "Hello, simplePojo: " + user;
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "Hello, complexPojo: " + user;
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "Hello, arrayParam: " + Arrays.toString(hobby);
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "Hello, arrayParam: " + hobby;
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "Hello, jsonParam: " + user;
    }

    /**
     * 路径参数
     *
     * @param id 路径参数
     * @return str
     */
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "Hello, pathParam: " + id;
    }
}
