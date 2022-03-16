package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Student;

public interface FeedbackRepository  extends JpaRepository<Student, Integer>{

}
