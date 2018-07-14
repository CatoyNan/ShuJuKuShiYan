package com.example.springbootwebrestfulcrud.dao;


import com.example.springbootwebrestfulcrud.entities.Department;
import com.example.springbootwebrestfulcrud.mapper.DepartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDao {
    @Autowired
    DepartMapper departMapper;


   private static Map<Integer,Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

    }
    public Collection<Department> getDepartments() {
        for(int i=0;i<departMapper.getDepLists().size();i++){
            departments.put(departMapper.getDepLists().get(i).getId(),departMapper.getDepLists().get(i));
        }
        return departments.values();
    }
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
    public Department getDepartmentByName(String deptName){
        return departMapper.getDepByName(deptName);
    }
    public void insertDept(String departName){
        departMapper.insertDept(departName);
    }

    //根据id删除部门
    public void deleteDeptById(Integer id){
        departMapper.deleteDeptById(id);
        departments.remove(id);
    }

    //根据id查询部门
    public Department getDeptById(Integer id){
        return departMapper.getDepById(id);
    }


}
