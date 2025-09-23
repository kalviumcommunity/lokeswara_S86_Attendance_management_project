package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        // Use ArrayLists now
        List<Student> students = new ArrayList<>();
        students.add(new Student("Chetan", "10th Grade"));
        students.add(new Student("Satya", "11th Grade"));
        students.add(new Student("Ravi", "12th Grade"));
        students.add(new Student("Anjali", "9th Grade"));

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Mr. Sharma", "DBMS"));
        teachers.add(new Teacher("Ms. Priya", "OOPS"));

        List<Staff> staffMembers = new ArrayList<>();
        staffMembers.add(new Staff("Ramesh", "Lab Assistant"));
        staffMembers.add(new Staff("Suresh", "Clerk"));

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("DBMS"));
        courses.add(new Course("OOPS"));
        courses.add(new Course("Computer Networks"));

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
        attendanceLog.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "present"));
        attendanceLog.add(new AttendanceRecord(students.get(3).getId(), courses.get(1).getCourseId(), "Late"));

        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Save to files
        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}
