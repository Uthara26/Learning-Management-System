package com.apphox.lms.dao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.apphox.lms.entity.Course;
import com.apphox.lms.exception.IdNotFoundException;
import com.apphox.lms.exception.NoRecordAvailableException;
import com.apphox.lms.repository.CoursesRepository;

@Repository
public class CoursesDao {
	@Autowired
	private CoursesRepository courseRepository;
	
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Course findCourseById(Integer id) {
		Optional<Course> opt=courseRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException(id+ ": id not existing in DB");
		}
	}
	
	
	public Course updateCourse(Course course) {
		if(course.getId()==null) {
			throw new IdNotFoundException("Id should be provided inorder to update record");
		}
		Optional<Course> opt=courseRepository.findById(course.getId());
		if(opt.isPresent()) {
			courseRepository.save(course);
			return opt.get();
		}
		else {
			throw new NoRecordAvailableException("Id Not Existing in db");
		}
	}
	
	public Course deleteCourse(Integer id) {
		Optional<Course> opt=courseRepository.findById(id);
		if(opt.isPresent()) {
			courseRepository.deleteById(id);
			return opt.get();
		}
		else{
			throw new NoRecordAvailableException("Id Not Existing in db");
		}
	}
}
