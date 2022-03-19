package com.course_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course_management.exception.SubjectNotFoundException;
import com.course_management.model.Subject;

@Service
public interface SubjectService {

	public List<Subject> getallSubjects();
	public Subject saveSubject(Subject subject);
	public List<Subject> updateSubject(Subject subject) throws SubjectNotFoundException;
	public List<Subject> deleteSubject(Integer SubjectId) throws SubjectNotFoundException;

	/**
	 * find method for finding the subject with it's Id
	 * 
	 * @param SubjectId the subject Id
	 * @return returns the subject object after finding it
	 * @throws SubjectNotFoundException if subject with Id not in list throws
	 *                                  exception
	 */
	public Subject findSubject(Integer SubjectId) throws SubjectNotFoundException;
}
