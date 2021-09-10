package com.boot.rest.demo.service;

import com.boot.rest.demo.dao.EmployeeDAO;
import com.boot.rest.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl{

//    @Autowired
//    private EmployeeDAO employeeDAO;
//
//    @Override
//    @Transactional
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Employee findOne(int id) {
//        return employeeDAO.findOne(id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Employee employee) {
//        employeeDAO.save(employee);
//    }
//
//    @Override
//    @Transactional
//    public void delete(int id) {
//        employeeDAO.delete(id);
//    }
}
