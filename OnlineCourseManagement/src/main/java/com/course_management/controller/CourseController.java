package com.course_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_management.exception.DuplicateCourseException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.model.Course;
import com.course_management.service.AdminService;
import com.course_management.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("rest/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	// ------------- Controller for the requests related to the
	// course------------------------

	// requests the controller to get the list of course
	// http://localhost:8090/onlinecoursemanagement/rest/courses
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Course>> getAllCourse() {
		List<Course> courseList = courseService.getAllCourse();
		if (courseList.isEmpty()) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	// request the controller to get the Course with Id mentioned
	// http://localhost:8090/onlinecoursemanagement/rest/courses
	@GetMapping(path = "{courId}", produces = "application/json")
	public ResponseEntity<Course> findCourseById(@PathVariable("courId") Integer courseId)
			throws NoSuchCourseException {
		List<Course> existingCouse = courseService.getAllCourse();
		for (Course c : existingCouse) {
			if (c.getCourseId() == courseId) {
				Course course = courseService.findCourse(courseId);
				return new ResponseEntity<Course>(course, HttpStatus.OK);
			}
		}
		throw new NoSuchCourseException("Course with "+ courseId + " mentioned not Present in database");
	}

	// request controller to delete the Course with the Id mentioned
	// http://localhost:8090/onlinecoursemanagement/rest/courses/120
	@DeleteMapping(path = "{courId}", produces = "application/json")
	public ResponseEntity<List<Course>> deleteCourse(@PathVariable("courId") Integer courseId)
			throws NoSuchCourseException {
		List<Course> existingCouse = courseService.getAllCourse();
		for (Course c : existingCouse) {
			if (c.getCourseId() == courseId) {
				List<Course> courses = courseService.deleteCourse(courseId);
				return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
			}
		}
		throw new NoSuchCourseException("Course not Present in database");
		
	}

	// request controller to save the Course entered by user
	// http://localhost:8090/onlinecoursemanagement/rest/courses
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Course>> saveCourse(@Valid @RequestBody Course course) 
			throws DuplicateCourseException {
		List<Course> existingCouse = courseService.getAllCourse();
		for (Course c : existingCouse) {
			if (c.getCourseId() == course.getCourseId()) {
				throw new DuplicateCourseException("Course already exists in Database");
			}
		}
		List<Course> courses = courseService.saveCourse(course);
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}

	// request controller to update the Course as mentioned by user
	// http://localhost:8090/onlinecoursemanagement/rest/courses
	@PutMapping(path = "{courId}", produces = "application/json")
	public ResponseEntity<List<Course>> updateCourse(@RequestBody Course course) 
			throws NoSuchCourseException {
		List<Course> existingCouse = courseService.getAllCourse();
		for (Course c : existingCouse) {
			if (c.getCourseId() == course.getCourseId()) {
				List<Course> courseList = courseService.updateCourse(course);
				return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
			}
		}
		throw new NoSuchCourseException("Course not Present in database");
	}
}
