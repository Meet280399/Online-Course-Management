package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.FeedbackRepository;
import com.course_management.dao.InstructorRepository;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.model.Feedback;
import com.course_management.model.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	// adding the dependent Instructor Repository to the Instructor Service
	// Implementation
	@Autowired
	private InstructorRepository instructorRepo;

	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepo.findAll();
	}

	@Override
	public List<Instructor> deleteInstructor(Integer instructorId) throws InstructorNotFoundException {
		try { 
			instructorRepo.deleteById(instructorId);
			return instructorRepo.findAll();
		}
		catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new InstructorNotFoundException("Instructor is not Present in Database");
		}
	}

	@Override
	public List<Instructor> saveInstructor(Instructor instructor) throws DuplicateInstructorException {
		try {
			instructorRepo.saveAndFlush(instructor);
			return instructorRepo.findAll();
		} catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new DuplicateInstructorException("Instructor already Exists in Database");
		}
	}

	@Override
	public List<Instructor> updateInstructor(Instructor instructor) throws InstructorNotFoundException {
		try {
			instructorRepo.saveAndFlush(instructor);
			return instructorRepo.findAll();
		}
		catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new InstructorNotFoundException("Instructor is not Present in Database");
		}
	}

	@Override
	public Instructor findInstructor(Integer instructorId) throws InstructorNotFoundException {
		try {
			Optional<Instructor> instructorCollect = instructorRepo.findById(instructorId);
			return instructorCollect.get();
		}
		catch (Exception e) {
			System.out.println("Inside Implementation");
			throw new InstructorNotFoundException("Instructor is not Present in Database");
		}
	}

	@Override
	public String checkInstructor(Instructor instructor) throws InstructorNotFoundException {
		try {
			String checkInstructor = instructorRepo.getInstructor(instructor.getEmail(), instructor.getInstPassword());
			System.out.println(checkInstructor);
			return checkInstructor;
		} catch (Exception e) {
			throw new InstructorNotFoundException("instructor not found");
		}
	}

}
