package com.school;

public class Teacher extends Person {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name); // Person handles ID & name
        this.subjectTaught = subjectTaught;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher, Subject: " + subjectTaught);
    }
}
