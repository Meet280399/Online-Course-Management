package com.course_management.controller;

import java.util.List;
import java.util.Optional;

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
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Course;
import com.course_management.model.Feedback;
import com.course_management.model.Instructor;
import com.course_management.model.Student;
import com.course_management.service.AdminService;
import com.course_management.service.CourseService;
import com.course_management.service.InstructorService;

@RestController
@CrossOrigin
@RequestMapping("rest/instructors")
public class InstructorController {

	// connecting the controller with the administrator service class
	@Autowired
	private AdminService adminService;

//	Instructor instructor = new Instructor();

	// connecting the controller with the instructor service class
	@Autowired
	private InstructorService instructorService;

	// requests the controller to get the list of instructors
	// http://localhost:8090/onlinecoursemanagement/rest/instructors
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Instructor>> getAllInstructors() {
		List<Instructor> instructorList = instructorService.getAllInstructors();
		if (instructorList.isEmpty()) {
			return new ResponseEntity("Sorry no Instructor found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Instructor>>(instructorList, HttpStatus.OK);
	}

	// request the controller to get the instructor with Id mentioned
	// http://localhost:8090/onlinecoursemanagement/instructor/findinstructor/57
	@GetMapping(path = "{instId}", produces = "application/json")
	public ResponseEntity<Instructor> findInstructorById(@PathVariable("instId") Integer instructorId)
			throws InstructorNotFoundException {
		List<Instructor> existingInstructor = instructorService.getAllInstructors();
		for (Instructor i : existingInstructor) {
			if (i.getInstructorId() == instructorId) {
				Instructor instructor = instructorService.findInstructor(instructorId);
				return new ResponseEntity<Instructor>(instructor, HttpStatus.OK);
			}
		}
		throw new InstructorNotFoundException("Instructor with " + instructorId + " mentioned not Present in database");
	}

	// request controller to delete the instructor with the Id mentioned
	// http://localhost:8090/onlinecoursemanagement/instructor/instructors/56
	// http://localhost:8090/onlinecoursemanagement/findinstructor/deleteinstructor/56
	@DeleteMapping(path = "{instId}", produces = "application/json")
	public ResponseEntity<List<Instructor>> deleteInstructor(@PathVariable("instId") Integer instructorId)
			throws InstructorNotFoundException {
		List<Instructor> existingInstructor = instructorService.getAllInstructors();
		for (Instructor i : existingInstructor) {
			if (i.getInstructorId() == instructorId) {
				List<Instructor> instructors = instructorService.deleteInstructor(instructorId);
				return new ResponseEntity<List<Instructor>>(instructors, HttpStatus.OK);
			}
		}
		throw new InstructorNotFoundException("Instructor not Present in database");
	}

	// request controller to save the instructor entered by user
	// http://localhost:8090/onlinecoursemanagement/instructor/createinstructor
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Instructor>> saveInstructor(@Valid @RequestBody Instructor instructor)
			throws DuplicateInstructorException {
		List<Instructor> existingInstructor = instructorService.getAllInstructors();
		for (Instructor i : existingInstructor) {
			if (i.getInstructorId() == instructor.getInstructorId()) {
				throw new DuplicateInstructorException("Instructor already exists in Database");
			}
		}
		List<Instructor> instructors = instructorService.saveInstructor(instructor);
		return new ResponseEntity<List<Instructor>>(instructors, HttpStatus.OK);
	}

	// request controller to update the instructor as mentioned by user
	// http://localhost:8090/onlinecoursemanagement/instructor/updateinstructor
	@PutMapping(path = "{instId}", produces = "application/json")
	public ResponseEntity<List<Instructor>> updateInstructor(@RequestBody Instructor instructor)
			throws InstructorNotFoundException {
		List<Instructor> existingInstructor = instructorService.getAllInstructors();
		for (Instructor i : existingInstructor) {
			if (i.getInstructorId() == instructor.getInstructorId()) {
				List<Instructor> instructors = instructorService.updateInstructor(instructor);
				return new ResponseEntity<List<Instructor>>(instructors, HttpStatus.OK);
			}
		}
		throw new InstructorNotFoundException("Instructor not Present in database");
	}

	// instructor Login
	@PostMapping("/login")
	public ResponseEntity loginInstructor(@RequestBody Instructor instructor) {
		try {
			instructorService.saveInstructor(instructor);
		} catch (DuplicateInstructorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity("Account Created!", HttpStatus.OK);
	}

	// instructor login checking
	@PostMapping("/checkInstructorLogin")
	public ResponseEntity checkLogin(@RequestBody Instructor instructor) throws InstructorNotFoundException {
		String checklogin = instructorService.checkInstructor(instructor);
		if (checklogin == null) {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		} else if (checklogin.equals(instructor.getEmail())) {
			return new ResponseEntity("Login Successful!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Login Failed!", HttpStatus.NOT_FOUND);
		}
	}

}
