package com.apphox.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apphox.lms.entity.Course;

public interface CoursesRepository extends JpaRepository<Course, Integer>{

}
