package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private String courseName;
    private int courseId;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.courseId = nextCourseIdCounter++;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters (Encapsulation)
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents); // Return copy for encapsulation
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    // Method to add student with capacity check
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false; // Capacity exceeded
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName + " (C" + courseId + ")");
        System.out.println("  Capacity: " + capacity + " | Enrolled: " + enrolledStudents.size() + 
                         " | Available: " + (capacity - enrolledStudents.size()));
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName + "," + capacity;
    }
}
