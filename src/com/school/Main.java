package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        Student[] students = {
            new Student("chetan", 1),
            new Student("satya", 2)
        };

        Course[] courses = {
            new Course("DBMS", "DBMS101"),
            new Course("OOPS", "OOPS101")
        };

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("\n--- Course List ---");
        for (Course c : courses) {
            c.displayDetails();
        }
    }
}
