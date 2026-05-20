package com.apphox.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.apphox.lms.dao.CoursesDao;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Course;

@Service
public class CourseService {
	@Autowired
	private CoursesDao courseDao;
	
	public ResponseEntity<ResponseStructure<Course>> saveCourse(Course course){
		ResponseStructure<Course> response=new ResponseStructure<Course>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Course created successfully");
		response.setData(courseDao.saveCourse(course));
		
		return new ResponseEntity<ResponseStructure<Course>>(response,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Course>> findCourseById(Integer id){
		ResponseStructure<Course> response=new ResponseStructure<Course>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Fetched the recorde");
		response.setData(courseDao.findCourseById(id));
		
		return new ResponseEntity<ResponseStructure<Course>>(response,HttpStatus.CREATED);
	} 
	
	public ResponseEntity<ResponseStructure<Course>> updateCourse(Course course){
		ResponseStructure<Course> response=new ResponseStructure<Course>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Updated the record");
		response.setData(courseDao.updateCourse(course));
		
		return new ResponseEntity<ResponseStructure<Course>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Course>> deleteCourse(Integer id){
		ResponseStructure<Course> response=new ResponseStructure<Course>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Record with specified id is deleted");
		response.setData(courseDao.deleteCourse(id));
		
		return new ResponseEntity<ResponseStructure<Course>>(response,HttpStatus.OK);
	}
}
