package com.boot.rest.demo.dao;

import com.boot.rest.demo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    // USING NATIVE HIBERNATE API//////////////////////////////////////////////////////
//    @Override
//    public List<Employee> findAll() {
//        // GET HIBERNATE SESSION
//        Session session = entityManager.unwrap(Session.class);
//
//        // CREATE QUERY
//        Query<Employee> query = session.createQuery("FROM Employee",Employee.class);
//
//        // GET RESULTS
//        List<Employee> employees = query.getResultList();
//        //RETURN LIST
//
//        return employees;
//    }
//
//    @Override
//    public Employee findOne(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = (Employee)session.get(Employee.class,id);
//        return employee;
//    }
//
//    @Override
//    public void save(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
//    }
//
//    @Override
//    public void delete(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("DELETE FROM Employee WHERE id=:id");
//        query.setParameter("id",id);
//        query.executeUpdate();
//    }

    /////////////// USING JPA/////////////////////////

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
        List<Employee> list = query.getResultList();
        return list;
    }

    @Override
    public Employee findOne(int id) {
        Employee emp = entityManager.find(Employee.class,id);
        return emp;
    }

    @Override
    public void save(Employee employee) {
        Employee emp =entityManager.merge(employee);
        employee.setId(emp.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
