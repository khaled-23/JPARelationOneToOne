package com.example.jparelationonetoone.Service;

import com.example.jparelationonetoone.Api.ApiException;
import com.example.jparelationonetoone.Model.Course;
import com.example.jparelationonetoone.Model.Student;
import com.example.jparelationonetoone.Model.Teacher;
import com.example.jparelationonetoone.Repository.CourseRepository;
import com.example.jparelationonetoone.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public void addCourse(Integer teacher_id,Course course){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void updateCourse(Integer course_id, Course course){
        Course c = courseRepository.findCourseById(course_id);
        if(c==null){
            throw new ApiException("course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void removeCourse(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }

    public String getTeacherNameByCourseId(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("course not found");
        }
        return course.getTeacher().getName();
    }
//    public void assignCourseToTeacher(Integer course_id, Integer teacher_id){
//        Course course
//        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
//    }

    public Set<Student> getAllStudentByCourseId(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("course not found");
        }
        return course.getStudents();
    }
}
