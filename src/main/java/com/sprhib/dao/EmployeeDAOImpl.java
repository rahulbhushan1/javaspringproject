package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEmployee(Employee employee) {
		getCurrentSession().save(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee employeeToUpdate = getEmployee(employee.getId());
		employeeToUpdate.setName(employee.getName());
		employeeToUpdate.setRating(employee.getRating());
		getCurrentSession().update(employeeToUpdate);
		
	}

	public Employee getEmployee(int id) {
		Employee employee = (Employee) getCurrentSession().get(Employee.class, id);
		return employee;
	}

	public void deleteEmployee(int id) {
		Employee employee = getEmployee(id);
		if (employee != null)
			getCurrentSession().delete(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return getCurrentSession().createQuery("from Employee").list();
	}

}
