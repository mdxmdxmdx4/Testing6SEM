package com.belstu.errorNexception;

public class Subject {
    String name;
    int grade;

    public Subject(String name, int grade) {
        if (grade < 0 || grade > 10) {
            throw new IllegalArgumentException("Оценка должна быть между 0 и 10");
        }
        this.name = name;
        this.grade = grade;
    }
}
