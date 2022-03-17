package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Instructor;

@Service
public interface InstructorService {
	public List<Instructor> getallInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId);
	public List<Instructor> saveInstructor(Instructor instructor);
	public List<Instructor> updateInstructor(Instructor instructor);
	public Instructor findInstructor(Integer instructorId);

}
