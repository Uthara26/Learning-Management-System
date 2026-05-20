package com.apphox.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apphox.lms.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
