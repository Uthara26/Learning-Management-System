package com.apphox.lms.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.apphox.lms.entity.Enrollments;
import com.apphox.lms.exception.NoRecordAvailableException;
import com.apphox.lms.repository.EnrollmentsRepository;

@Repository
public class EnrollmentDao {
	@Autowired
	private EnrollmentsRepository enrollmentRepository;
	
	public Enrollments saveEnrollments(Enrollments enrollments) {
		return enrollmentRepository.save(enrollments);
	}
	
	public List<Enrollments> getCourseByStudentId(Integer id){
		List<Enrollments> enrollments=enrollmentRepository.findByStudentId(id);
		if(!enrollments.isEmpty()) {
			return enrollments;
		}
		else {
			throw new NoRecordAvailableException("No enrollment from this student "+enrollments);
		}
	}
}
