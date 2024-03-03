package com.lcs.controller;

import com.lcs.pojo.Emp;
import com.lcs.pojo.Result;
import com.lcs.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result list() {
        // 加载并解析xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        // 数据进行转换处理
        empList.forEach(emp -> {
            // 性别
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            switch (Integer.parseInt(emp.getJob())) {
                case 1 -> emp.setJob("讲师");
                case 2 -> emp.setJob("班主任");
                case 3 -> emp.setJob("就业指导");
                default -> emp.setJob("无");
            }
        });

        // 响应数据
        return Result.success(empList);
    }
}
