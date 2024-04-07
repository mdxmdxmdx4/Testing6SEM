package com.belstu.errorNexception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Subject> subjects = Arrays.asList(new Subject("Math", 8), new Subject("Physics", 9));
            Student student = new Student("Ivan", subjects);
            Group group = new Group("Group1", Collections.singletonList(student));
            Faculty faculty = new Faculty("Faculty1", Collections.singletonList(group));
            University university = new University("University1", Collections.singletonList(faculty));

            System.out.println("Средний балл студента: " + student.getAverageGrade());
            System.out.println("Средний балл по предмету 'Math' в группе 'Group1' на факультете 'Faculty1': " + faculty.getAverageGradeBySubjectInGroup("Math", "Group1"));
            System.out.println("Средний балл по предмету 'Physics' в университете: " + university.getAverageGradeBySubject("Physics"));
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            new Subject("Math", 11); // Оценка выше 10
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            new Student("Petr", Collections.emptyList()); // Отсутствуют предметы у студента
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            new Group("Group2", Collections.emptyList()); // Отсутствуют студенты в группе
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            new Faculty("Faculty2", Collections.emptyList()); // Отсутствуют группы на факультете
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        try {
            new University("University2", Collections.emptyList()); // Отсутствуют факультеты в университете
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
