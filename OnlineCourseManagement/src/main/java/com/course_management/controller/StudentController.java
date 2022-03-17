package com.course_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_management.entity.Instructor;
import com.course_management.entity.Student;
import com.course_management.service.InstructorService;
import com.course_management.service.StudentService;

@RestController
@RequestMapping("/Student-Details")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//URL :- http://localhost:8090/OnlineCourseManagement/All-Student
	
	@GetMapping("/All-Student")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentList = studentService.getallIStudents();

		if (studentList.isEmpty()) {
			return new ResponseEntity("Sorry no Instructor found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

	}
	@GetMapping("/Student/{studentId}")
	public ResponseEntity<Student> findStudentById(@PathVariable("studentId") Integer studentId) {

		Student student = studentService.findStudent(studentId);

		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@DeleteMapping("/Delete-Student/{studentId}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("studentId") Integer studentId) {
		List<Student> studentList = studentService.deleteStudent(studentId);

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

	}
	@PostMapping("/Save-Student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		
		Student students= studentService.saveStudent(student);
		if(students==null)
		{
			return new ResponseEntity("Sorry! Instructor not present!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Student>(students, HttpStatus.OK);
	
	}
	
	@PutMapping("/Update-Student")
	public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student){
		
		List<Student> studentList= studentService.updateStudent(student);
		if(studentList.isEmpty())
		{
			return new ResponseEntity("Sorry! Student not Present!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
}
