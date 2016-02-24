package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployee(int id);
	public void deleteEmployee(int id);
	public List<Employee> getEmployees();

}
