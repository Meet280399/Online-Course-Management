package com.course_management;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.course_management.dao.CourseRepository;
import com.course_management.dao.SubjectRepository;
import com.course_management.model.Course;
import com.course_management.model.Subject;

@SpringBootApplication
@ComponentScan("com.course_management")
public class OnlineCourseManagementApplication {

//	@Autowired
//	private CourseRepository courseRepo;
//
//	@Autowired
//	private SubjectRepository subjectRepo;

	public static void main(String[] args) {

		SpringApplication.run(OnlineCourseManagementApplication.class, args);

	}

//	@Bean
//	public CommandLineRunner mappingDemo(SubjectRepository subjectRepo, CourseRepository courseRepo) {
//		return args -> {
//
//			// create a student
//			Course course = new Course(120, "python", "40 hrs");
//
//			// save the student
//			courseRepo.save(course);
//
//			// create three courses
//			Subject subject1 = new Subject(1011, "Machine Learning");
//			Subject subject2 = new Subject(1012, "Database Systems");
//			Subject subject3 = new Subject(1013, "Web Basics");
//
//			// save courses
//			subjectRepo.saveAll(Arrays.asList(subject1, subject2, subject3));
//
//			// add courses to the student
//			course.getSubjects().addAll(Arrays.asList(subject1, subject2, subject3));
//
//			// update the student
//			courseRepo.save(course);
//		};
//	}

}
