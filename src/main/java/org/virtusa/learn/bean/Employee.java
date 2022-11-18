package org.virtusa.learn.bean;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private double salary;
	private String department;
	
	Employee(){
		
	}

	public Employee(int employeeId, String employeeName, double salary, String department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
