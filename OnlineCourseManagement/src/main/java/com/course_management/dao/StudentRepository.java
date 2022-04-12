package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course_management.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("SELECT s.studentEmail FROM Student s WHERE s.studentEmail=:student_email AND s.password=:password")
	public String getStudent(@Param("student_email") String student_email, @Param("password") String password);
}
