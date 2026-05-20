package com.apphox.lms.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.apphox.lms.entity.Student;
import com.apphox.lms.exception.IdNotFoundException;
import com.apphox.lms.exception.NoRecordAvailableException;
import com.apphox.lms.repository.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	
	public Student getStudentById(Integer id) {
		Optional<Student> opt=studentRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IdNotFoundException(id+ ": id not existing in DB");
		}
	}
	
	
	public Student updateStudent(Student student) {
		if(student.getId()==null) {
			throw new IdNotFoundException("Pass the id in request body");
		}
		Optional<Student> opt=studentRepository.findById(student.getId());
		if(opt.isPresent()) {
			studentRepository.save(student);
			return opt.get();
		}
		else {
			throw new NoRecordAvailableException("Id Not Existing in db");
		}
	}
	
	public Student deleteStudent(Integer id) {
		Optional<Student> opt=studentRepository.findById(id);
		if(opt.isPresent()) {
			studentRepository.deleteById(id);
			return opt.get();
		}
		else{
			throw new NoRecordAvailableException("Id Not Existing in db");
		}
	}
}
