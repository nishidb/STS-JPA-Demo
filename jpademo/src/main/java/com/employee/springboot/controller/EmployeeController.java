package com.employee.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.springboot.model.Employee;
import com.employee.springboot.repository.EmployeeRepository;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	// Create New Employee
	
	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		return "Employee Created in Database";
	}
	
	// Retrieve All Employees
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	// Retrieve Employee By Id
	
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
		
		Optional<Employee> emp =employeeRepository.findById(empid);
		
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable long empid,@RequestBody Employee employee) {
		Optional<Employee> emp =employeeRepository.findById(empid);
		
		if(emp.isPresent()) {
			Employee existEmp = emp.get();
			
			existEmp.setEmp_name(employee.getEmp_name());

			existEmp.setEmp_city(employee.getEmp_city());
			
			employeeRepository.save(existEmp);
			
			return "Employee Details with ID: " + empid + " updated!";
		}
		else {
			return "Employee Details Does Not Exist for Emp Id" + empid;
		}
	}
	

}
