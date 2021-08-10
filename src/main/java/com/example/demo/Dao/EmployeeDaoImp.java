package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee;
@Repository
public class EmployeeDaoImp implements EmployeeDao {
	@Autowired
	private EntityManager em;
	
	public List<Employee> employeeList()
	{
		Query query = em.createQuery("select c from Employee as c", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

}
