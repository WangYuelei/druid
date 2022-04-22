package com.wyl.controller;

import com.wyl.model.ResultBean;
import com.wyl.model.Teacher;
import com.wyl.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Wyl
 * @create: 2022-04-22 09:55:06
 */
@RestController
@RequestMapping("teacher")
@Slf4j
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("teacherList")
    public ResultBean teacherList(){
        List<Teacher> allTeacher = teacherService.getAllTeacher();
        return ResultBean.ok(allTeacher);
    }
    @GetMapping("teacherWithStudent")
    public ResultBean teacherWithStudent(){
        List<Teacher> allTeacher = teacherService.getTeacherWithStudent();
        return ResultBean.ok(allTeacher);
    }
}
