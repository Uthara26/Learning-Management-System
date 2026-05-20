package com.apphox.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apphox.lms.dao.InstructorDao;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Instructor;

@Service
public class InstructorService {
	@Autowired
	private InstructorDao instructorDao;
	
	public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(Instructor instructor){
		ResponseStructure<Instructor> response=new ResponseStructure<Instructor>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Instructor is saved successfully");
		response.setData(instructorDao.saveInstructor(instructor));
		
		return new ResponseEntity<ResponseStructure<Instructor>>(response,HttpStatus.CREATED);
	}

}
