package com.lcs.controller;

import com.lcs.pojo.Emp;
import com.lcs.pojo.Result;
import com.lcs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();
        // 响应数据
        return Result.success(empList);
    }
}
