package org.virtusa.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.learn.bean.Employee;
import org.virtusa.learn.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity(service.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeByEmployeeId(@PathVariable("employeeId") int employeeId) {
		Employee employee =  service.getEmployeeByEmployeeId(employeeId);
		if(employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		service.saveEmployee(employee);
		return new ResponseEntity<String>("Employee created successfully - "+employee.getEmployeeId(), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee = service.getEmployeeByEmployeeId(employee.getEmployeeId());
		if(updateEmployee != null) {
			updateEmployee.setEmployeeName(employee.getEmployeeName());
			updateEmployee.setSalary(employee.getSalary());
			updateEmployee.setDepartment(employee.getDepartment());
		}
		service.updateEmployee(updateEmployee);
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<Employee> deleteEmployeeByEmployeeId(@PathVariable int employeeId) {
		return new ResponseEntity<Employee>(service.deleteEmployee(employeeId), HttpStatus.OK);
	}

}
