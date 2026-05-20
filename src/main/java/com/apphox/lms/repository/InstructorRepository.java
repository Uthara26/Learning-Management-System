package com.apphox.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apphox.lms.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
