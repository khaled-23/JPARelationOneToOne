package com.example.jparelationonetoone.Service;

import com.example.jparelationonetoone.Api.ApiException;
import com.example.jparelationonetoone.Model.Teacher;
import com.example.jparelationonetoone.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null){
            throw new ApiException("teacher does not exists");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(teacher);
    }

    public void removeTeacher(Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if(teacher == null){
            throw new ApiException("teacher does not exists");
        }
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id){
        return teacherRepository.findTeacherById(id);
    }
}