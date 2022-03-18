package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.entity.Course;
import com.course_management.entity.Instructor;
import com.course_management.entity.Student;
import com.course_management.entity.Subject;
import com.course_management.exception.InstructorNotFoundException;

@Service
public interface AdminService {
//public List<String> setCurriculum();
//public List<Subject> getAllSubjects();
//public List<Subject> deleteSubject(Integer subjectId);
//public List<Subject> saveSubject(Subject subject);
//public List<Student> updateSubject(Subject Subject);
//public Subject findSubject(Integer SubjectId);

	// Administrator has managing the Students
	public List<Student> getallStudents();
	public List<Student> deleteStudent(Integer studentId);
	public List<Student> saveStudent(Student student);
	public List<Student> updateStudent(Student student);
	public Student findStudent(Integer studentId);

	// Administrator has managing the Instructor
	public List<Instructor> getallInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId);
	public List<Instructor> saveInstructor(Instructor instructor);
	public List<Instructor> updateInstructor(Instructor instructor);
	public Instructor findInstructor(Integer instructorId);

	// Administrator dealing the Salary of Instructor
//	public List<Instructor> setsalaryToInstructor(double instructorSalary);
//	public List<Instructor> getallSalaryOfInstructor(double instructorSalary);
//	public List<Instructor> deleteSalaryOfInstructor(double instructorSalary);
//	public List<Instructor> updatesalaryofInstructor(double instructorSalary);
//	public List<Instructor> savesalaryofInstructor(double instructorSalary);
//	public List<Instructor> saveAll();

//Administrator managing the Subjects
	public List<Subject> getallSubjects();
	public Subject saveSubject(Subject subject);
	public List<Subject> updateSubject(Subject subject);
	public List<Subject> deleteSubject(Integer SubjectId);
	public Subject findSubject(Integer SubjectId);
	public double instructorPracticalHours();
	

	// Administrator managing with the course entity to set curriculum
	public List<Course> getAllCourse();
	public List<Course> deleteCourse(Integer courseId);
	public Course saveCourse(Course course);
	public List<Course> updateCourse(Course course);
	public Course findCourse(Integer courseId);


}