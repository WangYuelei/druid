package com.wyl.service.impl;

import com.wyl.dao.TeacherDao;
import com.wyl.model.Teacher;
import com.wyl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public List<Teacher> getTeacherWithStudent() {
        return teacherDao.getTeacherWithStudent();
    }
}
