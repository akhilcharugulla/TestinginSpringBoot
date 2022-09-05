package com.employee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.employee.Repository")
@EntityScan("com.employee.Entity")
@ComponentScan({"com.employee.Controller","com.employee.Repository","com.employee.Service"})

@SpringBootApplication
public class TestingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingSpringBootApplication.class, args);
	}

}
