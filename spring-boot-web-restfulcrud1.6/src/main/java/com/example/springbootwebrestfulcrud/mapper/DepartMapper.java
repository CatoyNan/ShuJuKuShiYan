package com.example.springbootwebrestfulcrud.mapper;


import com.example.springbootwebrestfulcrud.entities.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

//指定这是一个操作数据库的Mapper
@Mapper
public interface DepartMapper {

    @Select("select * from department")
    public List<Department> getDepLists();

    @Select("select * from department where id=#{id}")
    public Department getDepById(Integer id);

    @Select("select * from department where departmentName=#{departmentName}")
    public Department getDepByName(String departmentName);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(String departmentName);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
