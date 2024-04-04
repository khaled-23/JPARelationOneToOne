package com.example.jparelationonetoone.Controller;

import com.example.jparelationonetoone.Api.ApiResponse;
import com.example.jparelationonetoone.Model.Teacher;
import com.example.jparelationonetoone.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(TeacherController.class);


    @GetMapping("/teachers")
    public ResponseEntity getAllTeachers(){
        logger.info("get all teachers requested");
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        logger.info("teacher added");
        return ResponseEntity.ok(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{teacher_id}")
    public ResponseEntity updateTeacher(@PathVariable Integer teacher_id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(teacher_id, teacher);
        logger.info("teacher updated");
        return ResponseEntity.ok(new ApiResponse("teacher updated"));
    }

    @DeleteMapping("/remove/{teacher_id}")
    public ResponseEntity removeTeacher(@PathVariable Integer teacher_id){
        teacherService.removeTeacher(teacher_id);
        logger.info("teacher removed");
        return ResponseEntity.ok(new ApiResponse("teacher removed"));
    }

    @GetMapping("/get/{teacher_id}")
    public ResponseEntity getTeacherById(@PathVariable Integer teacher_id){
        logger.info(teacher_id + " teacher requested");
        return ResponseEntity.ok(teacherService.getTeacherById(teacher_id));
    }


}
