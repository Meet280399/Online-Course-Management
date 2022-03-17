package com.course_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_management.dao.InstructorRepository;
import com.course_management.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepo;

	@Override
	public List<Instructor> getallInstructors() {

		return instructorRepo.findAll();
	}

	@Override
	public List<Instructor> deleteInstructor(Integer instructorId) {

		instructorRepo.deleteById(instructorId);

		return instructorRepo.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) {
	
		instructorRepo.saveAndFlush(instructor);
		
		return instructorRepo.save(instructor);
	}

	@Override
	public List<Instructor> updateInstructor(Instructor instructor) {
		
		instructorRepo.saveAndFlush(instructor);
		
		return instructorRepo.findAll();
	}

	@Override
	public Instructor findInstructor(Integer instructorId) {
		
		Optional<Instructor> instructorCollect = instructorRepo.findById(instructorId);
		 
		return instructorCollect.get();
	}

}
