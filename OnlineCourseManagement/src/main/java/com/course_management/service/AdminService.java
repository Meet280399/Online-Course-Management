package com.course_management.service;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.stereotype.Service;

import com.course_management.entity.Course;
import com.course_management.entity.Instructor;
import com.course_management.entity.Student;
import com.course_management.entity.Subject;
import com.course_management.exception.DuplicateCourseException;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.exception.SubjectNotFoundException;

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
	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException;
	public List<Student> saveStudent(Student student) throws DuplicateStudentException;
	public List<Student> updateStudent(Student student) throws StudentNotFoundException;
	public Student findStudent(Integer studentId) throws StudentNotFoundException;

	// Administrator has managing the Instructor
	public List<Instructor> getallInstructors();
	public List<Instructor> deleteInstructor(Integer instructorId) throws InstanceNotFoundException;
	public List<Instructor> saveInstructor(Instructor instructor) throws DuplicateInstructorException;
	public List<Instructor> updateInstructor(Instructor instructor) throws InstanceNotFoundException ;
	public Instructor findInstructor(Integer instructorId) throws InstanceNotFoundException ;

	// Administrator dealing the Salary of Instructor
//	public List<Instructor> setsalaryToInstructor(double instructorSalary);
//	public List<Instructor> getallSalaryOfInstructor(double instructorSalary);
//	public List<Instructor> deleteSalaryOfInstructor(double instructorSalary);
//	public List<Instructor> updatesalaryofInstructor(double instructorSalary);
//	public List<Instructor> savesalaryofInstructor(double instructorSalary);
//	public List<Instructor> saveAll();

//Administrator managing the Subjects
	public List<Subject> getallSubjects();
	public Subject saveSubject(Subject subject) ;
	public List<Subject> updateSubject(Subject subject) throws SubjectNotFoundException;
	public List<Subject> deleteSubject(Integer SubjectId) throws SubjectNotFoundException;
	public Subject findSubject(Integer SubjectId) throws SubjectNotFoundException;
	public double instructorPracticalHours();
	

// Administrator managing with the course entity to set curriculum
	public List<Course> getAllCourse();
	public List<Course> deleteCourse(Integer courseId) throws NoSuchCourseException;
	public Course saveCourse(Course course) throws DuplicateCourseException;
	public List<Course> updateCourse(Course course) throws NoSuchCourseException;
	public Course findCourse(Integer courseId) throws NoSuchCourseException;


}