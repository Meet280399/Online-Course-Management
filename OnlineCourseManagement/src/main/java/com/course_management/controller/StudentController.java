package com.course_management.controller;

import java.util.List;
import java.util.Optional;

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

import com.course_management.dao.StudentRepository;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Instructor;
import com.course_management.model.Student;
import com.course_management.service.InstructorService;
import com.course_management.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// URL :-
	// http://localhost:8090/OnlineCourseManagement/Student/Student-List

	@GetMapping("/Student-List")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

	}

	@GetMapping("/Student/{studentId}")
	public ResponseEntity<Student> findStudentById(@PathVariable("studentId") Integer studentId)
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

	@DeleteMapping("/Delete-Student/{studentId}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("studentId") Integer studentId)
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

	@PostMapping("/Save-Student")
	public ResponseEntity<List<Student>> saveStudent(@RequestBody Student student) throws DuplicateStudentException {
		List<Student> existingStudent = studentService.getAllStudents();
		for (Student s : existingStudent) {
			if (s.getStudentId() == student.getStudentId()) {
				throw new DuplicateStudentException("Student Already exists in Database");
			}
		}
		List<Student> students = studentService.saveStudent(student);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@PutMapping("/Update-Student")
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
}
