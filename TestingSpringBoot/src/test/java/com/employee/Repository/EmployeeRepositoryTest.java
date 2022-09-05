package com.employee.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployeeRepositoy;

@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepositoy eRepository;


	@Test
	public void create_employee_test() {
		Employee actual_emp = Employee.builder().firstName("akhil").lastName("charugulla").address("khm").build();

		eRepository.save(actual_emp);
//		Employee expectedemployee= eRepository.save(actual_emp);
//		//Mockito.when(eRepository.save(Mockito.any())).thenReturn(expectedemployee);
		assertNotNull(actual_emp);
//		assertEquals(expectedemployee, actual_emp);
	}
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
}
