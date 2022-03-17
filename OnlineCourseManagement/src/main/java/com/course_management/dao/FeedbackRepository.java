package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course_management.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
