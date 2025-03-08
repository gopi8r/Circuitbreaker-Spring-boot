package com.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.circuitbreaker.entity.Employee;
import com.circuitbreaker.service.Service;

@RestController
public class Controller {

	
	@Autowired
	private Service Service;
	
	@GetMapping("/api/employees")
	public Employee getEmployeeDetails() {
		
		Employee emp = new Employee();

		String employees = Service.callNameService();
		
		emp.setName(employees);
		return emp;
	}
	
}
