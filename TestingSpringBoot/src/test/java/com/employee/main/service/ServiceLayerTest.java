package com.employee.main.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.main.entity.Employee;
import com.employee.main.repository.EmployeeRepositoy;

@ExtendWith(MockitoExtension.class)
public class ServiceLayerTest {

	//Inject Mocks creates a mock object of a class 
	//and injects the mocks that are marked with annotations @Mock into it

	@Mock
	private EmployeeRepositoy mockEmplRepo;
	
	@InjectMocks
	private EmployeeServiceImpl eService;
	
	@Test
	public void servicesaveemployeetest() {
		Employee assam = Employee.builder().firstName("akhil").lastName("charugulla").address("khm").build();
		when(mockEmplRepo.save(any(Employee.class))).thenReturn(assam);
		Employee emp = eService.addEmployee(assam);
		assertNotNull(emp);
		assertThat(assam.getFirstName()).isEqualTo("akhil");
	}
	
}
