package com.example.springbootwebrestfulcrud.controller;


import com.example.springbootwebrestfulcrud.dao.DepartmentDao;
import com.example.springbootwebrestfulcrud.dao.EmployeeDao;
import com.example.springbootwebrestfulcrud.entities.Department;
import com.example.springbootwebrestfulcrud.entities.Employee;
import com.example.springbootwebrestfulcrud.mapper.DepartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Collection;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    EmployeeDao employeeDao;
/*
    查询所有部门返回列表
 */
    @GetMapping(value = "/depts")
    public String  getDepartmentLists(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/dept";

    }
//    @GetMapping("/dept/{id}")
//    public Department getDepartment(@PathVariable("id") Integer id){
//        return departMapper.getDepById(id);
//    }
//
    @PostMapping(value="dept")
    public String insertDept(Department department){
        departmentDao.insertDept(department.getDepartmentName());
        return "redirect:/depts";
    }
    @GetMapping(value = "/search/dep/{deptName}")
    public void getDepartmentBiName(@PathVariable("deptName") String deptName){

        Department department=departmentDao.getDepartmentByName(deptName);
    }

    /**
     * 部门删除
     */
    @DeleteMapping(value = "/dept/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        departmentDao.deleteDeptById(id);
        employeeDao.deleteEmpByDepartment(id);

        return "redirect:/depts";
    }

    /**
     * 跳转到部门添加页面
     */
    @GetMapping(value = "/dept")
    public String toDeptEditPage(){
        return "emp/deptAdd";
    }


}
