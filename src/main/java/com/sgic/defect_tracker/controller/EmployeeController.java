package com.sgic.defect_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.defect_tracker.model.Employee;
import com.sgic.defect_tracker.model.Project;
import com.sgic.defect_tracker.repository.EmployeeRepositories;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001", "http://localhost:4200" })
@RestController
@RequestMapping("employeeinfo")
public class EmployeeController {
	@Autowired
	EmployeeRepositories employeeRepositories;
	
	
	@PostMapping(value = "/employee")
	public ResponseEntity<?> createNote(@RequestBody Employee employee){
		employeeRepositories.save(employee);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	@GetMapping("/employee")
	  public List<Employee> getProject() {
		return employeeRepositories.findAll();
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Long> deleteEmployee (@PathVariable Long id){
		employeeRepositories.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
	}
	@PutMapping("/updateemployee")
	public ResponseEntity<?> updateProject(@RequestBody Employee employee){
		employeeRepositories.save(employee);
		return new ResponseEntity<Object>(HttpStatus.OK);
	
	}
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		return new ResponseEntity<Employee>(employeeRepositories.findEmployeeById(id), HttpStatus.OK);
	}
}
