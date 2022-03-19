package com.course_management.service;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.InstructorRepository;
import com.course_management.dao.SubjectRepository;
import com.course_management.dao.CourseRepository;
import com.course_management.exception.DuplicateCourseException;
import com.course_management.exception.DuplicateInstructorException;
import com.course_management.exception.DuplicateStudentException;
import com.course_management.exception.InstructorNotFoundException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.exception.StudentNotFoundException;
import com.course_management.exception.SubjectNotFoundException;
import com.course_management.model.Course;
import com.course_management.model.Instructor;
import com.course_management.model.Student;
import com.course_management.model.Subject;

/**
 * Admin Service Implementation Class for implementing the methods of Admin Service
 * @author Akshay Godwa and Akhil Inamdar
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

//	@Autowired
//	private SubjectRepository subjectRepo;

//	@Override
//	public List<Student> getallStudents() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

//	@Override
//	public List<Student> getallStudents() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Student> deleteStudent(Integer studentId) throws StudentNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/**
//	 * method to save new student in database
//	 */
//	@Override
//	public List<Student> saveStudent(Student student) throws DuplicateStudentException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Student> updateStudent(Student student) throws StudentNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Student findStudent(Integer studentId) throws StudentNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Instructor> getallInstructors() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Instructor> deleteInstructor(Integer instructorId) throws InstructorNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Instructor> saveInstructor(Instructor instructor) throws DuplicateInstructorException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Instructor> updateInstructor(Instructor instructor) throws InstructorNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Instructor findInstructor(Integer instructorId) throws InstructorNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	@Override
//	public double instructorPracticalHours() {
//		// TODO Auto-generated method stub
//		return 0;
//	}


}
