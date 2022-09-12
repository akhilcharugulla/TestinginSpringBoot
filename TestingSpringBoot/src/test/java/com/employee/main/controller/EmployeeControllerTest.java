package com.employee.main.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.employee.main.entity.Employee;
import com.employee.main.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EmployeeControllerTest {
	private Employee e1;
	private Employee e2;


	@MockBean
	EmployeeServiceImpl eService;
	
	@Autowired
	MockMvc mockmvc;
	
	//this will convert java to json
	@Autowired
	ObjectMapper omapper;
	
	@BeforeEach
	public void setup() {
	 e1 = Employee.builder().firstName("akh").lastName("cha").address("kgm").build();
	 e2 = Employee.builder().firstName("tret").lastName("ert").address("re").build();

	}
	
	@Test
	public void testforsaveemployee() throws Exception{
		when(eService.addEmployee(any(Employee.class))).thenReturn(e1);
		
		 mockmvc.perform(post("/employees/addemployee").contentType(MediaType.APPLICATION_JSON).content(omapper.writeValueAsString(e1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.firstName",is(e1.getFirstName())))
		.andExpect(jsonPath("$.lastName",is(e1.getLastName())))
		.andExpect(jsonPath("$.address",is(e1.getAddress())));
	}
	
	@Test
	public void testforgetallemployees() throws Exception{
		List<Employee> allemp = new ArrayList<>();
		allemp.add(e1);
		allemp.add(e2);
		when(eService.getAllEmployees()).thenReturn(allemp);
		mockmvc.perform(get("/employees/allemployees").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(allemp.size())));
	}
	
	@Test
	public void testforgetemployeebyid() throws Exception{
		when(eService.getEmployeeById(any(Long.class))).thenReturn(e1);
		mockmvc.perform(get("/employees/getemployee/{id}",10L).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.firstName",is(e1.getFirstName())))
		.andExpect(jsonPath("$.lastName",is(e1.getLastName())))
		.andExpect(jsonPath("$.address",is(e1.getAddress())));
	}
	
	@Test
	public void updateemployeebyid() throws Exception{
		when(eService.updateEmployee(anyLong(), any(Employee.class))).thenReturn(e1);
		mockmvc.perform(put("/employees/updateemployee/{id}",78L).contentType(MediaType.APPLICATION_JSON).content(omapper.writeValueAsString(e2)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.firstName",is(e1.getFirstName())))
		.andExpect(jsonPath("$.lastName",is(e1.getLastName())))
		.andExpect(jsonPath("$.address",is(e1.getAddress())));
	}
	
	@Test
	public void deleteemployeebyid() throws Exception{
		doNothing().when(eService).deleteEmployee(anyLong());
		mockmvc.perform(delete("/employees/deleteemployee/{id}", 56L).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is5xxServerError());
	}

}
