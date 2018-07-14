package com.example.springbootwebrestfulcrud.dao;




import com.example.springbootwebrestfulcrud.entities.Department;
import com.example.springbootwebrestfulcrud.entities.Employee;
import com.example.springbootwebrestfulcrud.entities.EmployeeShuJu;
import com.example.springbootwebrestfulcrud.mapper.DepartMapper;
import com.example.springbootwebrestfulcrud.mapper.EmployeeMapper;
import com.example.springbootwebrestfulcrud.mapper.EmployeeShuJuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.*;

@Repository
public class EmployeeDao {
    private static Map<Integer,Employee> employees = null;



    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartMapper departMapper;
    @Autowired
    EmployeeShuJuMapper employeeShuJuMapper;

    static {

        employees = new HashMap<Integer, Employee>();
//        employees.put(1001,new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA"), new Date()));
//        employees.put(1002,new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB"), new Date()));
//        employees.put(1003,new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC"), new Date()));
//        employees.put(1004,new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD"), new Date()));
//        employees.put(1005,new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE"), new Date()));
    }
    private static Integer initId= 1006;

    public void save(Employee employee,Integer deparmentId){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

          employee.setDepartment(departMapper.getDepById(deparmentId));
          employeeMapper.insertEmp(employee);
    }
    //查询所有员工
    public Collection<Employee> getAll(){

        for(int i=0;i<employeeShuJuMapper.getEmpLists().size();i++){
            Integer id = employeeShuJuMapper.getEmpLists().get(i).getId();
            String lastName =  employeeShuJuMapper.getEmpLists().get(i).getLastName();
            String email =  employeeShuJuMapper.getEmpLists().get(i).getEmail();
            Integer gender =  employeeShuJuMapper.getEmpLists().get(i).getGender();
            Date birth =  employeeShuJuMapper.getEmpLists().get(i).getBirth();
            Department d = departMapper.getDepById(employeeShuJuMapper.getEmpLists().get(i).getDepartment());
            employees.put(id,new Employee(id,lastName,email,gender,d,birth));
            System.out.println("fasdfsdf");

        }


        return  employees.values();
    }

    //根据id得到员工
    public Employee getEmpById(Integer id) {
        Integer Eid = employeeShuJuMapper.getEmpById(id).getId();
        String lastName = employeeShuJuMapper.getEmpById(id).getLastName();
        String email =  employeeShuJuMapper.getEmpById(id).getEmail();
        Integer gender =  employeeShuJuMapper.getEmpById(id).getGender();
        Date birth =  employeeShuJuMapper.getEmpById(id).getBirth();
        Department d = departMapper.getDepById(employeeShuJuMapper.getEmpById(id).getDepartment());
        Employee employee = new Employee(Eid,lastName,email,gender,d,birth);
        return employee;
    }



    //根据id删除员工
    public void deleteEmpById(Integer id){
        employeeMapper.deleteEmptById(id);
        employees.remove(id);
    }

    //根据部门删除员工
    public void deleteEmpByDepartment(Integer id){
        employeeMapper.deleteEmptByDepartment(id);
        employees.clear();
    }

    //根据id修改员工
    public void upDateById(Employee employee){
        employeeMapper.updateEmp(employee);
        employees.remove(employee.getId());
        employees.put(employee.getId(),employee);

    }

    //根据部门名字得到员工
    public Collection<Employee> getEmpByDeptName(String deptName) {
        employees.clear();
        Department department = departmentDao.getDepartmentByName(deptName);
        department.toString();
        System.out.println("dsdfsdfsdf");
        Integer departmentId = department.getId();
        for(int i=0;i<employeeShuJuMapper.getEmpByDeptName(departmentId).size();i++){
            Integer Eid = employeeShuJuMapper.getEmpByDeptName(departmentId).get(i).getId();
            String lastName = employeeShuJuMapper.getEmpByDeptName(departmentId).get(i).getLastName();
            String email =  employeeShuJuMapper.getEmpByDeptName(departmentId).get(i).getEmail();
            Integer gender =  employeeShuJuMapper.getEmpByDeptName(departmentId).get(i).getGender();
            Date birth =  employeeShuJuMapper.getEmpByDeptName(departmentId).get(i).getBirth();
            Department d = departMapper.getDepById(employeeShuJuMapper.getEmpByDeptName(departmentId).get(i).getDepartment());
            employees.put(Eid,new Employee(Eid,lastName,email,gender,d,birth));
        }
        System.out.println(employees.size());
        return employees.values();
    }

    /*
        根据性别得到员工
     */
    public Collection<Employee> getEmpByGender(Integer gender) {
        employees.clear();
        for(int i=0;i<employeeShuJuMapper.getEmpByGender(gender).size();i++){
            Integer Eid = employeeShuJuMapper.getEmpByGender(gender).get(i).getId();
            String lastName = employeeShuJuMapper.getEmpByGender(gender).get(i).getLastName();
            String email =  employeeShuJuMapper.getEmpByGender(gender).get(i).getEmail();
            Integer Egender =  employeeShuJuMapper.getEmpByGender(gender).get(i).getGender();
            Date birth =  employeeShuJuMapper.getEmpByGender(gender).get(i).getBirth();
            Department d = departMapper.getDepById(employeeShuJuMapper.getEmpByGender(gender).get(i).getDepartment());
            employees.put(Eid,new Employee(Eid,lastName,email,Egender,d,birth));
        }
        return employees.values();
    }

    /*
        根据姓名得到员工
     */
    public Collection<Employee> getEmpByLastName(String lastName) {
        employees.clear();
        for(int i=0;i<employeeShuJuMapper.getEmpByLastName(lastName).size();i++){
            Integer Eid = employeeShuJuMapper.getEmpByLastName(lastName).get(i).getId();
            String ElastName = employeeShuJuMapper.getEmpByLastName(lastName).get(i).getLastName();
            String email =  employeeShuJuMapper.getEmpByLastName(lastName).get(i).getEmail();
            Integer Egender =  employeeShuJuMapper.getEmpByLastName(lastName).get(i).getGender();
            Date birth =  employeeShuJuMapper.getEmpByLastName(lastName).get(i).getBirth();
            Department d = departMapper.getDepById(employeeShuJuMapper.getEmpByLastName(lastName).get(i).getDepartment());
            employees.put(Eid,new Employee(Eid,lastName,email,Egender,d,birth));
        }
        return employees.values();
    }
}
