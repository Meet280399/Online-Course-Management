package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_management.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
