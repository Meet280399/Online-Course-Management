package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.SubjectRepository;
import com.course_management.exception.SubjectNotFoundException;
import com.course_management.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	public List<Subject> getallSubjects() {
		return subjectRepo.findAll();
	}

	@Override
	public List<Subject> saveSubject(Subject subject) {
		subjectRepo.saveAndFlush(subject);
		return subjectRepo.findAll();
	}

	@Override
	public List<Subject> updateSubject(Subject subject) throws SubjectNotFoundException {
		subjectRepo.saveAndFlush(subject);
		return subjectRepo.findAll();
	}

	@Override
	public List<Subject> deleteSubject(Integer SubjectId) throws SubjectNotFoundException {
		subjectRepo.deleteById(SubjectId);
		return subjectRepo.findAll();
	}

	@Override
	public Subject findSubject(Integer SubjectId) throws SubjectNotFoundException {
		Optional<Subject> subjectCollect = subjectRepo.findById(SubjectId);
		return subjectCollect.get();
	}
}
