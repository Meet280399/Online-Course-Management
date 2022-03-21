package com.course_management.model;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Feedback is the Entity representing feedback table in database
 * 
 * @author Rahul Kumar
 *
 */

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@Column(name = "feedback_id")
	private int feedbackId;
	private String description;
	private LocalDate feedbackDate;

	@ManyToOne(targetEntity = Instructor.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	/**
	 * feedback default constructor
	 */
	public Feedback() {
		super();
	}

	/**
	 * feedback constructor with fields as parameters
	 * 
	 * @param feedbackId   the feedback Id
	 * @param description  the description given for feedback
	 * @param feedbackDate the date on which feedback was given
	 * @param instructor   the feedback given by instructor
	 */
	public Feedback(int feedbackId, String description, LocalDate feedbackDate) {
		super();
		this.feedbackId = feedbackId;
		this.description = description;
		this.feedbackDate = feedbackDate;
//		this.instructor = instructor;
	}

	/**
	 * gets the feedback Id
	 * 
	 * @return
	 */
	public int getFeedbackId() {
		return feedbackId;
	}

	/**
	 * setters for the feedback Id
	 * 
	 * @param feedbackId
	 */
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

//	@Override
//	public String toString() {
//		return "Feedback [feedbackId=" + feedbackId + ", description=" + description + ", feedbackDate=" + feedbackDate
//				+ ", instructor=" + instructor + "]";
//	}

}
