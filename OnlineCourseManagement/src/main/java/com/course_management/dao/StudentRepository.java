package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
