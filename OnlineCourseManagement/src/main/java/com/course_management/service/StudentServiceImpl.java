package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.InstructorRepository;
import com.course_management.dao.StudentRepository;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.InstructorNotFoundException;
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
	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException {
		try {
			studentRepo.deleteById(studentId);
			return studentRepo.findAll();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new StudentNotFoundException("Student is not Present in Database");
		}

	}

	@Override
	public Student saveStudent(Student student) throws DuplicateStudentException {
		try {
			Student students = studentRepo.saveAndFlush(student);
			return students;
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new DuplicateStudentException("Student already Exists in Database");
		}
	}

	@Override
	public List<Student> updateStudent(Student student) throws StudentNotFoundException {
		try {
			studentRepo.saveAndFlush(student);
			return studentRepo.findAll();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new StudentNotFoundException("Student is not Present in Database");
		}
	}

	@Override
	public Student findStudent(Integer studentId) throws StudentNotFoundException {
		try {
			Optional<Student> studentCollect = studentRepo.findById(studentId);
			return studentCollect.get();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new StudentNotFoundException("Student is not Present in Database");
		}
	}

//	@Override
//	public int createStudent(Student student) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
