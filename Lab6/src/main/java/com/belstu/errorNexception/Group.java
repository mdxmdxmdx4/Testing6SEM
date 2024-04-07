package com.belstu.errorNexception;

import java.util.List;

public class Group {
    String name;
    List<Student> students;

    public Group(String name, List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("В группе должен быть хотя бы один студент");
        }
        this.name = name;
        this.students = students;
    }

    public double getAverageGradeBySubject(String subject) {
        return students.stream()
                .flatMap(s -> s.subjects.stream())
                .filter(s -> s.name.equals(subject))
                .mapToInt(s -> s.grade)
                .average().orElse(0.0);
    }
}