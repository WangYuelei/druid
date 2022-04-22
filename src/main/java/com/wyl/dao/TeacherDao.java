package com.wyl.dao;

import com.wyl.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeacher();

    List<Teacher> getTeacherWithStudent();

}
