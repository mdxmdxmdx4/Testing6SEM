package com.belstu.errorNexception;

import java.util.List;

public class University {
    String name;
    List<Faculty> faculties;

    public University(String name, List<Faculty> faculties) {
        if (faculties == null || faculties.isEmpty()) {
            throw new IllegalArgumentException("В университете должен быть хотя бы один факультет");
        }
        this.name = name;
        this.faculties = faculties;
    }

    public double getAverageGradeBySubject(String subject) {
        return faculties.stream()
                .flatMap(f -> f.groups.stream())
                .flatMap(g -> g.students.stream())
                .flatMap(s -> s.subjects.stream())
                .filter(s -> s.name.equals(subject))
                .mapToInt(s -> s.grade)
                .average().orElse(0.0);
    }
}