package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course_management.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	@Query("SELECT i.email FROM Instructor i WHERE i.email=:instructor_email AND i.instPassword=:inst_password")
	public String getInstructor(@Param("instructor_email") String instructor_email, @Param("inst_password") String inst_password);
}
