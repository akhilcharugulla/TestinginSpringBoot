package com.employee.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.main.entity.Employee;
public interface EmployeeService {

	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(long id, Employee employee);
	void deleteEmployee(long empid);

}
