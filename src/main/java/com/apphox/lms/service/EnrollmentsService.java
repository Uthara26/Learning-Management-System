package com.apphox.lms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.apphox.lms.dao.EnrollmentDao;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Enrollments;

@Service
public class EnrollmentsService {
	@Autowired
	private EnrollmentDao enrollmentDao;
	
	public ResponseEntity<ResponseStructure<Enrollments>> saveEnrollments (Enrollments  enrollments){
		ResponseStructure<Enrollments> response=new ResponseStructure<Enrollments>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Enrollemnt saved successfully");
		response.setData(enrollmentDao.saveEnrollments(enrollments));
		
		return new ResponseEntity<ResponseStructure<Enrollments>>(response,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Enrollments>>> getCourseByStudentId (Integer id){
		ResponseStructure<List<Enrollments>> response=new ResponseStructure<List<Enrollments>>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("fetched the courses");
		response.setData(enrollmentDao.getCourseByStudentId(id));
		
		return new ResponseEntity<ResponseStructure<List<Enrollments>>>(response,HttpStatus.OK);
	}

}
