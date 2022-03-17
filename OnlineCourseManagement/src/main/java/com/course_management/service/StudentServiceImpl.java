package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.InstructorRepository;
import com.course_management.dao.StudentRepository;
import com.course_management.entity.Instructor;
import com.course_management.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getallIStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public List<Student> deleteStudent(Integer studentId) {
		
		studentRepo.deleteById(studentId);

		return studentRepo.findAll();
		
	
	}

	@Override
	public List<Student> saveStudent(Student student) {
		
        studentRepo.saveAndFlush(student);
		
		return studentRepo.findAll();
	}

	@Override
	public List<Student> updateStudent(Student student) {
		
        studentRepo.saveAndFlush(student);
		
		return studentRepo.findAll();
	}

	@Override
	public Student findStudent(Integer studentId) {
		Optional<Student> studentCollect = studentRepo.findById(studentId);
		 
		return studentCollect.get();
	}
	

}
