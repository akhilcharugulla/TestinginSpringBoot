package com.employee.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployeeRepositoy;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepositoy eRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return eRepository.save(employee);
	}

}
