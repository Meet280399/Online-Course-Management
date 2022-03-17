package com.course_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.course_management")
public class OnlineCourseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCourseManagementApplication.class, args);
	}

}
