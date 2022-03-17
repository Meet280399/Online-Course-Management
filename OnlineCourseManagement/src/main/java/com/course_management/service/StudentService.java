package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Student;

@Service
public interface StudentService {
	public List<Student> getallIStudents();
	public List<Student> deleteStudent(Integer studentId);
	public List<Student> saveStudent(Student student);
	public List<Student> updateStudent(Student student);
	public Student findStudent(Integer studentId);
}
