package com.course_management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "student_id")
	private int studentId;
	private String firstName;
	private String lastName;
	private String studentEmail;
	private String studentAddress;
	private long studentMobile;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@ElementCollection
	private Set<Course> courses = new HashSet<>();

	public Student() {

	}

	public Student(int studentId, String firstName, String lastName, String studentEmail, String studentAddress,
			long studentMobile, Set<Course> courses) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentMobile = studentMobile;
		this.courses = courses;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", studentEmail=" + studentEmail + ", studentAddress=" + studentAddress + ", studentMobile="
				+ studentMobile + "]";
	}

}
