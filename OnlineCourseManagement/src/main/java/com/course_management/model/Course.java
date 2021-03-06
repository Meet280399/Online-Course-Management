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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The Class Course is the Entity representing course table in database
 * 
 * @author Akhil Inamdar
 *
 */

@Entity
@Table(name = "course")
public class Course {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_Id")
	@NotNull(message = "Course Id is mandatory")
	private int courseId;

	@Column(name = "course_name")
//	@NotEmpty(message = "Course Name is mandatory")
	private String courseName;

	@Column(name = "course_duration")
	private String courseDuration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_subject", joinColumns = { @JoinColumn(name = "course_id")}, inverseJoinColumns = {
			@JoinColumn(name = "subject_id")})
	private Set<Subject> subjects;

	// many to one relation with student entity
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
//	private Student student;

	@ManyToOne(targetEntity = Student.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "student_relation_id")
	private Student student;

	// one to many relation with project entity
	@OneToMany(targetEntity = Project.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "course_id")
	private Set<Project> projects;
	
	// one to one relation with instructor entity
	@OneToOne(mappedBy = "course")
	private Instructor instructor;
	
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
	public Course(int courseId, String courseName, String courseDuration, Set<Subject> subjects, Student student, Instructor instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.subjects = subjects;
		this.student = student;
		this.instructor = instructor;
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

//	public Student getStudent() {
//		return student;
//	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

//	public Instructor getInstructor() {
//		return instructor;
//	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public void addProject(Project project) {
		project.setCourse(this);
		this.getProjects().add(project);
	}
	
//	public void addSubject(Subject subject) {
//		subject.setCourses(this);
//		this.getSubjects().add(subject);
//	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", subjects=" + subjects + ", student=" + student + ", projects=" + projects + "]";
	}

	
}