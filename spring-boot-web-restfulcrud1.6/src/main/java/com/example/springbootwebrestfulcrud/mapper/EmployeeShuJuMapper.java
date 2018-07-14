package com.example.springbootwebrestfulcrud.mapper;

import com.example.springbootwebrestfulcrud.entities.EmployeeShuJu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeShuJuMapper {
    @Select("select * from employee")
    public List<EmployeeShuJu> getEmpLists();

    @Select("select * from employee where id=#{id}")
    public EmployeeShuJu getEmpById(Integer id);

    @Select("select * from employee where department=#{department}")
    public List<EmployeeShuJu> getEmpByDeptName(Integer department);

    @Select("select * from employee where lastName=#{lastName}")
    public List<EmployeeShuJu> getEmpByLastName(String lastName);

    @Select("select * from employee where gender=#{gender}")
    public List<EmployeeShuJu> getEmpByGender(Integer gender);
}
