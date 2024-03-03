package com.lcs.dao.impl;

import com.lcs.dao.EmpDao;
import com.lcs.pojo.Emp;
import com.lcs.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpDapA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 加载并解析xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        return XmlParserUtils.parse(file, Emp.class);
    }
}
