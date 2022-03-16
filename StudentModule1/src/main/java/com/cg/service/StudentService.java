package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student findById(Integer studentId);
	
	public Student deleteById(Integer studentId);
}
