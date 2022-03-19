package com.course_management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Course is the Entity representing course table in database
 * 
 * @author Meet Patel
 *
 */

@Entity
@Access(AccessType.FIELD)
@Table(name = "Course")
public class Course {
	@Id
//	@GeneratedValue
	@Column(name = "course_Id")
	private int courseId;
	private String courseName;
	private String courseDuration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_Subject", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "subject_id") })
	private Set<Subject> subjects = new HashSet<>();

	@ManyToOne(targetEntity = Student.class)
	@JoinColumn(name = "studentId")
	private Student student;

	/**
	 * Course default Constructor
	 */
	public Course() {
	}

	/**
	 * Course Constructor with fields as parameters
	 * 
	 * @param courseId       the course Id
	 * @param courseName     the name of course
	 * @param courseDuration the duration of course
	 * @param subjects       the subjects present in the course
	 * @param student        the course that student has taken
	 */
	public Course(int courseId, String courseName, String courseDuration, Set<Subject> subjects,
			Student student) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.subjects = subjects;
		this.student = student;
	}
	
	public Course(int courseId, String courseName, String courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * gets the name of the course
	 * 
	 * @return
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * setter method for the course name
	 * 
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

//	@Override
//	public String toString() {
//		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
//				+ ", subjects=" + subjects + ", projects=" + projects + "]";
//	}

}