package com.course_management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 * The Class Project is the Entity representing project table in database
 * 
 * @author Vinod Kumar
 *
 */

@Entity
@Table(name = "project")
public class Project {
	@Id
//	@GeneratedValue
	@Column(name = "project_Id")
	private int projectId;
	private String projectName;
	private String projectDifficultyLevel;

	@ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;

	/**
	 * project default constructor
	 */
	public Project() {
		super();
	}

	/**
	 * project constructor with fields as parameters
	 * 
	 * @param projectId              the project Id
	 * @param projectName            the name of the project
	 * @param projectDifficultyLevel the difficulty level of project
	 * @param course                 the course that will contain this project
	 */
	public Project(int projectId, String projectName, String projectDifficultyLevel, Course course) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDifficultyLevel = projectDifficultyLevel;
		this.course = course;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * gets the name of project
	 * 
	 * @return
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * setter for the project name
	 * 
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDifficultyLevel() {
		return projectDifficultyLevel;
	}

	public void setProjectDifficultyLevel(String projectDifficultyLevel) {
		this.projectDifficultyLevel = projectDifficultyLevel;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDifficultyLevel="
				+ projectDifficultyLevel + ", course=" + course + "]";
	}

}
