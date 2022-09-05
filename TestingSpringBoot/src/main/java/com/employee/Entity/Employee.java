package com.employee.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String address;
	
}
