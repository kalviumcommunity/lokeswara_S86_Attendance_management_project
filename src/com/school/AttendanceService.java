package com.school;

import java.util.ArrayList;
import java.util.List;

/**
 * AttendanceService - Manages attendance records only
 * Applies Single Responsibility Principle (SRP) by focusing solely on attendance management
 * Depends on RegistrationService for entity lookups
 */
public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    // Constructor with dependency injection
    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // Overloaded method 1: Mark attendance using Student and Course objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("✅ Attendance marked for " + student.getName() + " in " + course.getCourseName());
    }

    // Overloaded method 2: Mark attendance using IDs with lookup via RegistrationService
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        
        if (student != null && course != null) {
            markAttendance(student, course, status); // Calls the first overloaded method
        } else {
            System.out.println("❌ Error: Student ID " + studentId + " or Course ID " + courseId + " not found");
        }
    }

    // Overloaded method 1: Display all attendance records
    public void displayAttendanceLog() {
        System.out.println("\n=== Complete Attendance Log ===");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    // Overloaded method 2: Display attendance records for a specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n=== Attendance Log for " + student.getName() + " ===");
        boolean found = false;
        
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().getId() == student.getId()) {
                record.displayRecord();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No attendance records found for " + student.getName());
        }
    }

    // Overloaded method 3: Display attendance records for a specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n=== Attendance Log for " + course.getCourseName() + " ===");
        boolean found = false;
        
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().getCourseId() == course.getCourseId()) {
                record.displayRecord();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No attendance records found for " + course.getCourseName());
        }
    }

    // Save attendance data to file
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }

    // Getter for attendance log (if needed for external access)
    public List<AttendanceRecord> getAttendanceLog() {
        return new ArrayList<>(attendanceLog); // Return a copy to maintain encapsulation
    }
}