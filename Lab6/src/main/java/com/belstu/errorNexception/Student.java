package com.belstu.errorNexception;

import java.util.List;

public class Student {
    String name;
    List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        if (subjects == null || subjects.isEmpty()) {
            throw new IllegalArgumentException("У студента должен быть хотя бы один предмет");
        }
        this.name = name;
        this.subjects = subjects;

    }
    public double getAverageGrade() {
        return subjects.stream().mapToInt(s -> s.grade).average().orElse(0.0);
    }
}