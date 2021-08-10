package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int  empId;
	@Column(name = "first_name")
	private String FirstName;
	@Column(name = "last_name" , nullable = false)
	private String LastName;
	@Column(name = "salary")
	private double salary;
	@Column(name = "dept_id")
	private int deptId;
	@Column(name = "skills")
	private String skills;
	@OneToMany
    @JoinColumn(name = "dept_id" , referencedColumnName="dept_id")
	private List<Department> departments;
	public int getId() {
		return empId;
	}
	public void setId(int id) {
		this.empId = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLasttName() {
		return LastName;
	}
	public void setLasttName(String lastName) {
		LastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Employee [id=" + empId + ", FirstName=" + FirstName + ", LasttName=" + LastName + ", salary=" + salary
				+ ", deptId=" + deptId + ", skills=" + skills + ", departments=" + departments + "]";
	}
	
	
	
	
	
	
	
	

}
