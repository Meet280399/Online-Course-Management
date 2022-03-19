package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Student;

@Service
public interface StudentService {
	public List<Student> getallIStudents();
	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException;
	public Student saveStudent(Student student) throws DuplicateStudentException;
//	public int createStudent(Student student);
	public List<Student> updateStudent(Student student) throws StudentNotFoundException;
	public Student findStudent(Integer studentId) throws StudentNotFoundException;
}
