package com.boot.rest.demo.controller;

import com.boot.rest.demo.dao.EmployeeDAO;
import com.boot.rest.demo.entity.Employee;
import com.boot.rest.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    // EXPOSE /employees TO RETURN ALL EMPLOYEES
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // READING A SINGLE EMPLOYEE
    @GetMapping("/employees/{id}")
    public Employee findOne(@PathVariable int id){

        Employee employee =  employeeService.findOne(id);

        if(employee==null){
            throw new RuntimeException("Employee id not found "+id);
        }
        return employee;
    }

    // ADD MAPPING FOR POST /employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);

        employeeService.save(employee);

        return employee;

    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }


    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
        Employee tmp = employeeService.findOne(id);

        // THROW EXCEPTION IF EMPLOYEE NOT PRESENT
        if(tmp==null){
            throw new RuntimeException("Employee not found for id - "+id);
        }

        employeeService.delete(id);
        return "Employee Deleted";
    }


}
