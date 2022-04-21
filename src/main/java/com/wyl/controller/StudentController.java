package com.wyl.controller;

import com.wyl.model.Student;
import com.wyl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("studentList")
    public List<Student> studentList(){
        return studentService.studentList();
    }
}
