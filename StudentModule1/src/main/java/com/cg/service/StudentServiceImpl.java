package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dao.StudentDao;
import com.cg.entity.Student;

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	//service method for getting details of all the students
	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	//service method for getting the student information using student id
	@Override
	public Student findById(Integer studentId) {
		Optional<Student> student = studentDao.findById(studentId); //predefined method for the jpa repository
		return student.get();
	}

}
