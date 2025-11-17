package com.school;

import java.util.List;

/**
 * Main class - Acts as an orchestrator using service classes
 * Demonstrates SOLID principles with proper separation of concerns
 */
public class Main {
    
    // Method to demonstrate polymorphism using RegistrationService
    public static void displaySchoolDirectory(RegistrationService registrationService) {
        System.out.println("\n=== School Directory (Polymorphic Display) ===");
        List<Person> allPeople = registrationService.getAllPeople();
        for (Person person : allPeople) {
            person.displayDetails(); // Polymorphic call
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");
        System.out.println("Part 09: SOLID Service Layer with RegistrationService & AttendanceService\n");

        // Step 1: Initialize services with dependency injection
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Step 2: Register Students using RegistrationService
        System.out.println("=== Registering Students ===");
        registrationService.registerStudent("Vijay", "10th Grade");
        registrationService.registerStudent("Satya", "11th Grade");
        registrationService.registerStudent("Ravi", "12th Grade");
        registrationService.registerStudent("Anjali", "9th Grade");

        // Step 3: Register Teachers using RegistrationService
        System.out.println("\n=== Registering Teachers ===");
        registrationService.registerTeacher("Mr. Sharma", "DBMS");
        registrationService.registerTeacher("Ms. Priya", "OOPS");

        // Step 4: Register Staff using RegistrationService
        System.out.println("\n=== Registering Staff ===");
        registrationService.registerStaff("Ramesh", "Lab Assistant");
        registrationService.registerStaff("Suresh", "Clerk");

        // Step 5: Create Courses using RegistrationService
        System.out.println("\n=== Creating Courses ===");
        registrationService.createCourse("DBMS");
        registrationService.createCourse("OOPS");
        registrationService.createCourse("Computer Networks");

        // Step 6: Display individual lists
        System.out.println("\n--- Student List ---");
        for (Student s : registrationService.getStudents()) {
            s.displayDetails();
        }

        System.out.println("\n--- Teacher List ---");
        for (Teacher t : registrationService.getTeachers()) {
            t.displayDetails();
        }

        System.out.println("\n--- Staff List ---");
        for (Staff st : registrationService.getStaffMembers()) {
            st.displayDetails();
        }

        System.out.println("\n--- Course List ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        // Step 7: Demonstrate polymorphism with RegistrationService
        displaySchoolDirectory(registrationService);

        // Step 8: Display registration summary
        registrationService.displayRegistrationSummary();

        // Step 9: Mark Attendance using different overloaded methods
        System.out.println("\n=== Demonstrating Overloaded markAttendance Methods ===");
        
        // Method 1: Using Student and Course objects directly
        System.out.println("\n--- Using markAttendance(Student, Course, String) ---");
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
        
        // Method 2: Using IDs with RegistrationService lookup
        System.out.println("\n--- Using markAttendance(int, int, String) with RegistrationService ---");
        attendanceService.markAttendance(students.get(2).getId(), courses.get(2).getCourseId(), "Present");
        attendanceService.markAttendance(students.get(3).getId(), courses.get(1).getCourseId(), "Late");
        
        // Try with invalid ID to show error handling
        attendanceService.markAttendance(999, courses.get(0).getCourseId(), "Present");

        // Step 10: Display attendance logs using overloaded methods
        System.out.println("\n=== Demonstrating Overloaded displayAttendanceLog Methods ===");
        
        // Display all attendance records
        attendanceService.displayAttendanceLog();
        
        // Display attendance for a specific student
        attendanceService.displayAttendanceLog(students.get(1)); // Satya's records
        
        // Display attendance for a specific course
        attendanceService.displayAttendanceLog(courses.get(1)); // OOPS course records

        // Step 11: Save all data using service methods
        System.out.println("\n=== Saving All Data ===");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
        
        System.out.println("\n✅ Application completed successfully!");
        System.out.println("📁 Check the following files: students.txt, teachers.txt, staff.txt, courses.txt, attendance_log.txt");
    }
}
