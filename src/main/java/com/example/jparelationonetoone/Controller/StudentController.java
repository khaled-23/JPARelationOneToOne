package com.example.jparelationonetoone.Controller;

import com.example.jparelationonetoone.Api.ApiResponse;
import com.example.jparelationonetoone.Model.Student;
import com.example.jparelationonetoone.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok(new ApiResponse("student added"));
    }

    @GetMapping("/students")
    public ResponseEntity getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity updateStudent(@PathVariable Integer student_id, @RequestBody @Valid Student student){
        studentService.updateStudent(student_id, student);
        return ResponseEntity.ok(new ApiResponse("student updated"));
    }

    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity deleteStudent(@PathVariable Integer student_id){
        studentService.deleteStudent(student_id);
        return ResponseEntity.ok(new ApiResponse("student deleted"));
    }

    @PutMapping("/assign-course/{student_id}/{course_id}")
    public ResponseEntity assignCourseToStudent(@PathVariable Integer student_id, @PathVariable Integer course_id){
        studentService.assignCourseToStudent(student_id,course_id);
        return ResponseEntity.ok(new ApiResponse("course added to student"));
    }

    @PutMapping("/change-major/{student_id}/{major}")
    public ResponseEntity changeStudentMajor(@PathVariable Integer student_id, @PathVariable String major){
        studentService.changeStudentMajor(student_id,major);
        return ResponseEntity.ok(new ApiResponse("student major changed"));
    }

}
