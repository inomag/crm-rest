package com.boot.rest.demo.dao;

import com.boot.rest.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        // GET HIBERNATE SESSION
        Session session = entityManager.unwrap(Session.class);

        // CREATE QUERY
        Query<Employee> query = session.createQuery("FROM Employee",Employee.class);

        // GET RESULTS
        List<Employee> employees = query.getResultList();
        //RETURN LIST

        return employees;
    }
}
