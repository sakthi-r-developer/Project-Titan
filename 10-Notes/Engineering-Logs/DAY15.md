# Day 15

## Completed

- Implemented file handling using `FileReader` and `FileWriter`.
- Added `BufferedReader` and `BufferedWriter` for efficient file operations.
- Created a `FileHandler` utility class.
- Implemented `saveStudents()` to store student records in `students.txt`.
- Implemented `loadStudents()` to restore student records when the application starts.
- Added automatic data persistence (load on startup, save on exit).
- Used `try-with-resources` for safe file writing.
- Ignored malformed records while reading student data.
- Connected `StudentService` with file handling using `getStudents()` and `setStudents()`.

## Learned

- Java File Handling
- FileReader & FileWriter
- BufferedReader & BufferedWriter
- Try-with-Resources
- Reading & Writing Text Files
- Data Persistence
- File Parsing
- Resource Management

## Reflection

Today I added permanent storage to my Student Management System.

Previously, all student records were lost whenever the program was closed. By implementing file handling, the application now automatically loads existing student data at startup and saves all changes before exiting.

I also learned how to use Java's file I/O classes effectively and understood the importance of proper resource management using try-with-resources.

This was my first experience building an application that can persist data without using a database, making the project feel much closer to a real-world application.