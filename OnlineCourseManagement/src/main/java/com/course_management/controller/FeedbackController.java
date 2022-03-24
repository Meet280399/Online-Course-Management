package com.course_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.model.Feedback;
import com.course_management.model.Instructor;
import com.course_management.service.FeedbackService;
import com.course_management.service.InstructorService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	// connecting the controller with the feedback service class
	@Autowired
	private FeedbackService feedbackService;

	// requests the controller to get the list of Feedbacks
	// http://localhost:8090/onlinecoursemanagement/feedback/feedbacklist
	@GetMapping("/feedbacklist")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
		if (feedbackList.isEmpty()) {
			return new ResponseEntity("Sorry no feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to delete the feedback with the Id mentioned by Instructor
	// http://localhost:8090/onlinecoursemanagement/feedback/deletefeedback/605
	@DeleteMapping("/deletefeedback/{feedbackId}")
	public ResponseEntity<List<Feedback>> deleteFeedback(@PathVariable("feedbackId") Integer feedbackId)
			throws NoSuchFeedbackException {
		List<Feedback> existingFeedback = feedbackService.getAllFeedbacks();
		for (Feedback f : existingFeedback) {
			if (f.getFeedbackId() == feedbackId) {
				List<Feedback> feedbackList = feedbackService.deleteFeedback(feedbackId);
				return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
			}
		}
		throw new NoSuchFeedbackException("Feedback not Present in Database");
		
	}

	// request controller to save the feedback by Instructor
	// http://localhost:8090/onlinecoursemanagement/feedback/createfeedback
	@PostMapping("/createfeedback")
	public ResponseEntity<List<Feedback>> saveFeedback(@Valid @RequestBody Feedback feedback) {
		List<Feedback> feedbacks = feedbackService.saveFeedback(feedback);
		if (feedbacks == null) {
			return new ResponseEntity("Sorry! Feedback not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
	}

	// request controller to update the feedback by Instructor
	// http://localhost:8090/onlinecoursemanagement/feedback/updatefeedback
	@PutMapping("/updatefeedback")
	public ResponseEntity<List<Feedback>> updateFeedback(@RequestBody Feedback feedback)
			throws NoSuchFeedbackException {
		List<Feedback> existingFeedback = feedbackService.getAllFeedbacks();
		for (Feedback f : existingFeedback) {
			if(f.getFeedbackId() == feedback.getFeedbackId()) {
				List<Feedback> feedbackList = feedbackService.updateFeedback(feedback);
				return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
			}
		}
		throw new NoSuchFeedbackException("Feedback not Present in Database");
		
	}

	// request controller to find feedback with Id mentioned by Instructor
	// http://localhost:8090/onlinecoursemanagement/feedback/findfeedback/601
	@GetMapping("/findfeedback/{feedbackId}")
	public ResponseEntity<Feedback> findFeedback(@PathVariable("feedbackId") Integer feedbackId)
			throws NoSuchFeedbackException {
		List<Feedback> existingFeedback = feedbackService.getAllFeedbacks();
		for (Feedback f : existingFeedback) {
			if (f.getFeedbackId() == feedbackId) {
				Feedback feedbacks = feedbackService.findFeedback(feedbackId);
				return new ResponseEntity<Feedback>(feedbacks, HttpStatus.OK);
			}
		}
		throw new NoSuchFeedbackException("Feedback not Present in Database");
		
	}
}
