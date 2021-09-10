package com.boot.rest.demo.service;

import com.boot.rest.demo.dao.EmployeeDAO;
import com.boot.rest.demo.dao.EmployeeRepository;
import com.boot.rest.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee emp = null;
        if(result.isPresent())emp = result.get();
        else throw new RuntimeException("Employee not found");

        return emp;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
