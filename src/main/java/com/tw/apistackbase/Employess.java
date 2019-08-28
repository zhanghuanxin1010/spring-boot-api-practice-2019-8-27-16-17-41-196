package com.tw.apistackbase;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employ")
public class Employess {
private ArrayList<Employee>employee=new ArrayList<Employee>()
{{
	
}};
@PostMapping
public  ResponseEntity<ArrayList<Employee>> addEmploy(@RequestBody Employee employ )
   {
	employee.add(employ);
	 return ResponseEntity.status(HttpStatus.CREATED).build();
	
	
	}

	
}
