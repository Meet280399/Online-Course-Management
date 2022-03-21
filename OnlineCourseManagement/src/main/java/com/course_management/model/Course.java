package com.course_management.model;

import java.util.HashSet;
import java.util.Objects;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The Class Course is the Entity representing course table in database
 * 
 * @author Meet Patel
 *
 */

@Entity
@Table(name = "course")
public class Course {
	@Id
//	@GeneratedValue
	@Column(name = "course_Id")
	private int courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "course_duration")
	private String courseDuration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_Subject", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "subject_id") })
	private Set<Subject> subjects = new HashSet<>();

	// many to one relation with student entity
	@ManyToOne(targetEntity = Student.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	// one to many relation with project entity
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Project.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "course_id")
	private Set<Project> projects;

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
	public Course(int courseId, String courseName, String courseDuration, Set<Subject> subjects) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.subjects = subjects;
//		this.student = student;
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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void addProject(Project project) {
		project.setCourse(this);
		this.getProjects().add(project);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", subjects=" + subjects + ", student=" + student + ", projects=" + projects + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseDuration, courseId, courseName, projects, student, subjects);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseDuration, other.courseDuration) && courseId == other.courseId
				&& Objects.equals(courseName, other.courseName) && Objects.equals(projects, other.projects)
				&& Objects.equals(student, other.student) && Objects.equals(subjects, other.subjects);
	}

}