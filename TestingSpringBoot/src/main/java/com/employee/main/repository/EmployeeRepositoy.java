package com.employee.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.main.entity.Employee;

@Repository
public interface EmployeeRepositoy extends JpaRepository<Employee, Long> {

}
