package com.javatpoint.model;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer roll;
    private Character grade;
    private Float gpa;

    public Student(String name, Integer roll, Character grade, Float gpa) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
        this.gpa = gpa;
    }
}
