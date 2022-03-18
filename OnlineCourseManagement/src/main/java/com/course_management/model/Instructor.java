package com.course_management.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class Instructor is the Entity representing instructor table in database
 * 
 * @author Ashwini Mekala
 *
 */

@Entity
@Access(AccessType.FIELD)
@Table(name = "instructor")
public class Instructor {
	@Id
//	@GeneratedValue
	@Column(name = "instructor_id")
	private int instructorId;

	@Column(name = "instructor_name")
	private String name;

	@Column(name = "instructor_email")
	private String email;

	@Column(name = "instructor_mobile")
	private String mobileNo;

	@Column(name = "instructor_salary")
	private double salary;

//	@Column(name = "grades_given")
	@Column(name = "grade_given")
	private int grades;

	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	private Set<Feedback> feedbacks = new HashSet<>();// Initialization required to avoid NullPointerException

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;

	/**
	 * instructor default constructor
	 */
	public Instructor() {
		super();
	}

	/**
	 * instructor constructor with fields as parameters
	 * 
	 * @param instructorId the instructor id
	 * @param name         the name of the instructor
	 * @param email        the email of the instructor
	 * @param mobileNo     the mobile number of the instructor
	 * @param salary       the salary of instructor
	 * @param grades       the grades given by instructor
	 * @param feedbacks    the feedbacks given by instructor
	 * @param course       the course instructor is teaching
	 */
	public Instructor(int instructorId, String name, String email, String mobileNo, double salary, int grades,
			Set<Feedback> feedbacks, Course course) {
		super();
		this.instructorId = instructorId;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.salary = salary;
		this.grades = grades;
		this.feedbacks = feedbacks;
		this.course = course;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	/**
	 * gets the instructor name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setters for the instructor name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getGrades() {
		return grades;
	}

	public void setGrades(int grades) {
		this.grades = grades;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", name=" + name + ", email=" + email + ", mobileNo="
				+ mobileNo + ", salary=" + salary + ", grades=" + grades + ", feedbacks=" + feedbacks + "]";
	}

}