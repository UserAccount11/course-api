package com.tecylab.ms.courses.app;

import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseEntity;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.models.CourseStudent;
import com.tecylab.ms.courses.app.insfrastracture.adapters.output.persistence.repository.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;

@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
public class CoursesServiceApplication implements CommandLineRunner {

	private final CourseJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CoursesServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CourseStudent cs1 = new CourseStudent();
		cs1.setStudentId(1L);

		CourseStudent cs2 = new CourseStudent();
		cs2.setStudentId(2L);

		CourseStudent cs3 = new CourseStudent();
		cs3.setStudentId(3L);

		CourseEntity course1 = new CourseEntity();
		course1.setName("Spring");
		course1.addCourseStudent(cs1);
		course1.addCourseStudent(cs2);

		CourseEntity course2 = new CourseEntity();
		course2.setName("Node JS");
		course2.addCourseStudent(cs3);

		repository.saveAll(Arrays.asList(course1, course2));
	}
}
