package com.apphox.lms.contoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apphox.lms.dto.ResponseStructure;
import com.apphox.lms.entity.Instructor;
import com.apphox.lms.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Instructor>> saveInstructor(@RequestBody Instructor instructor){
		return instructorService.saveInstructor(instructor);
	}

}
