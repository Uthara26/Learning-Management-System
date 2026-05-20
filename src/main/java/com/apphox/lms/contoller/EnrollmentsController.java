package com.apphox.lms.contoller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Enrollments;
import com.apphox.lms.service.EnrollmentsService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentsController {
	@Autowired
	private EnrollmentsService enrollmentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Enrollments>> saveEnrollments(@RequestBody Enrollments enrollments){
		return enrollmentService.saveEnrollments(enrollments);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<ResponseStructure<List<Enrollments>>> getCourseByStudentId(@PathVariable Integer id){
		return enrollmentService.getCourseByStudentId(id);
	}
}
