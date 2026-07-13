# Student Management System

A console-based Student Management System built in Java as part of **Project Titan** to strengthen Object-Oriented Programming, clean code, and software engineering fundamentals.

## Features

- Add Student
- View All Students
- Search Student by ID
- Delete Student by ID
- Duplicate ID Detection
- Student Data Validation
- User-friendly Validation Messages
- Object-Oriented Design using Classes and Services

## Validation Rules

The application validates student details before adding a new student.

- Student ID must be greater than 0.
- Student Name cannot be empty.
- Student Department cannot be empty.
- Student Age must be between 16 and 100.
- Duplicate Student IDs are not allowed.

If validation fails, the application displays a specific error message instead of adding the student.

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* IntelliJ IDEA
* Git & GitHub

## Project Structure

```text
sms/
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── StudentService.java
└── README.md
```

## Architecture

**Main.java**

* Handles user interaction
* Reads user input
* Displays menu
* Delegates operations to `StudentService`

**StudentService.java**

* Manages the student list
* Contains all business logic
* Performs add, search, view, and delete operations

**Student.java**

* Represents a student object
* Stores student details

## Learning Outcomes

During this project, I learned:

* Object-Oriented Programming fundamentals
* Method extraction and code reuse
* Encapsulation
* Separation of responsibilities
* Constructors
* Difference between static and instance methods
* Returning objects from methods
* Clean code organization

## Future Improvements

* Update Student
* Input validation
* Exception handling
* File storage
* MySQL integration
* Layered architecture
* Spring Boot REST API

## Author

**Sakthi R**

Part of **Project Titan** — a long-term journey to become an industry-ready Software Engineer through project-based learning.
