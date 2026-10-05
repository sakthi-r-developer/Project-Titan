# Day 22 — Main.java Refactoring

## Goal

Refactor `Main.java` to reduce duplicated code and improve separation of responsibilities without changing existing project behavior.

## Changes Made

### 1. Moved Update Choice Validation to InputHelper

Created `InputHelper.readUpdateChoice(Scanner sc)` to handle:
- Reading the update field choice
- Numeric input validation
- Choice validation
- Invalid choice handling

### 2. Removed Business-Layer Console Output

`StudentService` now throws exceptions instead of printing user-facing error messages. `Main` handles console output.

This improves separation between business logic and UI logic.

### 3. Extracted `viewStudents()`

Created:

```java
private static void viewStudents(StudentService studentService)
```

Case 2 now calls:

```java
case 2:
    viewStudents(studentService);
    break;
```

### 4. Extracted `sortStudents()`

Created a reusable sorting workflow:

```java
private static void sortStudents(
        StudentService studentService,
        SortingStrategy strategy
)
```

Cases 6, 7 and 8 pass different sorting strategies.

### 5. Extracted `searchStudent()`

Created:

```java
private static void searchStudent(
        StudentService studentService,
        SearchStrategy strategy,
        Scanner sc
)
```

Case 3 uses `LinearSearchStrategy` and case 9 uses `BinarySearchStrategy`.

### 6. Extracted `addStudent()`

Created:

```java
private static void addStudent(
        StudentService studentService,
        Scanner sc
)
```

Case 1 now delegates the complete Add Student workflow to this helper.

### 7. Extracted `deleteStudent()`

Created:

```java
private static void deleteStudent(
        StudentService studentService,
        Scanner sc
)
```

Case 4 now delegates the Delete Student workflow to this helper.

### 8. Extracted `updateStudent()`

Created:

```java
private static void updateStudent(
        StudentService studentService,
        Scanner sc
)
```

Case 5 now delegates the Update Student workflow to this helper.

## Final Menu Structure

```text
0  - Add Dummy Students
1  - Add Student
2  - View Students
3  - Linear Search
4  - Delete Student
5  - Update Student
6  - Built-in Sort
7  - Bubble Sort
8  - Selection Sort
9  - Binary Search
10 - Save and Exit
```

## Architecture After Refactoring

```text
Main
 ├── Console input/output
 └── StudentService
      ├── Business logic
      ├── Validation
      └── Repository
           └── Student data

SearchStrategy
 ├── LinearSearchStrategy
 └── BinarySearchStrategy

SortingStrategy
 ├── BubbleSortStrategy
 ├── SelectionSortStrategy
 └── BuiltInSortStrategy
```

## Key Concepts Learned

- Separation of Concerns
- Code reuse
- Private helper methods
- Strategy Pattern
- Console/UI vs business logic
- Exception-based error handling
- Refactoring safely
- Regression testing

## Testing

```text
Repository Tests: 15
Service Tests:    20
Total Tests:      35

Failures: 0
Errors:   0
Skipped:  0

BUILD SUCCESS
```

Command:

```bash
mvn clean test
```

## Day 22 Outcome

`Main.java` is now cleaner and easier to maintain. Menu cases describe the requested operation while helper methods handle console workflows. Business rules remain in `StudentService`, input handling remains in `InputHelper`, and search/sorting algorithms remain behind strategy interfaces.

The refactoring was verified with **35/35 passing tests**.
