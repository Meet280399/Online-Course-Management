package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.course_management.dao.InstructorRepository;
import com.course_management.dao.SubjectRepository;
import com.course_management.entity.Instructor;
import com.course_management.entity.Student;
import com.course_management.entity.Subject;

public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private SubjectRepository subjectRepo;

	

	@Override
	public List<Student> getallStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> saveStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> getallInstructors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> deleteInstructor(Integer instructorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> saveInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructor findInstructor(Integer instructorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> setsalaryToInstructor(double instructorSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> getallSalaryOfInstructor(double instructorSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> deleteSalaryOfInstructor(double instructorSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> updatesalaryofInstructor(double instructorSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> savesalaryofInstructor(double instructorSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double instructorPracticalHours() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Subject> getallSubjects() {
		
		return subjectRepo.findAll();
	}

	@Override
	public Subject saveSubject(Subject subject) {
     subjectRepo.saveAndFlush(subject);
		
		return subjectRepo.save(subject);
	}

	@Override
	public List<Subject> updateSubject(Subject subject) {
      subjectRepo.saveAndFlush(subject);
		
		return subjectRepo.findAll();
	}

	@Override
	public List<Subject> deleteSubject(Integer SubjectId) {
		subjectRepo.deleteById(SubjectId);

		return subjectRepo.findAll();
		
	}

	@Override
	public Subject findSubject(Integer SubjectId) {
		Optional<Subject> subjectCollect = subjectRepo.findById(SubjectId);
		 
		return subjectCollect.get();
	} 

}
