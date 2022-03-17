package com.course_management.entity;


	import java.time.LocalDate;

	public class Feedback {
		private int feedbackId;
		private String description;
		private LocalDate feedbackDate;
		
		
		
		
		public Feedback() {
			super();
			// TODO Auto-generated constructor stub
		}




		public Feedback(int feedbackId, String description, LocalDate feedbackDate) {
			super();
			this.feedbackId = feedbackId;
			this.description = description;
			this.feedbackDate = feedbackDate;
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




		@Override
		public String toString() {
			return "Feedback [feedbackId=" + feedbackId + ", description=" + description + ", feedbackDate=" + feedbackDate
					+ "]";
		}
		
		

	}



