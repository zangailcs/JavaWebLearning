package com.lcs.service.imp;

import com.lcs.dao.EmpDao;
import com.lcs.pojo.Emp;
import com.lcs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();

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
        return empList;
    }
}
