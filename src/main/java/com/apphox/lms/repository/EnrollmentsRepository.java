package com.apphox.lms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apphox.lms.entity.Enrollments;

public interface EnrollmentsRepository extends JpaRepository<Enrollments, Integer>{
	
	List<Enrollments> findByStudentId(Integer id);

}
