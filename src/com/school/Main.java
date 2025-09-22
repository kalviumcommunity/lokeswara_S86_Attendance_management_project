package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        // Updated Students with grade level
        Student[] students = {
            new Student("Chetan", "10th Grade"),
            new Student("Satya", "11th Grade"),
            new Student("Ravi", "12th Grade"),
            new Student("Anjali", "9th Grade")
        };

        // Teachers
        Teacher[] teachers = {
            new Teacher("Mr. Sharma", "DBMS"),
            new Teacher("Ms. Priya", "OOPS")
        };

        // Staff
        Staff[] staffMembers = {
            new Staff("Ramesh", "Lab Assistant"),
            new Staff("Suresh", "Clerk")
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

        System.out.println("\n--- Teacher List ---");
        for (Teacher t : teachers) {
            t.displayDetails();
        }

        System.out.println("\n--- Staff List ---");
        for (Staff st : staffMembers) {
            st.displayDetails();
        }

        System.out.println("\n--- Course List ---");
        for (Course c : courses) {
            c.displayDetails();
        }

        // Attendance Recording
        System.out.println("\n--- Attendance Log ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // using getId() instead of getStudentId()
        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "present")); // lowercase, still valid
        attendanceLog.add(new AttendanceRecord(students[3].getId(), courses[1].getCourseId(), "Late"));   // invalid

        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
