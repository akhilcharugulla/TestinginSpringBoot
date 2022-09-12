package com.employee.main.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

//import javax.transaction.Transactional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import com.employee.main.entity.Employee;
import com.employee.main.repository.EmployeeRepositoy;

@DataJpaTest
//@TestMethodOrder(MethodOrderer.MethodName.class)
//The above annotation sorts all the methods in ascend order ascend
public class RepositorylayerTest {

	private static Employee actual_emp;
	private static Employee actual_emp1;
	private static Employee actual_emp2;
	
	@Autowired
	EmployeeRepositoy eRepository;

	@BeforeEach
	public void setup() {
		actual_emp = Employee.builder().firstName("akhil").lastName("charugulla").address("khm").build();
		actual_emp1 = Employee.builder().firstName("sgdsg").lastName("htrth").address("tshrth").build();
		actual_emp2 = Employee.builder().firstName("greh").lastName("hrh").address("zzhrrh").build();
	}

	@Test
	@Rollback(value = false)
	public void createemployee_test() {
		Employee expectedemployee = eRepository.save(actual_emp);
		assertNotNull(expectedemployee);
		assertEquals(expectedemployee, actual_emp);
	}

	//@DisplayName("Assam Test")
	@Test
	@Rollback(value = false)
	public void getAllEmployess_test() {
		//eRepository.save(actual_emp);
		eRepository.save(actual_emp1);
		eRepository.save(actual_emp2);
		List<Employee> allEmployess = eRepository.findAll();
		assertNotNull(allEmployess);
		assertEquals(3, allEmployess.size());
	}

	@Test
	public void find_EmployeeById_test() {
		Employee expectedemployee = eRepository.save(actual_emp);
		Employee returnedemployeeDb = eRepository.findById(expectedemployee.getId()).get();
		assertNotNull(returnedemployeeDb);
		assertEquals(returnedemployeeDb, expectedemployee);
	}
	
	
}
