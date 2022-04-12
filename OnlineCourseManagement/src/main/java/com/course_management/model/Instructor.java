package com.course_management.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * The Class Instructor is the Entity representing instructor table in database
 * 
 * @author Ashwini Mekala
 *
 */

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "instructor_id")
//	@NotNull(message = "Instructor Id is mandatory")
	private int instructorId;

	@Column(name = "instructor_name")
//	@NotEmpty(message = "Instructor Name is mandatory")
	private String name;

	@Column(name = "instructor_email")
	@NotEmpty(message = "Instructor E-Mail is mandatory")
	private String email;

	@Column(name = "instructor_mobile")
	@NotNull(message = "Instructor Mobile Number is mandatory")
	private Long mobileNo;

	@Column(name = "instructor_salary")
	private double salary;

//	@Column(name = "grades_given")
	@Column(name = "grade_given")
	private int grades;
	
	@Column(name = "inst_password")
	private String instPassword;

	// entity relation with the feedback entity (OneToMany)
	@OneToMany(targetEntity = Feedback.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "instructor_id")
	private Set<Feedback> feedbacks;

//	@OneToOne(cascade = CascadeType.ALL, targetEntity = Course.class)
//    private Course course;
	
	@OneToOne
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
	 * @param course       the course instructor is teaching
	 */
	public Instructor(int instructorId, String name, String email, Long mobileNo, double salary, int grades, Course course) {
		super();
		this.instructorId = instructorId;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.salary = salary;
		this.grades = grades;
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

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public void addFeedback(Feedback feedback) {
		feedback.setInstructor(this);
		this.getFeedbacks().add(feedback);
	}
	
//	public void addCourse(Course course) {
//		course.setInstructor(this);
//		this.getCourse();
//	}
	
	

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", name=" + name + ", email=" + email + ", mobileNo="
				+ mobileNo + ", salary=" + salary + ", grades=" + grades + ", feedbacks=" + feedbacks + ", course="
				+ course + "]";
	}

	public String getInstPassword() {
		return instPassword;
	}

	public void setInstPassword(String instPassword) {
		this.instPassword = instPassword;
	}
	

}
