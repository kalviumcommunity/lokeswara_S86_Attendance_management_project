package com.school;

import java.util.ArrayList;
import java.util.List;

/**
 * RegistrationService - Manages registration and persistence of all entities
 * Applies Single Responsibility Principle (SRP) by handling only entity management
 */
public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storageService;

    // Constructor with dependency injection
    public RegistrationService(FileStorageService storageService) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storageService = storageService;
    }

    // Registration methods
    public void registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
        System.out.println("✅ Student registered: " + name + " (ID: S" + student.getId() + ")");
    }

    public void registerTeacher(String name, String subjectTaught) {
        Teacher teacher = new Teacher(name, subjectTaught);
        teachers.add(teacher);
        System.out.println("✅ Teacher registered: " + name + " (ID: " + teacher.getId() + ")");
    }

    public void registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
        System.out.println("✅ Staff registered: " + name + " (ID: " + staff.getId() + ")");
    }

    public void createCourse(String courseName) {
        Course course = new Course(courseName);
        courses.add(course);
        System.out.println("✅ Course created: " + courseName + " (ID: C" + course.getCourseId() + ")");
    }

    // Getter methods for accessing managed lists
    public List<Student> getStudents() {
        return new ArrayList<>(students); // Return copy to maintain encapsulation
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Staff> getStaffMembers() {
        return new ArrayList<>(staffMembers);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Lookup methods by ID
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    // Get all people for polymorphic operations
    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    // Save all registrations to files
    public void saveAllRegistrations() {
        System.out.println("\n=== Saving All Registrations ===");
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }

    // Display summary statistics
    public void displayRegistrationSummary() {
        System.out.println("\n=== Registration Summary ===");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Teachers: " + teachers.size());
        System.out.println("Total Staff: " + staffMembers.size());
        System.out.println("Total Courses: " + courses.size());
    }
}
