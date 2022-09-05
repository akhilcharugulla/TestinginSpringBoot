package com.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService eService;
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return eService.addEmployee(employee);
		
	}
}
