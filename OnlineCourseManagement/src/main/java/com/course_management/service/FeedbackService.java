package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.model.Feedback;

@Service
public interface FeedbackService {
	//method for managing feedbacks given by the Instructor
		public List<Feedback> getAllFeedbacks();
		public List<Feedback> deleteFeedback(Integer feedbackId) throws NoSuchFeedbackException;
		public List<Feedback> saveFeedback(Feedback feedback);
		public List<Feedback> updateFeedback(Feedback feedback) throws NoSuchFeedbackException ;
		public Feedback findFeedback(Integer feedbackId) throws NoSuchFeedbackException;
}
