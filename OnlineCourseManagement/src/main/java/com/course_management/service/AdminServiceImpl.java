package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.CourseRepository;
import com.course_management.entity.Course;
import com.course_management.entity.Instructor;
import com.course_management.entity.Student;

@Service
public class AdminServiceImpl implements AdminService {
	
	// connecting the service implementation with the course repository
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Student> getallStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> saveStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> getallInstructors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> deleteInstructor(Integer instructorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> saveInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructor findInstructor(Integer instructorId) {
		// TODO Auto-generated method stub
		return null;
	}

	//method implementing to get all the courses 
	@Override
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}

	//method implementing to delete course with particular Id
	@Override
	public List<Course> deleteCourse(Integer courseId) {
		courseRepo.deleteById(courseId);
		return courseRepo.findAll();
	}

	//method implementing to save course
	@Override
	public Course saveCourse(Course course) {
		courseRepo.saveAndFlush(course);
		return courseRepo.save(course);
	}

	//method implementing to update particular courses
	@Override
	public List<Course> updateCourse(Course course) {
		courseRepo.saveAndFlush(course);
		return courseRepo.findAll();
	}

	//method implementing to find a course with it's Id
	@Override
	public Course findCourse(Integer courseId) {
		Optional<Course> courses = courseRepo.findById(courseId);
		return courses.get();
	}


}
