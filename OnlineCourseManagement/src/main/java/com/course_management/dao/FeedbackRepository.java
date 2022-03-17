package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_management.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
