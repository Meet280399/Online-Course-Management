package com.course_management.entity;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Feedback {
	private int feedbackId;
	private String description;
	private LocalDate feedbackDate;

	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int feedbackId, String description, LocalDate feedbackDate, Instructor instructor) {
		super();
		this.feedbackId = feedbackId;
		this.description = description;
		this.feedbackDate = feedbackDate;
		this.instructor = instructor;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", description=" + description + ", feedbackDate=" + feedbackDate
				+ ", instructor=" + instructor + "]";
	}

}
