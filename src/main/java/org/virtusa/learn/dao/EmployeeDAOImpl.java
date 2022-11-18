package org.virtusa.learn.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.virtusa.learn.bean.Employee;

@Repository
public class EmployeeDAOImpl {
	static public Map<Integer,Employee> employees = new LinkedHashMap<Integer,Employee>();
	static int count = 1003;
	
	static {
		employees.put(1001, new Employee(1001,"RaviKumar",45000,"Technical Learning"));
		employees.put(1002, new Employee(1002,"Sulaxman",55000,"Technical Learning"));
		employees.put(1003, new Employee(1003,"Lovelyn",65000,"EIQ"));
	}
	
	public Collection<Employee> getEmployees(){
		return employees.values();
	}
	
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employees.get(employeeId);
	}
	
	public Integer saveEmployee(Employee employee) {
		count++;
		employee.setEmployeeId(count);
		employees.put(count, employee);
		return count;
	}
	
	public Employee updateEmployee(Employee employee) {
		employees.put(employee.getEmployeeId(), employee);
		return employee;
	}
	
	public Employee deleteEmployee(int employeeId) {
		Employee employee = employees.remove(employeeId);
		system.out.println("Emp"+employee );
		return employee;
	}


}
