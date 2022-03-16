package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class OnlineCourseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCourseManagementApplication.class, args);
	}

}
