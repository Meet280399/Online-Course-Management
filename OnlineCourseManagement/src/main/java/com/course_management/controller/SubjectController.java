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

import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.DuplicateSubjectException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.exception.SubjectNotFoundException;
import com.course_management.model.Instructor;
import com.course_management.model.Student;
import com.course_management.model.Subject;
import com.course_management.service.StudentService;
import com.course_management.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	// URL :-
	// http://localhost:8090/onlinecoursemanagement/subject/subjectlist

	@GetMapping("/subjectlist")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjectList = subjectService.getallSubjects();

		if (subjectList.isEmpty()) {
			return new ResponseEntity("Sorry no Subject found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);

	}
	
	// http://localhost:8090/onlinecoursemanagement/subject/{subjectId}
	
	@GetMapping("/subject/{subjectId}")
	public ResponseEntity<Subject> findSubjectById(@PathVariable("subjectId") Integer subjectId)
			throws SubjectNotFoundException {
		List<Subject> existingSubject = subjectService.getallSubjects();
		for (Subject s : existingSubject) {
			if (s.getSubjectId() == subjectId) {
				Subject subject = subjectService.findSubject(subjectId);
				return new ResponseEntity<Subject>(subject, HttpStatus.OK);
			}
		}
		throw new SubjectNotFoundException("Subject is not Present in Database");
	}
	
	// http://localhost:8090/onlinecoursemanagement/subject/deletesubject/{subjectId}
	
	@DeleteMapping("/deletesubject/{subjectId}")
	public ResponseEntity<List<Subject>> deleteSubject(@PathVariable("subjectId") Integer subjectId)
			throws SubjectNotFoundException {
		List<Subject> existingSubject = subjectService.getallSubjects();
		for (Subject s : existingSubject) {
			if (s.getSubjectId() == subjectId) {
				List<Subject> subjectList = subjectService.deleteSubject(subjectId);
				return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);
			}
		}
		throw new SubjectNotFoundException("Subject is not Present in Database");
	}
	
	// http://localhost:8090/onlinecoursemanagement/subject/savesubject
	
	@PostMapping("/savesubject")
	public ResponseEntity<List<Subject>> saveSubject(@Valid @RequestBody Subject subject)
			throws DuplicateSubjectException {
		List<Subject> existingSubject = subjectService.getallSubjects();
		for (Subject s : existingSubject) {
			if (s.getSubjectId() == subject.getSubjectId()) {
				throw new DuplicateSubjectException("Subject already exists in Database");
			}
		}
		List<Subject> subjects = subjectService.saveSubject(subject);
		return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
	}
	
	// http://localhost:8090/onlinecoursemanagement/subject/updatesubject
	
	@PutMapping("/updatesubject")
	public ResponseEntity<List<Subject>> updateSubject(@RequestBody Subject subject) 
			throws SubjectNotFoundException {
		List<Subject> existingSubject = subjectService.getallSubjects();
		for (Subject s : existingSubject) {
			if (s.getSubjectId() == subject.getSubjectId()) {
				List<Subject> subjectList = subjectService.updateSubject(subject);
				return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);
			}
		}
		throw new SubjectNotFoundException("Subject is not Present in Database");
		
		
	}
}
