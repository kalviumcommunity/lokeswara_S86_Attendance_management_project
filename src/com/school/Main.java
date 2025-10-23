package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    // Method to demonstrate polymorphism
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory (Polymorphic Display) ===");
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        // Use ArrayLists now
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vijay", "10th Grade"));
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

        // Create ArrayList of Person objects for polymorphism demonstration
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);   
        schoolPeople.addAll(teachers);      
        schoolPeople.addAll(staffMembers);
        
        // Demonstrate polymorphism
        displaySchoolDirectory(schoolPeople);

        // Create FileStorageService and AttendanceService instances
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        System.out.println("\n=== Demonstrating Overloaded markAttendance Methods ===");
        
        // Method 1: Using Student and Course objects directly
        System.out.println("\n--- Using markAttendance(Student, Course, String) ---");
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
        
        // Method 2: Using IDs with lookup
        System.out.println("\n--- Using markAttendance(int, int, String, Lists) ---");
        attendanceService.markAttendance(students.get(2).getId(), courses.get(2).getCourseId(), "Present", students, courses);
        attendanceService.markAttendance(students.get(3).getId(), courses.get(1).getCourseId(), "Late", students, courses);
        
        // Try with invalid ID to show error handling
        attendanceService.markAttendance(999, courses.get(0).getCourseId(), "Present", students, courses);

        System.out.println("\n=== Demonstrating Overloaded displayAttendanceLog Methods ===");
        
        // Method 1: Display all attendance records
        attendanceService.displayAttendanceLog();
        
        // Method 2: Display attendance for a specific student
        attendanceService.displayAttendanceLog(students.get(1)); // Satya's records
        
        // Method 3: Display attendance for a specific course
        attendanceService.displayAttendanceLog(courses.get(1)); // OOPS course records

        // Save attendance data using AttendanceService
        System.out.println("\n=== Saving Data ===");
        attendanceService.saveAttendanceData();
        
        // Save other data types
        List<Student> studentsForStorage = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                studentsForStorage.add((Student) person);
            }
        }
        
        storage.saveData(studentsForStorage, "students.txt");
        storage.saveData(courses, "courses.txt");
    }
}
