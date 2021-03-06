package com.course_management.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.course_management.model.Student;

/* @ControllerAdvice class to handle the exceptions globally */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//	@ExceptionHandler(DuplicateStudentException.class)
//	public ResponseEntity<ExceptionResponse> handleDuplicateEmpIdException(DuplicateStudentException e) {
//		ExceptionResponse response = new ExceptionResponse();
//        response.setErrorCode("CONFLICT");
//        response.setMessage(e.getMessage());
//        response.setDate(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
//		
//	}
	
	@ExceptionHandler(DuplicateStudentException.class)
	public ResponseEntity<Object> handleDuplicateStudentExecption() {
		LOG.error("handleDuplicateStudentExecption");
		return new ResponseEntity<Object>("Student already Exists in Database", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateInstructorException.class)
	public ResponseEntity<Object> handleDuplicateInstructorExecption() {
		LOG.error("handleDuplicateInstructorExecption");
		return new ResponseEntity<Object>("Instructor already Exists in Database", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateCourseException.class)
	public ResponseEntity<Object> handleDuplicateCourseExecption() {
		LOG.error("handleDuplicateCourseExecption");
		return new ResponseEntity<Object>("This Course already exists in the database", HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(DuplicateSubjectException.class)
	public ResponseEntity<Object> handleDuplicateSubjectException() {
		LOG.error("handleDuplicateSubjectException");
		return new ResponseEntity<Object>("This Subject already exists in the database.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException() {
		LOG.error("handleStudentNotFoundException");
		return new ResponseEntity<Object>("This Student is not present in the database.", HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(SubjectNotFoundException.class)
	public ResponseEntity<Object> handleSubjectNotFoundException() {
		LOG.error("handleSubjectNotFoundException");
		return new ResponseEntity<Object>("This Subject is not present in the database.", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InstructorNotFoundException.class)
	public ResponseEntity<Object> handleInstructorNotFoundException() {
		LOG.error("handleInstructorNotFoundException");
		return new ResponseEntity<Object>("This Instructor is not present in the database.", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchCourseException.class)
	public ResponseEntity<Object> handleNoSuchCourseException() {
		LOG.error("handleNoSuchCourseException");
		return new ResponseEntity<Object>("This Course is not present in the database.", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchFeedbackException.class)
	public ResponseEntity<Object> handleNoSuchFeedbackException() {
		LOG.error("handleNoSuchFeedbackException");
		return new ResponseEntity<Object>("This Feedback is not present in the database.", HttpStatus.BAD_REQUEST);
	}
	
	

}