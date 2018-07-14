package com.example.springbootwebrestfulcrud.controller;


import com.example.springbootwebrestfulcrud.dao.DepartmentDao;
import com.example.springbootwebrestfulcrud.dao.EmployeeDao;
import com.example.springbootwebrestfulcrud.entities.Department;
import com.example.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;




//
//    @PostMapping(value = "/hello")
//    public String login(Model model){
//        return "login";
//    }

    /**
     * 查询所有员工返回列表页面
     */
    @GetMapping(value = "/emps")
    public String list(Model model){
//        Collection<EmployeeShuJu> employeeShuJus = employeeDao.getAll();
          Collection<Employee> employees = employeeDao.getAll();

//        Collection<Department> departments = null;

//        System.out.println(((List<EmployeeShuJu>) employees).get(0).getLastName());
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 员工Id搜索
     */
    @GetMapping(value = "emps/search/{id}")
    public String selectEmpById(@PathVariable("id") Integer id,Model model){
       Employee employee = employeeDao.getEmpById(id);
       model.addAttribute("emps",employee);
       return "emp/list2";
    }
    /**
     * 员工按部门搜索
     */
    @GetMapping(value = "emps/search/Bydept/{deptName}")
    public String selectEmpBydeptName(@PathVariable("deptName") String deptName,Model model){
        Collection<Employee> employees = employeeDao.getEmpByDeptName(deptName);
        model.addAttribute("emps",employees);
        return "emp/list2";
    }
    /**
     * 员工按性别搜索
     */
    @GetMapping(value = "emps/search/ByGender/{gender}")
    public String selectEmpBydeptName(@PathVariable("gender") Integer gender,Model model){
        Collection<Employee> employees = employeeDao.getEmpByGender(gender);
        model.addAttribute("emps",employees);
        return "emp/list2";
    }
    /**
     * 员工按名字搜索
     */
    @GetMapping(value = "emps/search/ByLastName/{lastname}")
    public String selectEmpByLastName(@PathVariable("lastname") String  lastname,Model model){
        Collection<Employee> employees = employeeDao.getEmpByLastName(lastname);
        model.addAttribute("emps",employees);
        return "emp/list2";
    }
    /**
     * 跳转到添加员工页面
     */
    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有部门显示
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }
    /**
     * 员工添加
     */
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee,employee.getDepartment().getId());
        //来到员工列表页面、redirect:重定向到一个地址，forward转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 员工编辑页面
     */
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id ,Model model){
        Employee emp = employeeDao.getEmpById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",emp);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 员工编辑功能实现
     */

    @PutMapping(value="/emp")
    public String editEmp(Employee employee){
        employeeDao.upDateById(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除
     */
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.deleteEmpById(id);
        return "redirect:/emps";
    }





}
