package com.wyl.service;

import com.wyl.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();

    List<Teacher> getTeacherWithStudent();
}
