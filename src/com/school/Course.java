// src/com/school/Course.java
package com.school;

public class Course {
    private static int nextCourseIdCounter = 101; // auto ID generator
    private String courseName;
    private int courseId;

    public Course(String courseName) {
        this.courseName = courseName;
        this.courseId = nextCourseIdCounter++;
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName + " (C" + courseId + ")");
    }
}
