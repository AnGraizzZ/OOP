package com.javalesson.javaio;

import com.javalesson.collections.map.treemap.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
    private String name;
    private float AVG;
    private  Set<SubjectGrade> grades;

    public Student(String name, float AVG, Set<SubjectGrade> grades) {
        this.name = name;
        this.AVG = AVG;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public float getAVG() {
        return AVG;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }
}
