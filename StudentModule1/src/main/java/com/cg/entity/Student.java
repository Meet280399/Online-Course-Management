package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_email")
	private String studentEmail;
	@Column(name = "student_address")
	private String studentAddress;
	@Column(name = "student_mobile")
	private long studentMobile;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String studentEmail, String studentAddress, long studentMobile) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentAddress=" + studentAddress + ", studentMobile=" + studentMobile + "]";
	}
}