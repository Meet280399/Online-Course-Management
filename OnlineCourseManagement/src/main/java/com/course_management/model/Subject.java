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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The Class Subject is the Entity representing subject table in database
 * 
 * @author Akshay Gowda
 *
 */

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
//	@GeneratedValue
	@Column(name = "subject_Id")
	@NotNull(message = "Subject Id is mandatory")
	private int SubjectId;
	
	@Column(name = "subject_name")
	@NotEmpty(message = "Subject Name is mandatory")
	private String SubjectName;

//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
//	private Set<Course> courses = new HashSet<>();

	/**
	 * subject default constructor
	 */
	public Subject() {
		super();
	}

	/**
	 * subject constructor with fields as parameters
	 * 
	 * @param subjectId   the subject Id
	 * @param subjectName the name of subject
	 * @param courses     the course that will contain this subject
	 */
	public Subject(int subjectId, String subjectName, Set<Course> courses) {
		SubjectId = subjectId;
		SubjectName = subjectName;
//		this.courses = courses;
	}

	public Subject(int subjectId, String subjectName) {
		super();
		SubjectId = subjectId;
		SubjectName = subjectName;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	/**
	 * gets the name of subject
	 * 
	 * @return
	 */
	public String getSubjectName() {
		return SubjectName;
	}

	/**
	 * setter for the subject name
	 * 
	 * @param subjectName
	 */
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [SubjectId=" + SubjectId + ", SubjectName=" + SubjectName + "]";
	}

//	public Set<Course> getCourses() {
//		return courses;
//	}

//	public void setCourses(Set<Course> courses) {
//		this.courses = courses;
//	}

	

}