package com.circuitbreakername.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.circuitbreaker.entity.EmployeeNames;

@RestController
public class NameController {


	    @GetMapping("/api/name")
	    public List<EmployeeNames> getUsers(){
	    
		return Arrays.asList(
	            new EmployeeNames("Arun","Raj"),
	            new EmployeeNames("Ram", "Kumar")
	        );
	}
	
}
