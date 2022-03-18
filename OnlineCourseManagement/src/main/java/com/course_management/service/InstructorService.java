package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Feedback;
import com.course_management.entity.Instructor;
import com.course_management.entity.Subject;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchFeedbackException;

@Service
public interface InstructorService {
	
	// methods for managing the instructor
	public List<Instructor> getAllInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId) throws InstructorNotFoundException;
	public Instructor saveInstructor(Instructor instructor) throws DuplicateInstructorException;
	public List<Instructor> updateInstructor(Instructor instructor) throws InstructorNotFoundException;
	public Instructor findInstructor(Integer instructorId) throws InstructorNotFoundException;
	
	

	
	//method for managing feedbacks given by the Instructor
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> deleteFeedback(Integer feedbackId) throws NoSuchFeedbackException;
	public Feedback saveFeedback(Feedback feedback);
	public List<Feedback> updateFeedback(Feedback feedback) throws NoSuchFeedbackException ;
	public Feedback findFeedback(Integer feedbackId) throws NoSuchFeedbackException;
}
