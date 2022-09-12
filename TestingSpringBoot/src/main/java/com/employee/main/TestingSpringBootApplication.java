package com.employee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.employee.main.repository")
//@EntityScan("com.employee.main.entity")
//@ComponentScan({"com.employee.main"})

@SpringBootApplication
public class TestingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingSpringBootApplication.class, args);
	}

}
