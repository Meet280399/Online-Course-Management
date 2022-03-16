package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Student;
import com.cg.service.StudentService;

@RestController
@RequestMapping("/course-management/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//get request for getting or showing details of all the students 
	@GetMapping("/batch/student-details")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		if(students.isEmpty()) {
			return new ResponseEntity("Sorry!! No Student Found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	//get method for getting details of each student using the student id
	@GetMapping("/student-details/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId) {
		Student students = studentService.findById(studentId);
		if(students == null) {
			return new ResponseEntity("Sorry!! No Student with that Id", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Student>(students, HttpStatus.OK);
	}
}
