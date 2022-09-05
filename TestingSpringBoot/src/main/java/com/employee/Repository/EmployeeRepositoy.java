package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.Entity.Employee;

@Repository
public interface EmployeeRepositoy extends JpaRepository<Employee, Long> {

}
