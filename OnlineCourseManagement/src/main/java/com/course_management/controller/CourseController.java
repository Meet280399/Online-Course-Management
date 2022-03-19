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

import com.course_management.exception.DuplicateCourseException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.model.Course;
import com.course_management.service.AdminService;
import com.course_management.service.CourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	// ------------- Controller for the requests related to the
	// course------------------------

	// requests the controller to get the list of course
	// URL:-
	// http://localhost:8090/OnlineCourseManagement/Course/Course-List
	@GetMapping("/Course-List")
	public ResponseEntity<List<Course>> getAllCourse() {
		List<Course> courseList = courseService.getAllCourse();
		if (courseList.isEmpty()) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	// request the controller to get the Course with Id mentioned
	@GetMapping("/Course/{courseId}")
	public ResponseEntity<Course> findCourseById(@PathVariable("courseId") Integer courseId)
			throws NoSuchCourseException {
		Course course = courseService.findCourse(courseId);
		if (course == null) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	// request controller to delete the Course with the Id mentioned
	@DeleteMapping("/Delete-Course/{courseId}")
	public ResponseEntity<List<Course>> deleteCourse(@PathVariable("courseId") Integer courseId)
			throws NoSuchCourseException {
		List<Course> courseList = courseService.deleteCourse(courseId);
		if (courseList.isEmpty() || courseList == null) {
			return new ResponseEntity("Sorry no Course found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	// request controller to save the Course entered by user
	@PostMapping("/Save-Course")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) throws DuplicateCourseException {
		Course courses = courseService.saveCourse(course);
		if (courses == null) {
			return new ResponseEntity("Sorry! Course not present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(courses, HttpStatus.OK);
	}

	// request controller to update the Course as mentioned by user
	@PutMapping("/Update-Course")
	public ResponseEntity<List<Course>> updateCourse(@RequestBody Course course) throws NoSuchCourseException {
		List<Course> courseList = courseService.updateCourse(course);
		if (courseList.isEmpty()) {
			return new ResponseEntity("Sorry! Course not Present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}
}
