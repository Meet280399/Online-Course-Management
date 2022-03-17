package com.course_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course_management.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
