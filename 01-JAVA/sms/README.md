# Student Management System

A console-based Student Management System built in Java as part of **Project Titan**.

The project started as a simple Java console application and has been progressively developed using Object-Oriented Programming, validation, custom exceptions, service-layer design, Repository Pattern, Strategy Pattern, Dependency Injection, file persistence, Maven, JUnit 5, and continuous refactoring.

## Features

- Add Student
- View All Students
- Search Student by ID
- Delete Student
- Update Student
- Prevent Duplicate Student IDs
- Student Validation
- Custom Exception Handling
- Dummy Student Data
- File-Based Persistence
- Linear Search
- Binary Search
- Bubble Sort
- Selection Sort
- Built-in Java Sorting
- Search Strategy Pattern
- Sorting Strategy Pattern
- Repository Pattern
- Constructor Dependency Injection
- Automated JUnit Testing

## Technologies

- Java 25
- Maven
- JUnit 5
- ArrayList
- Object-Oriented Programming
- Interfaces
- Generics
- Exception Handling
- File I/O
- Strategy Pattern
- Repository Pattern
- Dependency Injection
- IntelliJ IDEA / VS Code
- Git & GitHub

## Project Structure

```text
sms/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── app/
│   │   │   │   └── Main.java
│   │   │   ├── exceptions/
│   │   │   │   ├── DuplicateStudentException.java
│   │   │   │   ├── InvalidAgeException.java
│   │   │   │   ├── InvalidChoiceException.java
│   │   │   │   ├── InvalidStudentException.java
│   │   │   │   └── StudentNotFoundException.java
│   │   │   ├── model/
│   │   │   │   └── Student.java
│   │   │   ├── repository/
│   │   │   │   ├── StudentRepository.java
│   │   │   │   └── InMemoryStudentRepository.java
│   │   │   ├── searching/
│   │   │   │   ├── SearchStrategy.java
│   │   │   │   ├── LinearSearchStrategy.java
│   │   │   │   └── BinarySearchStrategy.java
│   │   │   ├── service/
│   │   │   │   └── StudentService.java
│   │   │   ├── sorting/
│   │   │   │   ├── SortingStrategy.java
│   │   │   │   ├── BubbleSortStrategy.java
│   │   │   │   ├── SelectionSortStrategy.java
│   │   │   │   └── BuiltInSortStrategy.java
│   │   │   ├── util/
│   │   │   │   ├── InputHelper.java
│   │   │   │   └── FileHandler.java
│   │   │   └── validation/
│   │   │       └── Validator.java
│   │   └── resources/
│   │       └── data/
│   │           └── students.txt
│   └── test/
│       └── java/
│           ├── repository/
│           │   └── InMemoryStudentRepositoryTest.java
│           └── service/
│               └── StudentServiceTest.java
```

## Architecture

```text
                         Main
                          │
                  Console / UI Layer
                          │
                          ▼
                   StudentService
                  /       |        \
                 /        |         \
                ▼         ▼          ▼
          Repository   Search     Sorting
              │        Strategy   Strategy
              │          │           │
              ▼          ▼           ▼
       Student Data   Linear /    Bubble /
                      Binary      Selection /
                                  Built-in
```

### Main

`Main` acts as the console/UI layer.

It is responsible for reading user actions, calling helpers and services, handling user-facing exceptions, and displaying results.

Repeated workflows are extracted into helper methods such as:

- `addStudent()`
- `viewStudents()`
- `searchStudent()`
- `deleteStudent()`
- `updateStudent()`
- `sortStudents()`

### InputHelper

Handles console input and input-level validation, including integer input, string input, menu choices, and update field choices.

### StudentService

Contains application/business logic and coordinates:

- Validation
- Repository operations
- Search strategies
- Sorting strategies
- Domain exceptions
- File loading and saving

The service does not handle console presentation.

### Repository

`StudentRepository` defines the data-access contract and `InMemoryStudentRepository` provides the in-memory implementation.

The Repository is responsible for storing and retrieving student data. It does not contain search algorithms, sorting algorithms, or console output.

Current repository responsibilities include:

- Get and replace the student collection
- Add a student
- Delete a student
- Check whether a student ID exists
- Check whether the collection is empty
- Get collection size
- Get/set a student by index
- Swap students by index

### Validation

`Validator` contains reusable validation rules such as numeric, age, student, and choice validation.

### Exceptions

Custom exceptions represent domain-specific errors:

- `DuplicateStudentException`
- `InvalidAgeException`
- `InvalidChoiceException`
- `InvalidStudentException`
- `StudentNotFoundException`

## Search Strategy

```java
public interface SearchStrategy {
    Student search(ArrayList<Student> students, int id);
}
```

Implementations:

- `LinearSearchStrategy`
- `BinarySearchStrategy`

`StudentService` supplies the repository's student list to the selected strategy. The Repository itself does not implement a search strategy.

## Sorting Strategy

```java
public interface SortingStrategy {
    void sort(ArrayList<Student> students);
}
```

Implementations:

- `BubbleSortStrategy`
- `SelectionSortStrategy`
- `BuiltInSortStrategy`

`StudentService` supplies the student list to the selected sorting strategy. Sorting is not a Repository responsibility.

## Repository Pattern

The service depends on the repository interface instead of directly depending on storage details:

```java
StudentRepository repository =
        new InMemoryStudentRepository();

StudentService studentService =
        new StudentService(repository);
```

This provides loose coupling, easier testing, and the ability to replace the storage implementation later.

## Dependency Injection

`StudentService` receives its repository through its constructor:

```java
public StudentService(StudentRepository repository) {
    this.repository = repository;
}
```

The dependency is created outside the service and injected through the constructor.

## File Persistence

Student records are loaded from and saved to:

```text
src/main/resources/data/students.txt
```

File operations are handled by `FileHandler`.

## Testing

The project uses **JUnit 5** with Maven.

Current test distribution:

| Test Class | Tests |
|---|---:|
| `InMemoryStudentRepositoryTest` | 16 |
| `StudentServiceTest` | 20 |
| **Total** | **36** |

Latest verified Maven result:

```text
Tests run: 36
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

Run the full test suite with:

```bash
mvn clean test
```

Testing follows Arrange–Act–Assert:

```text
Arrange
   ↓
Prepare test data
   ↓
Act
   ↓
Call the method
   ↓
Assert
   ↓
Verify the result
```

## Day 22 — Main.java Refactoring

Day 22 focused on improving the structure of `Main.java`.

Completed:

- Moved update-choice validation into `InputHelper`
- Removed business-layer console printing
- Extracted `viewStudents()`
- Extracted `sortStudents()`
- Extracted `searchStudent()`
- Extracted `addStudent()`
- Extracted `deleteStudent()`
- Extracted `updateStudent()`

The refactoring was verified with the project's automated tests.

## Day 23 — Repository Cleanup

Day 23 focused on separating data access from search and sorting algorithms.

Completed:

- Removed `searchStudent()` from `StudentRepository`
- Removed the Repository's old search implementation
- Removed Repository search tests
- Kept `deleteStudent()` as a direct Repository data operation
- Removed `sortById()` from the Repository contract
- Kept sorting inside `SortingStrategy` implementations
- Removed Repository console output
- Removed an unused `Comparator` import
- Expanded Repository test coverage
- Verified the complete application with Maven

Final Day 23 architecture:

```text
Main
 ↓
StudentService
 ├── SearchStrategy
 │    ├── LinearSearchStrategy
 │    └── BinarySearchStrategy
 │
 ├── SortingStrategy
 │    ├── BubbleSortStrategy
 │    ├── SelectionSortStrategy
 │    └── BuiltInSortStrategy
 │
 └── StudentRepository
      └── InMemoryStudentRepository
           └── ArrayList<Student>
```

Day 23 verification:

```text
Repository tests: 16/16
Service tests:    20/20
Total:            36/36

Failures: 0
Errors:   0
Skipped:  0

BUILD SUCCESS
```

## Project Evolution

```text
Simple Console Program
        ↓
OOP
        ↓
Validation
        ↓
Custom Exceptions
        ↓
Service Layer
        ↓
Repository Pattern
        ↓
Dependency Injection
        ↓
Search Strategy
        ↓
Sorting Strategy
        ↓
File Persistence
        ↓
JUnit Testing
        ↓
Main.java Refactoring
        ↓
Repository Cleanup
```

## Learning Outcomes

### Java

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- Static vs Instance members
- ArrayList
- Generics
- StringBuilder
- Arrays utility methods

### OOP

- Encapsulation
- Abstraction
- Interfaces
- Inheritance
- Polymorphism

### Software Engineering

- Separation of Concerns
- Package Organization
- Repository Pattern
- Strategy Pattern
- Dependency Injection
- Code Reuse
- Refactoring
- Exception-based error handling

### Algorithms

- Linear Search
- Binary Search
- Bubble Sort
- Selection Sort
- Built-in sorting
- Comparable
- Comparator

### Testing

- JUnit 5
- Unit Testing
- Arrange–Act–Assert
- Assertions
- `assertThrows`
- Maven test lifecycle
- Regression testing
- Repository testing
- Service testing

### File Handling

- Reading student data
- Saving student data
- File-based persistence

## Future Improvements

- Collections deep dive and appropriate collection selection
- Generics and `Comparable` / `Comparator` improvements
- Java Streams
- Stronger input and exception handling
- File persistence improvements
- More edge-case and integration tests
- Multithreading fundamentals
- Spring Boot REST API
- MySQL / JPA / Hibernate
- DTOs and global exception handling
- API testing

## Author

**Sakthi R**

Part of **Project Titan** — a project-based journey toward becoming an industry-ready Software Engineer.
