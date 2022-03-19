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
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.model.Course;
import com.course_management.model.Feedback;
import com.course_management.model.Instructor;
import com.course_management.service.AdminService;
import com.course_management.service.InstructorService;

@RestController
@RequestMapping("/Instructor")
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
			return new ResponseEntity<Instructor>(instructors, HttpStatus.OK);
		}
		throw new DuplicateInstructorException("Instructor Already Exists");
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

	

	

}
