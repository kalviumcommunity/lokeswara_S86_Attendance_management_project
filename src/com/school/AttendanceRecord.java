package com.school;

public class AttendanceRecord implements Storable {
    private int studentId;
    private int courseId;
    private String status;

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        // Validation for status
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            this.status = "Invalid";
            System.out.println("⚠️ Warning: Invalid status provided for Student ID: S" + studentId);
        }
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Attendance -> Student ID: S" + studentId + ", Course ID: C" + courseId + ", Status: " + status);
    }

    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}
