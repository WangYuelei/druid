package com.wyl.dao;

import com.wyl.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao {
    List<Student> getAllStudents();
}
