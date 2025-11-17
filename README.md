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

## Part 6

* Implemented **Interface-Driven Persistence** with storage:
  * Created `Storable` interface with `toDataString()` method.
  * Implemented `FileStorageService` class for saving data to files.
  * Made `Student`, `Course`, and `AttendanceRecord` implement `Storable`.
  * Updated `Main.java` to save data to text files.

## Part 7

* Demonstrated **Runtime Polymorphism** using Person hierarchy:
  * Modified `AttendanceRecord` to use `Student` and `Course` objects instead of IDs.
  * Updated constructor to accept `Student` and `Course` objects.
  * Enhanced `displayRecord()` to show student names and course names.
  * Added `displaySchoolDirectory(List<Person>)` method to demonstrate polymorphic calls.
  * Created unified `schoolPeople` list containing all Person objects.
  * Implemented filtering using `instanceof` for file storage.
* **Key Features:**
  * Polymorphic method calls in School Directory display.
  * Richer attendance log with names instead of just IDs.
  * Proper object-oriented design with composition in AttendanceRecord.

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance

* Created **`AttendanceService.java`** class to encapsulate attendance logic and manage the list of `AttendanceRecord` objects.
* Implemented **overloaded `markAttendance` methods** in `AttendanceService`:
  * `markAttendance(Student student, Course course, String status)` - Direct object-based method
  * `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` - ID-based method with lookups
* Implemented **overloaded `displayAttendanceLog` methods** in `AttendanceService`:
  * `displayAttendanceLog()` - Shows all attendance records
  * `displayAttendanceLog(Student student)` - Filters by specific student
  * `displayAttendanceLog(Course course)` - Filters by specific course
* Added **helper methods** for object lookups:
  * `findStudentById(int studentId, List<Student> allStudents)`
  * `findCourseById(int courseId, List<Course> allCourses)`
* **Key Features:**
  * Method overloading for flexible API usage
  * Encapsulation of attendance management logic
  * Error handling for invalid IDs
  * Integration with existing `FileStorageService`
  * Proper validation and status feedback

## Part 9: SOLID Service Layer - RegistrationService & AttendanceService Separation

* Applied **Single Responsibility Principle (SRP)** by creating dedicated service classes with clear separation of concerns.
* **Modified `Teacher.java` and `Staff.java`**:
  * Implemented `Storable` interface for file persistence
  * Added `toDataString()` method for CSV export
  * Added getter methods for encapsulated fields
* **Created `RegistrationService.java`**:
  * Centralized management of all entity registration (Students, Teachers, Staff, Courses)
  * Implements dependency injection with `FileStorageService`
  * Provides registration methods: `registerStudent()`, `registerTeacher()`, `registerStaff()`, `createCourse()`
  * Provides lookup methods: `findStudentById()`, `findCourseById()`
  * Provides accessor methods: `getStudents()`, `getTeachers()`, `getStaffMembers()`, `getCourses()`, `getAllPeople()`
  * Provides `saveAllRegistrations()` method for persisting all data
  * Encapsulates entity lists, removing direct list management from Main
* **Refactored `AttendanceService.java`**:
  * Now depends on `RegistrationService` for entity lookups (dependency injection)
  * Removed internal helper methods (`findStudentById`, `findCourseById`)
  * Updated `markAttendance(int, int, String)` to use `RegistrationService` for lookups
  * Focuses solely on attendance record management (SRP)
* **Refactored `Main.java`**:
  * Acts as an orchestrator using service-based architecture
  * Removed direct entity list management
  * Uses `RegistrationService` for all entity operations
  * Uses `AttendanceService` for all attendance operations
  * Updated `displaySchoolDirectory()` to accept `RegistrationService` and use `getAllPeople()`
  * Demonstrates proper dependency injection pattern
* **Key SOLID Principles Demonstrated**:
  * **Single Responsibility Principle**: Each service has one clear responsibility
  * **Dependency Inversion Principle**: High-level modules depend on abstractions (services)
  * **Open/Closed Principle**: Services are open for extension, closed for modification
* **New Files Generated**:
  * `teachers.txt` - Persists teacher data in CSV format
  * `staff.txt` - Persists staff data in CSV format

---

## How to Run

1. Navigate to project root directory
2. Compile all Java files:

   ```bash
   javac -d . src/com/school/*.java
   ```
3. Run the program:

   ```bash
   java com.school.Main
   ```

## Expected Output

The program will display:
1. **Registration Process** - Students, Teachers, Staff, and Courses being registered via RegistrationService
2. **Individual Entity Lists** - Separate displays for Students, Teachers, Staff, and Courses
3. **School Directory** - Polymorphic display of all Person objects
4. **Registration Summary** - Statistics showing total counts of each entity type
5. **Overloaded markAttendance Methods** - Demonstrations of different ways to mark attendance
6. **Overloaded displayAttendanceLog Methods** - Complete log, student-specific, and course-specific views
7. **Data Persistence** - Confirmation of all data saved to files

## Generated Files

After running the application, the following files will be created/updated:
- `students.txt` - Student records in CSV format (ID, Name, Grade Level)
- `teachers.txt` - Teacher records in CSV format (ID, Name, Subject)
- `staff.txt` - Staff records in CSV format (ID, Name, Role)
- `courses.txt` - Course records in CSV format (ID, Course Name)
- `attendance_log.txt` - Attendance records in CSV format (Student ID, Course ID, Status)