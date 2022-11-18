package org.virtusa.learn.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.learn.bean.Employee;
import org.virtusa.learn.dao.EmployeeDAOImpl;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAOImpl dao;
	
	public Collection<Employee> getEmployees(){
		return dao.getEmployees();
	}
	
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return dao.getEmployeeByEmployeeId(employeeId);
	}
	
	
	public Integer saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}
	
	public Employee deleteEmployee(int employeeId) {
		return dao.deleteEmployee(employeeId);
	}

}
