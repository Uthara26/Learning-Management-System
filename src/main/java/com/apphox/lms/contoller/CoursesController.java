package com.apphox.lms.contoller;
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
import com.apphox.lms.entity.Course;
import com.apphox.lms.service.CourseService;

@RestController
@RequestMapping("/course")
 class CoursesController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestBody Course course){
		return courseService.saveCourse(course);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Course>> getCourseById(@PathVariable Integer id){
		return courseService.findCourseById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Course>> updateCourse(@RequestBody Course course){
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Course>> deleteCourse(@PathVariable Integer id){
		return courseService.deleteCourse(id);
    }
}
