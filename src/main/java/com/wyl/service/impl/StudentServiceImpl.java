package com.wyl.service.impl;

import com.wyl.dao.StudentDao;
import com.wyl.model.Student;
import com.wyl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> studentList() {
        List<Student> allStudents = studentDao.getAllStudents();
        return allStudents;
    }
}
