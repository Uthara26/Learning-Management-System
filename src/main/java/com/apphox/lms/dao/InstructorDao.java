package com.apphox.lms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apphox.lms.entity.Instructor;
import com.apphox.lms.repository.InstructorRepository;

@Repository
public class InstructorDao {
	@Autowired
	private InstructorRepository instructorRepository;
	
	public Instructor saveInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

}
