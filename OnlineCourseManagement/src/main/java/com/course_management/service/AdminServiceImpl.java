package com.course_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.entity.Instructor;
import com.course_management.entity.Student;

@Service
public class AdminServiceImpl implements AdminService {
	

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

}
