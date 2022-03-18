package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Feedback;
import com.course_management.entity.Instructor;

@Service
public interface InstructorService {
	
	// methods for managing the instructor
	public List<Instructor> getAllInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId);
	public Instructor saveInstructor(Instructor instructor);
	public List<Instructor> updateInstructor(Instructor instructor);
	public Instructor findInstructor(Integer instructorId);

	
	//method for managing feedbacks given by the Instructor
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> deleteFeedback(Integer feedbackId);
	public Feedback saveFeedback(Feedback feedback);
	public List<Feedback> updateFeedback(Feedback feedback);
	public Feedback findFeedback(Integer feedbackId);
}
