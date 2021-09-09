package com.boot.rest.demo.dao;

import com.boot.rest.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
