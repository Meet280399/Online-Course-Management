package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.model.Feedback;
import com.course_management.model.Instructor;
import com.course_management.model.Subject;

@Service
public interface InstructorService {
	
	// methods for managing the instructor
	public List<Instructor> getAllInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId) throws InstructorNotFoundException;
	public Instructor saveInstructor(Instructor instructor) throws DuplicateInstructorException;
	public List<Instructor> updateInstructor(Instructor instructor) throws InstructorNotFoundException;
	public Instructor findInstructor(Integer instructorId) throws InstructorNotFoundException;
	
}
