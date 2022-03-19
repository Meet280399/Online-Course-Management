package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.FeedbackRepository;
import com.course_management.exception.NoSuchFeedbackException;
import com.course_management.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	// adding the dependent Feedback Repository to the Instructor Service
	// Implementation
	@Autowired
	private FeedbackRepository feedbackRepo;

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepo.findAll();
	}

	@Override
	public List<Feedback> deleteFeedback(Integer feedbackId) throws NoSuchFeedbackException {
		try { feedbackRepo.deleteById(feedbackId);
		return feedbackRepo.findAll();
		}
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
