package com.example.jparelationonetoone.Repository;

import com.example.jparelationonetoone.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer course_id);
}
