package com.tw.apistackbase;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employ")
public class Employess {
	private ArrayList<Employee> employee = new ArrayList<Employee>() {
		{
			add(new Employee(1, "xiaoming", 18, "male"));
			add(new Employee(2, "xiaohong", 18, "female"));
		}
	};

	@PostMapping
	public ResponseEntity<ArrayList<Employee>> addEmploy(@RequestBody Employee employ) {
		employee.add(employ);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ArrayList<Employee>> deletEmploy(@PathVariable String id) {

		for (Employee employees : employee) {
			if (employees.getId() == Integer.parseInt(id)) {
				employee.remove(employees);
				break;
			}
		}
		return ResponseEntity.noContent().build();

	}

	@PutMapping()
	public ResponseEntity<ArrayList<Employee>> putEmploy(@RequestBody Employee employ) {

		for (Employee employees : employee) {
			if (employees.getId() == employ.getId()) {
				employees.setName(employ.getName());
				employees.setAge(employ.getAge());
				employees.setGender(employ.getGender());

			}
		}
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@GetMapping()
	public ResponseEntity<ArrayList<Employee>> getEmploy() {

		return ResponseEntity.ok(employee);

	}

}
