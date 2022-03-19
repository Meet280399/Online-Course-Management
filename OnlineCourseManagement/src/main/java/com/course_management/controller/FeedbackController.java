package com.course_management.controller;

import java.util.List;

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
import com.course_management.service.FeedbackService;
import com.course_management.service.InstructorService;

@RestController
@RequestMapping("/Feedback")
public class FeedbackController {

	// connecting the controller with the feedback service class
	@Autowired
	private FeedbackService feedbackService;

	// requests the controller to get the list of Feedbacks
	// http://localhost:8090/OnlineCourseManagement/Feedback/FeedBack-List
	@GetMapping("/FeedBack-List")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
		if (feedbackList.isEmpty()) {
			return new ResponseEntity("Sorry no feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to delete the feedback with the Id mentioned by Instructor
	@DeleteMapping("/Delete-Feedback/{feedbackId}")
	public ResponseEntity<List<Feedback>> deleteFeedback(@PathVariable("feedbackId") Integer feedbackId)
			throws NoSuchFeedbackException {
		List<Feedback> feedbackList = feedbackService.deleteFeedback(feedbackId);
		if (feedbackList.isEmpty() || feedbackList == null) {
			return new ResponseEntity("Sorry no Feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to save the feedback by Instructor
	@PostMapping("/Save-Feedback")
	public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
		Feedback feedbacks = feedbackService.saveFeedback(feedback);
		if (feedbacks == null) {
			return new ResponseEntity("Sorry! Feedback not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Feedback>(feedbacks, HttpStatus.OK);
	}

	// request controller to update the feedback by Instructor
	@PutMapping("/Update-Feedback")
	public ResponseEntity<List<Feedback>> updateFeedback(@RequestBody Feedback feedback)
			throws NoSuchFeedbackException {
		List<Feedback> feedbackList = feedbackService.updateFeedback(feedback);
		if (feedbackList.isEmpty()) {
			return new ResponseEntity("Sorry! Feedback not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to find feedback with Id mentioned by Instructor
	@GetMapping("/Feedback/{feedbackId}")
	public ResponseEntity<Feedback> findFeedback(@PathVariable("feedbackId") Integer feedbackId)
			throws NoSuchFeedbackException {
		Feedback feedbacks = feedbackService.findFeedback(feedbackId);
		if (feedbacks == null) {
			return new ResponseEntity("Sorry no feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Feedback>(feedbacks, HttpStatus.OK);
	}
}
