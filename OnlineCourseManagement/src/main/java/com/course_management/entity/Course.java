package com.course_management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course
{
@Id
@GeneratedValue
@Column(name= "course_Id")
private int courseId;
private String courseName;
private int courseDuration;


 @ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "Course_Subject", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "subject_id") })
private Set<Subject> subjects = new HashSet<>();

 public Course() {
}

 public Course(int courseId, String courseName, int courseDuration, Set<Subject> subjects) {
this.courseId = courseId;
this.courseName = courseName;
this.courseDuration = courseDuration;
this.subjects = subjects;
}

 public int getCourseId() {
return courseId;
}

 public void setCourseId(int courseId) {
this.courseId = courseId;
}

 public String getCourseName() {
return courseName;
}

 public void setCourseName(String courseName) {
this.courseName = courseName;
}

 public int getCourseDuration() {
return courseDuration;
}

 public void setCourseDuration(int courseDuration) {
this.courseDuration = courseDuration;
}

 public Set<Subject> getSubjects() {
return subjects;
}

 public void setSubjects(Set<Subject> subjects) {
this.subjects = subjects;
}

 @Override
public String toString() {
return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
+ ", subjects=" + subjects + "]";
}
public void addSubject(Subject subject) {
this.getSubjects().add(subject);
}

}