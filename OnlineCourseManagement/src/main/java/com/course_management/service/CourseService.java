package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.exception.DuplicateCourseException;
import com.course_management.exception.NoSuchCourseException;
import com.course_management.model.Course;

@Service
public interface CourseService {

	public List<Course> getAllCourse();

	public List<Course> deleteCourse(Integer courseId) throws NoSuchCourseException;

	public Course saveCourse(Course course) throws DuplicateCourseException;

	public List<Course> updateCourse(Course course) throws NoSuchCourseException;

	public Course findCourse(Integer courseId) throws NoSuchCourseException;
}
