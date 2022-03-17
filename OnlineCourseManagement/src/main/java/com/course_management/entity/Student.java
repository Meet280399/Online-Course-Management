package com.course_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@Column(name = "student_id")
	private int studentId;
	private String firstName;
	private String lastName;
	private String studentEmail;
	private String studentAddress;
	private long studentMobile;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String firstName, String lastName, String studentEmail, String studentAddress,
			long studentMobile) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentMobile = studentMobile;
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", studentEmail=" + studentEmail + ", studentAddress=" + studentAddress + ", studentMobile="
				+ studentMobile + "]";
	}

}
