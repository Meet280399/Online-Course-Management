package com.course_management.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_management.dao.StudentRepository;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Instructor;
import com.course_management.model.Student;
import com.course_management.service.InstructorService;
import com.course_management.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("rest/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// http://localhost:8090/onlinecoursemanagement/rest/students
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

	}
	
	
	// http://localhost:8090/onlinecoursemanagement/rest/students/301
	@GetMapping(path = "{studId}", produces = "application/json")
	public ResponseEntity<Student> findStudentById(@PathVariable("studId") Integer studentId)
			throws StudentNotFoundException {
		List<Student> existingStudent = studentService.getAllStudents();
		for (Student s : existingStudent) {
			if (s.getStudentId() == studentId) {
				Student student = studentService.findStudent(studentId);
				return new ResponseEntity<Student>(student, HttpStatus.OK);
			}
		}
		throw new StudentNotFoundException("Student with "+ studentId + " mentioned not Present in database");
	}
	
	
	// http://localhost:8090/onlinecoursemanagement/rest/employees/302
	@DeleteMapping(path = "{studId}", produces = "application/json")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("studId") Integer studentId)
			throws StudentNotFoundException {
		List<Student> existingStudent = studentService.getAllStudents();
		for (Student s : existingStudent) {
			if (s.getStudentId() == studentId) {
				List<Student> studentList = studentService.deleteStudent(studentId);
				return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
			}
		}
		throw new StudentNotFoundException("Student with the Id mentioned not Present in database");

	}
	
	
	// http://localhost:8090/onlinecoursemanagement/rest/employees
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Student>> saveStudent(@Valid @RequestBody Student student) throws DuplicateStudentException {
		List<Student> existingStudent = studentService.getAllStudents();
		for (Student s : existingStudent) {
			if (s.getStudentId() == student.getStudentId()) {
				throw new DuplicateStudentException("Student Already exists in Database");
			}
		}
		List<Student> students = studentService.saveStudent(student);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	// http://localhost:8090/onlinecoursemanagement/rest/students
	@PutMapping(path = "{studId}", produces = "application/json")
	public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student) throws StudentNotFoundException {
		List<Student> existingStudent = studentService.getAllStudents();
		for (Student s : existingStudent) {
			if (s.getStudentId() == student.getStudentId()) {
				List<Student> studentList = studentService.updateStudent(student);
				return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
			}
		}
		throw new StudentNotFoundException("Student not Present in database");
	}
	
	// student Login
	@PostMapping("/login")
	public ResponseEntity loginStudent(@RequestBody Student student) {
		try {
			studentService.saveStudent(student);
		} catch (DuplicateStudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity("Account Created!", HttpStatus.OK);
	}
	
	// student login checking
//	@PostMapping(path = "{checkLogin}", consumes = "application/json", produces = "application/json")
	@PostMapping("/checkStudentLogin")
	public ResponseEntity checkLogin(@RequestBody Student student) throws StudentNotFoundException {
		String checklogin = studentService.checkStudent(student);
		if (checklogin == null) {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		} else if (checklogin.equals(student.getStudentEmail())) {
			return new ResponseEntity("Login Successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		}
	}
}
