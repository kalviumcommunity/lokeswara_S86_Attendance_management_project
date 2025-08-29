package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        Student[] students = {
            new Student("Chetan"),
            new Student("Satya"),
            new Student("Ravi"),
            new Student("Anjali")
        };

        Course[] courses = {
            new Course("DBMS"),
            new Course("OOPS"),
            new Course("Computer Networks")
        };

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("\n--- Course List ---");
        for (Course c : courses) {
            c.displayDetails();
        }

        // Attendance Recording
        System.out.println("\n--- Attendance Log ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "present")); // lowercase, still valid
        attendanceLog.add(new AttendanceRecord(students[3].getStudentId(), courses[1].getCourseId(), "Late"));   // invalid

        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
