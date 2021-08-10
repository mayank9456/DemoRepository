package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping(value =  "/api")
public class EmployeeController {
	@Autowired
	private EmployeeService ss;
	
	@GetMapping("/employee_list")
	public List<Employee> employeeList()
	{
		return ss.employeeList();
	}
	
	@GetMapping("/employee_final_list")
	public List<String> employeeFinalList()
	{
		return ss.finalResult();
	}
	

}
