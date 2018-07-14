package com.example.springbootwebrestfulcrud;

import com.example.springbootwebrestfulcrud.dao.DepartmentDao;
import com.example.springbootwebrestfulcrud.dao.EmployeeDao;
import com.example.springbootwebrestfulcrud.mapper.DepartMapper;
import com.example.springbootwebrestfulcrud.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebRestfulcrudApplicationTests {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
   DepartMapper departMapper;


    @Autowired
    EmployeeDao employeeDao;
    @Test
    public void haha(){

    }


}








