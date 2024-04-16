package com.example.jparelationonetoone.Repository;

import com.example.jparelationonetoone.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
Student findStudentById(Integer student_id);
}
