package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, Grade Level: " + gradeLevel);
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + gradeLevel;
    }
}
