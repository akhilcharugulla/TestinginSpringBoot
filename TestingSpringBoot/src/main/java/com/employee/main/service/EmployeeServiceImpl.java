package com.employee.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.main.entity.Employee;
import com.employee.main.repository.EmployeeRepositoy;
import lombok.RequiredArgsConstructor;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositoy eRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return eRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return eRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(long id, Employee newemp) {
		Employee oldemp = eRepository.findById(id).get();
		oldemp.setFirstName(newemp.getFirstName());
		oldemp.setLastName(newemp.getLastName());
		oldemp.setAddress(newemp.getAddress());
		return oldemp;
	}

	@Override
	public void deleteEmployee(long empid) {
		eRepository.deleteById(empid);
	}
}
