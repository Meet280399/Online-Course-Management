package com.course_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_management.entity.Instructor;
import com.course_management.service.InstructorService;

@RestController
@RequestMapping("/Instructor-Details")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	//URL :- http://localhost:8090/OnlineCourseManagement/All-Instructor

	@GetMapping("/All-Instructor")
	public ResponseEntity<List<Instructor>> getAllInstructors() {
		List<Instructor> instructorList = instructorService.getallInstructors();

		if (instructorList.isEmpty()) {
			return new ResponseEntity("Sorry no Instructor found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Instructor>>(instructorList, HttpStatus.OK);

	}

	
	@GetMapping("/Instructor/{instructorId}")
	public ResponseEntity<Instructor> findInstructorById(@PathVariable("instructorId") Integer instructorId) {

		Instructor instructor = instructorService.findInstructor(instructorId);

		return new ResponseEntity<Instructor>(instructor, HttpStatus.OK);

	}

	@DeleteMapping("/Delete-Instructor/{instructorId}")
	public ResponseEntity<List<Instructor>> deleteInstructor(@PathVariable("instructorId") Integer instructorId) {
		List<Instructor> instructorList = instructorService.deleteInstructor(instructorId);

		return new ResponseEntity<List<Instructor>>(instructorList, HttpStatus.OK);

	}

}
