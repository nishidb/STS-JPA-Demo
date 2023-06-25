package com.employee.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_table")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long empid;
	
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="emp_city")
	private String emp_city;
	
	
	public Employee() {
		
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_city() {
		return emp_city;
	}

	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", emp_name=" + emp_name + ", emp_city=" + emp_city + "]";
	}

	public Employee(Long empid, String emp_name, String emp_city) {
		super();
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_city = emp_city;
	}
	
	

}
