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

import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.exception.SubjectNotFoundException;
import com.course_management.model.Student;
import com.course_management.model.Subject;
import com.course_management.service.StudentService;
import com.course_management.service.SubjectService;

@RestController
@RequestMapping("Subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	//URL :- http://localhost:8090/OnlineCourseManagement/Subject-Details/All-Subject
	
	@GetMapping("/All-Subjects")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjectList = subjectService.getallSubjects();

		if (subjectList.isEmpty()) {
			return new ResponseEntity("Sorry no Subject found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);

	}
	@GetMapping("/Subject/{subjectId}")
	public ResponseEntity<Subject> findSubjectById(@PathVariable("subjectId") Integer subjectId) throws SubjectNotFoundException {

		Subject subject = subjectService.findSubject(subjectId);

		return new ResponseEntity<Subject>(subject, HttpStatus.OK);

	}

	@DeleteMapping("/Delete-Subject/{subjectId}")
	public ResponseEntity<List<Subject>> deleteSubject(@PathVariable("subjectId") Integer subjectId) throws SubjectNotFoundException {
		List<Subject> subjectList = subjectService.deleteSubject(subjectId);

		return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);

	}
	@PostMapping("/Save-Subject")
	public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) throws DuplicateSubjectException
	{
		Subject subjects= subjectService.saveSubject(subject);
		if(subjects==null)
		{
			return new ResponseEntity("Sorry! Subject not present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Subject>(subjects, HttpStatus.OK);
	
	}
	
	@PutMapping("/Update-Subject")
	public ResponseEntity<List<Subject>> updateSubject(@RequestBody Subject subject) throws SubjectNotFoundException{
		
		List<Subject> subjectList= subjectService.updateSubject(subject);
		if(subjectList.isEmpty())
		{
			return new ResponseEntity("Sorry! Subject not Present!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Subject>>(subjectList, HttpStatus.OK);
	}
}



