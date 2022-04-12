package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Student;

@Service
public interface StudentService {
	public List<Student> getAllStudents();
	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException;
	public List<Student> saveStudent(Student student) throws DuplicateStudentException;
	public List<Student> updateStudent(Student student) throws StudentNotFoundException;
	public Student findStudent(Integer studentId) throws StudentNotFoundException;
	public String checkStudent(Student student) throws StudentNotFoundException;
}
