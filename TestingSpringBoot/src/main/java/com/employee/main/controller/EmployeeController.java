package com.employee.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.main.entity.Employee;
import com.employee.main.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService eService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return eService.addEmployee(employee);
	}

	@GetMapping("/allemployees")
	public List<Employee> getAllEmployees() {
		return eService.getAllEmployees();
	}

	@GetMapping("/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return eService.getEmployeeById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/updateemployee/{id}")
	public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		return eService.updateEmployee(id, employee);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deleteemployee/{id}")
	public void deleteemployee(@PathVariable long empid) {
		eService.deleteEmployee(empid);
	}
}
