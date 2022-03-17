package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_management.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
