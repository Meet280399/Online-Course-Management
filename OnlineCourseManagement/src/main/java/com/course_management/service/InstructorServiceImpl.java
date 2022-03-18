package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.FeedbackRepository;
import com.course_management.dao.InstructorRepository;
import com.course_management.entity.Feedback;
import com.course_management.entity.Instructor;

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
	public List<Instructor> deleteInstructor(Integer instructorId) {
		instructorRepo.deleteById(instructorId);
		return instructorRepo.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) {
		instructorRepo.saveAndFlush(instructor);
		return instructorRepo.save(instructor);
	}

	@Override
	public List<Instructor> updateInstructor(Instructor instructor) {
		instructorRepo.saveAndFlush(instructor);
		return instructorRepo.findAll();
	}

	@Override
	public Instructor findInstructor(Integer instructorId) {
		Optional<Instructor> instructorCollect = instructorRepo.findById(instructorId);
		return instructorCollect.get();
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepo.findAll();
	}

	@Override
	public List<Feedback> deleteFeedback(Integer feedbackId) {
		feedbackRepo.deleteById(feedbackId);
		return feedbackRepo.findAll();
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		feedbackRepo.saveAndFlush(feedback);
		return feedbackRepo.save(feedback);
	}

	@Override
	public List<Feedback> updateFeedback(Feedback feedback) {
		feedbackRepo.saveAndFlush(feedback);
		return feedbackRepo.findAll();
	}

	@Override
	public Feedback findFeedback(Integer feedbackId) {
		Optional<Feedback> feedbackCollect = feedbackRepo.findById(feedbackId);
		return feedbackCollect.get();
	}

}
