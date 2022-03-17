package com.course_management.entity;

import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@GeneratedValue
	@Column(name = "subject_Id")
	private int SubjectId;
	private String SubjectName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects")
	private Set<Course> courses = new HashSet<>();

	public Subject() {
	}

	public Subject(int subjectId, String subjectName, Set<Course> courses) {
		SubjectId = subjectId;
		SubjectName = subjectName;
		this.courses = courses;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Subject [SubjectId=" + SubjectId + ", SubjectName=" + SubjectName + ", courses=" + courses + "]";
	}

}