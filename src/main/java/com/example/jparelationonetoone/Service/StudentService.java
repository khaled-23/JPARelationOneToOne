package com.example.jparelationonetoone.Service;

import com.example.jparelationonetoone.Api.ApiException;
import com.example.jparelationonetoone.Model.Course;
import com.example.jparelationonetoone.Model.Student;
import com.example.jparelationonetoone.Repository.CourseRepository;
import com.example.jparelationonetoone.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void updateStudent(Integer student_id, Student student){
        Student s = studentRepository.findStudentById(student_id);
        if(s == null){
            throw new ApiException("student does not exists");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
    }

    public void deleteStudent(Integer student_id){
        Student student = studentRepository.findStudentById(student_id);
        if(student == null){
            throw new ApiException("student does not exists");
        }
        studentRepository.delete(student);
    }

    public void assignCourseToStudent(Integer student_id, Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if(student == null || course == null){
            throw new ApiException("can't assign");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeStudentMajor(Integer student_id, String major){
        Student student = studentRepository.findStudentById(student_id);
        if(student == null){
            throw new ApiException("student does not exists");
        }
        student.getCourses().clear();
        student.setMajor(major);
        studentRepository.save(student);
    }
}
