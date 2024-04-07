package com.belstu.errorNexception;

import java.util.List;

public class Faculty {
    String name;
    List<Group> groups;

    public Faculty(String name, List<Group> groups) {
        if (groups == null || groups.isEmpty()) {
            throw new IllegalArgumentException("На факультете должна быть хотя бы одна группа");
        }
        this.name = name;
        this.groups = groups;
    }

    public double getAverageGradeBySubjectInGroup(String subject, String groupName) {
        return groups.stream()
                .filter(g -> g.name.equals(groupName))
                .flatMap(g -> g.students.stream())
                .flatMap(s -> s.subjects.stream())
                .filter(s -> s.name.equals(subject))
                .mapToInt(s -> s.grade)
                .average().orElse(0.0);
    }
}
