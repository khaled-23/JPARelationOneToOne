package com.example.jparelationonetoone.Controller;

import com.example.jparelationonetoone.Api.ApiResponse;
import com.example.jparelationonetoone.Model.Course;
import com.example.jparelationonetoone.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course){
        courseService.addCourse(teacher_id,course);
        return ResponseEntity.ok(new ApiResponse("course added and assigned to "+ teacher_id));
    }

    @GetMapping("/courses")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PutMapping("/update/{course_id}")
    public ResponseEntity updateCourse(@PathVariable Integer course_id, @RequestBody @Valid Course course){
        courseService.updateCourse(course_id, course);
        return ResponseEntity.ok(new ApiResponse("course updated"));
    }

    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity removeCourse(@PathVariable Integer course_id){
        courseService.removeCourse(course_id);
        return ResponseEntity.ok(new ApiResponse("course delete"));
    }

    @GetMapping("/teacher/{course_id}")
    public ResponseEntity teacherNameByCourseId(@PathVariable Integer course_id){
        return ResponseEntity.ok(new ApiResponse(courseService.getTeacherNameByCourseId(course_id)));
    }

    @GetMapping("/students/{course_id}")
    public ResponseEntity getStudentsByCourseId(@PathVariable Integer course_id){
        return ResponseEntity.ok(courseService.getAllStudentByCourseId(course_id));
    }

}
