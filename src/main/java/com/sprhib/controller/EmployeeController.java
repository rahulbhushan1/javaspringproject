package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Employee;
import com.sprhib.model.Employee;
import com.sprhib.service.EmployeeService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addEmployeePage() {
		ModelAndView modelAndView = new ModelAndView("add-employee-form");
		modelAndView.addObject("employee", new Employee());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingEmployee(@ModelAttribute Employee employee) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		employeeService.addEmployee(employee);
		
		String message = "Employee was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfEmployees() {
		ModelAndView modelAndView = new ModelAndView("list-of-employee");
		
		List<Employee> employees = employeeService.getEmployees();
		modelAndView.addObject("employees", employees);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editEmployeePage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-employee-form");
		Employee employee = employeeService.getEmployee(id);
		modelAndView.addObject("employee",employee);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingEmployee(@ModelAttribute Employee employee, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		employeeService.updateEmployee(employee);
		
		String message = "Employee was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		employeeService.deleteEmployee(id);
		String message = "Employee was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
