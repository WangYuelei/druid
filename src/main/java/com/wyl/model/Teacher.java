package com.wyl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer id;

    private String name;

    private Integer age;

    private Integer grade;

    private List<Student> students;
}