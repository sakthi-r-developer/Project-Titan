# Student Management System

A console-based Student Management System built in Java as part of **Project Titan**.

The project started as a simple Java console application and has been progressively developed using Object-Oriented Programming, validation, custom exceptions, Repository Pattern, Strategy Pattern, Dependency Injection, file persistence, Maven, JUnit 5, and refactoring practices.

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
- Dependency Injection
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
- IntelliJ IDEA
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
                     │
              Business Logic
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
      Repository           Strategies
          │                ┌─────┴─────┐
          ▼                ▼           ▼
     Student Data       Search       Sorting
```

### Main

`Main` acts as the console/UI layer.

It is responsible for reading user actions, calling helpers and services, handling user-facing exceptions, and displaying results.

Repeated workflows were extracted into:

- `addStudent()`
- `viewStudents()`
- `searchStudent()`
- `deleteStudent()`
- `updateStudent()`
- `sortStudents()`

### InputHelper

Handles console input and input-level validation, including integer input, string input, menu choices, and update field choices.

### StudentService

Contains business logic and coordinates validation, repository operations, search strategies, sorting strategies, domain exceptions, and file loading/saving.

The service does not handle console presentation.

### Repository

`StudentRepository` defines the data-access contract and `InMemoryStudentRepository` provides the current in-memory implementation.

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

The same search workflow can use either strategy.

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

The same sorting workflow can use different algorithms.

## Repository Pattern

The service depends on the repository interface instead of directly depending on a concrete implementation:

```java
StudentRepository repository =
        new InMemoryStudentRepository();

StudentService studentService =
        new StudentService(repository);
```

This provides loose coupling, easier testing, and replaceable storage implementations.

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

| Test Class | Tests |
|---|---:|
| `InMemoryStudentRepositoryTest` | 15 |
| `StudentServiceTest` | 20 |
| **Total** | **35** |

Latest result:

```text
Tests run: 35
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

Run the test suite with:

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

## Maven

Maven is used for:

- Dependency management
- Compilation
- Test execution
- Clean builds
- Standard Java project structure

Main command:

```bash
mvn clean test
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
Refactoring
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

The result is a cleaner menu with less duplicated code while preserving the existing architecture.

The refactoring was verified with:

```text
35/35 tests passing
0 failures
0 errors
0 skipped
BUILD SUCCESS
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

### File Handling

- Reading student data
- Saving student data
- File-based persistence

## Future Improvements

- Improve input validation
- Refactor remaining repository responsibilities
- Improve file persistence design
- Add more comprehensive tests
- Add integration tests
- Database integration with MySQL
- Layered architecture improvements
- Spring Boot REST API
- Authentication and authorization
- Web-based frontend

## Author

**Sakthi R**

Part of **Project Titan** — a project-based journey toward becoming an industry-ready Software Engineer.
