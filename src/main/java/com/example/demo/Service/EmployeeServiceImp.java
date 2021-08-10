package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.EmployeeDao;
import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
@Autowired
private EmployeeDao sd;
	@Override
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		List<Employee> allEmpList =  sd.employeeList();
		List<Employee> finalList = new ArrayList<>();
		for(Employee e : allEmpList)
		{
			String[] arr = e.getSkills().split(",");
			if(arr.length>=3)
			{
				finalList.add(e);
			}
		}
		Collections.sort(finalList, (o1, o2) -> (o1.getLasttName().compareTo(o2.getLasttName())));
		return finalList;
		
	}
	@Override
	public List<String> finalResult() {
		// TODO Auto-generated method stub
		List<Employee> allEmpList =  sd.employeeList();
		List<String> finalList = new ArrayList<>();
		Map<Employee,Department> map = new HashMap();
		for(Employee e : allEmpList)
		{
			if(e.getSalary()>=5000 && ((e.getDepartments().get(0).getDepartmentName().equalsIgnoreCase("Devshop"))
					|| (e.getDepartments().get(0).getDepartmentName().equalsIgnoreCase("Engg"))))
					{
				    map.put(e, e.getDepartments().get(0));
					}
		}
		
		for (Map.Entry<Employee,Department> entry : map.entrySet())
		{
			String str = entry.getKey().getLasttName()+"-"+entry.getValue().getDeptId();
			finalList.add(str);
		}
		
		return finalList;
	}

}
