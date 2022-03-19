package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.CourseRepository;
import com.course_management.exception.DuplicateCourseException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	// connecting the service implementation with the course repository
	@Autowired
	private CourseRepository courseRepo;

	// method implementing to get all the courses
	@Override
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}

	// method implementing to delete course with particular Id
	@Override
	public List<Course> deleteCourse(Integer courseId) throws NoSuchCourseException {
		courseRepo.deleteById(courseId);
		return courseRepo.findAll();
	}

	// method implementing to save course
	@Override
	public Course saveCourse(Course course) throws DuplicateCourseException {
		courseRepo.saveAndFlush(course);
		return courseRepo.save(course);
	}

	// method implementing to update particular courses
	@Override
	public List<Course> updateCourse(Course course) throws NoSuchCourseException {
		courseRepo.saveAndFlush(course);
		return courseRepo.findAll();
	}

	// method implementing to find a course with it's Id
	@Override
	public Course findCourse(Integer courseId) throws NoSuchCourseException {
		Optional<Course> courses = courseRepo.findById(courseId);
		return courses.get();
	}

}
