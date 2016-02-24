package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.EmployeeDAO;
import com.sprhib.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);		
	}

	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	public Employee getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}

	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}

	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

}
