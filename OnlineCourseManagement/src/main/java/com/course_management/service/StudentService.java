package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Student;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.StudentNotFoundException;

@Service
public interface StudentService {
	public List<Student> getallIStudents();
	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException;
	public Student saveStudent(Student student) throws DuplicateStudentException;
	public List<Student> updateStudent(Student student) throws StudentNotFoundException;
	public Student findStudent(Integer studentId) throws StudentNotFoundException;
}
