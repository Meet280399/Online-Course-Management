package com.course_management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="project")
public class ProjectManagement {
	@Id
	@GeneratedValue
	@Column(name="project_Id")
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="projects")
	private Set<Course> courses=new HashSet<>();
	private int projectId;
	private String projectName;
	private String projectDifficultyLevel;
	public ProjectManagement() {
		
	}
	public ProjectManagement(Set<Course> courses, int projectId, String projectName, String projectDifficultyLevel) {
		super();
		this.courses = courses;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDifficultyLevel = projectDifficultyLevel;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDifficultyLevel() {
		return projectDifficultyLevel;
	}
	public void setProjectDifficultyLevel(String projectDifficultyLevel) {
		this.projectDifficultyLevel = projectDifficultyLevel;
	}
	@Override
	public String toString() {
		return "ProjectManagement [courses=" + courses + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", projectDifficultyLevel=" + projectDifficultyLevel + "]";
	}
	
	

}
