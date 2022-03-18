package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.InstructorRepository;
import com.course_management.dao.StudentRepository;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Instructor;
import com.course_management.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getallIStudents() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException{
		studentRepo.deleteById(studentId);
		return studentRepo.findAll();

	}

	@Override
	public Student saveStudent(Student student) throws DuplicateStudentException {
		studentRepo.saveAndFlush(student);
		return studentRepo.save(student);
	}

	@Override
	public List<Student> updateStudent(Student student) throws StudentNotFoundException{
		studentRepo.saveAndFlush(student);
		return studentRepo.findAll();
	}

	@Override
	public Student findStudent(Integer studentId) throws StudentNotFoundException{
		Optional<Student> studentCollect = studentRepo.findById(studentId);
		return studentCollect.get();
	}

}
