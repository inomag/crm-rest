package com.boot.rest.demo.service;

import com.boot.rest.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findOne(int id);

    public void save(Employee employee);

    public void delete(int id);
}
