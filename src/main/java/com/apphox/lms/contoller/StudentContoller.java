package com.apphox.lms.contoller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Student;
import com.apphox.lms.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentContoller {
	@Autowired
	private StudentService studentservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
		return studentservice.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents(){
		return studentservice.getAllStudents();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable Integer id){
		return studentservice.getStudentById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student){
		return studentservice.updateStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable Integer id){
		return studentservice.deleteStudent(id);
	}
}
