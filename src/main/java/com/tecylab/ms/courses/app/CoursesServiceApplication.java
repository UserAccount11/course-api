package com.tecylab.ms.courses.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CoursesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesServiceApplication.class, args);
	}

}
