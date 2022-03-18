package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Instructor;
import com.course_management.entity.Subject;

@Service
public interface InstructorService {
	public List<Instructor> getAllInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId);
	public Instructor saveInstructor(Instructor instructor);
	public List<Instructor> updateInstructor(Instructor instructor);
	public Instructor findInstructor(Integer instructorId);
	
	

}
