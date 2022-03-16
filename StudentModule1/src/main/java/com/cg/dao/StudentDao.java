package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	@Query("SELECT grade FROM INSTRUCTOR grade")
	public Student getGrade(int grade);
	
}
