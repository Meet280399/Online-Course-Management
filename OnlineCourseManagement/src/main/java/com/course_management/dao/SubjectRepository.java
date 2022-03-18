package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course_management.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
