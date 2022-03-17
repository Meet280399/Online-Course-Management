package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_management.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
