# Attendance Management Project

This is a Java project for the Attendance Management System.

## Author

M Lokeswara Reddy

## Squad

S86

---

## Part 1

* Initial setup with folder structure and Welcome app.

## Part 2

* Added `Student` and `Course` classes.
* Updated `Main.java` to use arrays of objects.
* Displayed student and course details.

## Part 3

* Implemented **auto ID generation** for Students and Courses:

  * Student IDs start from **S1, S2, …**
  * Course IDs start from **C101, C102, …**
* Removed `setDetails()` methods and replaced with constructors.
* Updated `Main.java` to demonstrate multiple Student and Course objects with auto-generated IDs.

## Part 4

* Applied **Encapsulation** with private fields and getters.
* Added new `AttendanceRecord` class with validation.
* Demonstrated **basic attendance recording** with valid and invalid statuses.
* Updated `Main.java` to show attendance log.

## Part 5

* Implemented **inheritance hierarchy**:

  * Created `Person` base class with auto-increment ID and `name`.
  * `Student` extends `Person` with `gradeLevel`.
  * `Teacher` extends `Person` with `subjectTaught`.
  * `Staff` extends `Person` with `role`.
* Updated `Main.java` to:

  * Create objects of `Student`, `Teacher`, `Staff`.
  * Call `displayDetails()` on each object.
  * Use `student.getId()` in `AttendanceRecord`.
* Demonstrated unified ID generation and role-based display.

---

## How to Run

1. Navigate to project root.
2. Compile all Java files:

   ```bash
   javac src/com/school/*.java
   ```
3. Run the program:

   ```bash
   java -cp src com.school.Main
   ```

---
