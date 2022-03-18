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

import com.course_management.entity.Course;
import com.course_management.entity.Feedback;
import com.course_management.entity.Instructor;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.service.AdminService;
import com.course_management.service.InstructorService;

@RestController
@RequestMapping("/Instructor-Details")
public class InstructorController {

	// connecting the controller with the administrator service class
	@Autowired
	private AdminService adminService;

	// connecting the controller with the instructor service class
	@Autowired
	private InstructorService instructorService;

	// requests the controller to get the list of instructors
	// http://localhost:8090/OnlineCourseManagement/Instructor-Details/Instructors-List
	@GetMapping("/Instructors-List")
	public ResponseEntity<List<Instructor>> getAllInstructors() {
		List<Instructor> instructorList = instructorService.getAllInstructors();
		if (instructorList.isEmpty()) {
			return new ResponseEntity("Sorry no Instructor found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Instructor>>(instructorList, HttpStatus.OK);
	}

	// request the controller to get the instructor with Id mentioned
	@GetMapping("/Instructor/{instructorId}")
	public ResponseEntity<Instructor> findInstructorById(@PathVariable("instructorId") Integer instructorId) throws InstructorNotFoundException {
		Instructor instructor = instructorService.findInstructor(instructorId);
		if (instructor == null) {
			return new ResponseEntity("Sorry no Instructor found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Instructor>(instructor, HttpStatus.OK);
	}

	// request controller to delete the instructor with the Id mentioned
	@DeleteMapping("/Delete-Instructor/{instructorId}")
	public ResponseEntity<List<Instructor>> deleteInstructor(@PathVariable("instructorId") Integer instructorId) throws InstructorNotFoundException {
		List<Instructor> instructorList = instructorService.deleteInstructor(instructorId);
		if (instructorList.isEmpty() || instructorList == null) {
			return new ResponseEntity("Sorry no Instructor found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Instructor>>(instructorList, HttpStatus.OK);
	}

	// request controller to save the instructor entered by user
	@PostMapping("/Save-Instructor")
	public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) throws DuplicateInstructorException {
		Instructor instructors = instructorService.saveInstructor(instructor);
		if (instructors == null) {
			return new ResponseEntity("Sorry! Instructor not present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Instructor>(instructors, HttpStatus.OK);
	}

	// request controller to update the instructor as mentioned by user
	@PutMapping("/Update-Instructor")
	public ResponseEntity<List<Instructor>> updateInstructor(@RequestBody Instructor instructor) throws InstructorNotFoundException {
		List<Instructor> instructorList = instructorService.updateInstructor(instructor);
		if (instructorList.isEmpty()) {
			return new ResponseEntity("Sorry! Instructor not Present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Instructor>>(instructorList, HttpStatus.OK);
	}

	// ------------- Controller for the requests related to the course------------------------

	// requests the controller to get the list of course
	@GetMapping("/Course-List")
	public ResponseEntity<List<Course>> getAllCourse() {
		List<Course> courseList = adminService.getAllCourse();
		if (courseList.isEmpty()) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	// request the controller to get the Course with Id mentioned
	@GetMapping("/Course/{courseId}")
	public ResponseEntity<Course> findCourseById(@PathVariable("courseId") Integer courseId) {
		Course course = adminService.findCourse(courseId);
		if (course == null) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	// request controller to delete the Course with the Id mentioned
	@DeleteMapping("/Delete-Course/{courseId}")
	public ResponseEntity<List<Course>> deleteCourse(@PathVariable("courseId") Integer courseId) {
		List<Course> courseList = adminService.deleteCourse(courseId);
		if (courseList.isEmpty() || courseList == null) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	// request controller to save the Course entered by user
	@PostMapping("/Save-Course")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		Course courses = adminService.saveCourse(course);
		if (courses == null) {
			return new ResponseEntity("Sorry! Course not present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(courses, HttpStatus.OK);
	}

	// request controller to update the Course as mentioned by user
	@PutMapping("/Update-Course")
	public ResponseEntity<List<Course>> updateCourse(@RequestBody Course course) {
		List<Course> courseList = adminService.updateCourse(course);
		if (courseList.isEmpty()) {
			return new ResponseEntity("Sorry! Course not Present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	// requests the controller to get the list of Feedbacks
	// http://localhost:8090/OnlineCourseManagement/Instructor-Details/FeedBack-List
	@GetMapping("/FeedBack-List")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		List<Feedback> feedbackList = instructorService.getAllFeedbacks();
		if (feedbackList.isEmpty()) {
			return new ResponseEntity("Sorry no feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to delete the feedback with the Id mentioned by Instructor
	@DeleteMapping("/Delete-Feedback/{feedbackId}")
	public ResponseEntity<List<Feedback>> deleteFeedback(@PathVariable("feedbackId") Integer feedbackId) throws NoSuchFeedbackException {
		List<Feedback> feedbackList = instructorService.deleteFeedback(feedbackId);
		if (feedbackList.isEmpty() || feedbackList == null) {
			return new ResponseEntity("Sorry no Feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to save the feedback by Instructor
	@PostMapping("/Save-Feedback")
	public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
		Feedback feedbacks = instructorService.saveFeedback(feedback);
		if (feedbacks == null) {
			return new ResponseEntity("Sorry! Feedback not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Feedback>(feedbacks, HttpStatus.OK);
	}

	// request controller to update the feedback by Instructor
	@PutMapping("/Update-Feedback")
	public ResponseEntity<List<Feedback>> updateFeedback(@RequestBody Feedback feedback) throws NoSuchFeedbackException {
		List<Feedback> feedbackList = instructorService.updateFeedback(feedback);
		if (feedbackList.isEmpty()) {
			return new ResponseEntity("Sorry! Feedback not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}

	// request controller to find feedback with Id mentioned by Instructor
	@GetMapping("/Feedback/{feedbackId}")
	public ResponseEntity<Feedback> findFeedback(@PathVariable("feedbackId") Integer feedbackId) throws NoSuchFeedbackException {
		Feedback feedbacks = instructorService.findFeedback(feedbackId);
		if (feedbacks == null) {
			return new ResponseEntity("Sorry no feedback found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Feedback>(feedbacks, HttpStatus.OK);
	}

}
