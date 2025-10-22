package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private String courseName;
    private int courseId;

    public Course(String courseName) {
        this.courseName = courseName;
        this.courseId = nextCourseIdCounter++;
    }

    // Getters (Encapsulation)
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName + " (C" + courseId + ")");
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}
