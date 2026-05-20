package com.apphox.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apphox.lms.dao.StudentDao;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		ResponseStructure<Student> response=new ResponseStructure<Student>();
		
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Student saved Successfully");
		response.setData(studentDao.saveStudent(student));
		
		return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents(){
		ResponseStructure<List<Student>> response=new ResponseStructure<List<Student>>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Successfully fetched all the students");
		response.setData(studentDao.getAllStudents());
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> getStudentById(Integer id){
		ResponseStructure<Student> response=new ResponseStructure<Student>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Student with id :"+id+" is fetchced");
		response.setData(studentDao.getStudentById(id));
		
		return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student){
		ResponseStructure<Student> response=new ResponseStructure<Student>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Updated the record");
		response.setData(studentDao.updateStudent(student));
		
		return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(Integer id){
		ResponseStructure<Student> response=new ResponseStructure<Student>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Record with specified id is deleted");
		response.setData(studentDao.deleteStudent(id));
		
		return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.OK);
	}

}
