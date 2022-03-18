package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.FeedbackRepository;
import com.course_management.dao.InstructorRepository;
import com.course_management.entity.Feedback;
import com.course_management.entity.Instructor;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchFeedbackException;

@Service
public class InstructorServiceImpl implements InstructorService {

	// adding the dependent Instructor Repository to the Instructor Service Implementation
	@Autowired
	private InstructorRepository instructorRepo;

	// adding the dependent Feedback Repository to the Instructor Service Implementation
	@Autowired
	private FeedbackRepository feedbackRepo;

	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepo.findAll();
	}

	@Override
	public List<Instructor> deleteInstructor(Integer instructorId) throws InstructorNotFoundException{
		instructorRepo.deleteById(instructorId);
		return instructorRepo.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) throws DuplicateInstructorException {
		instructorRepo.saveAndFlush(instructor);
		return instructorRepo.save(instructor);
	}

	@Override
	public List<Instructor> updateInstructor(Instructor instructor) throws InstructorNotFoundException{
		instructorRepo.saveAndFlush(instructor);
		return instructorRepo.findAll();
	}

	@Override
	public Instructor findInstructor(Integer instructorId) throws InstructorNotFoundException {
		Optional<Instructor> instructorCollect = instructorRepo.findById(instructorId);
		return instructorCollect.get();
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepo.findAll();
	}

	@Override
	public List<Feedback> deleteFeedback(Integer feedbackId) throws NoSuchFeedbackException{
		feedbackRepo.deleteById(feedbackId);
		return feedbackRepo.findAll();
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		feedbackRepo.saveAndFlush(feedback);
		return feedbackRepo.save(feedback);
	}

	@Override
	public List<Feedback> updateFeedback(Feedback feedback) throws NoSuchFeedbackException {
		feedbackRepo.saveAndFlush(feedback);
		return feedbackRepo.findAll();
	}

	@Override
	public Feedback findFeedback(Integer feedbackId) throws NoSuchFeedbackException {
		Optional<Feedback> feedbackCollect = feedbackRepo.findById(feedbackId);
		return feedbackCollect.get();
	}

}
