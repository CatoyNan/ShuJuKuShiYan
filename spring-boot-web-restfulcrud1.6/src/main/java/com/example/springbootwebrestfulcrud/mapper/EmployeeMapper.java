package com.example.springbootwebrestfulcrud.mapper;



import com.example.springbootwebrestfulcrud.entities.Employee;
import com.example.springbootwebrestfulcrud.entities.EmployeeShuJu;
import org.apache.ibatis.annotations.*;


import java.util.List;

//指定这是一个操作数据库的Mapper
@Mapper
public interface EmployeeMapper {



    @Delete("delete from employee where id=#{id}")
    public int deleteEmptById(Integer id);

    @Delete("delete from employee where department=#{id}")
    public int deleteEmptByDepartment(Integer id);

    @Insert("insert into employee(lastName,email,gender,department,birth) values(#{lastName},#{email},#{gender},#{department.id},#{birth})")
    public int insertEmp(Employee employee);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},department=#{department.id},birth=#{birth} where id=#{id}")
    public int updateEmp(Employee employee);
}
