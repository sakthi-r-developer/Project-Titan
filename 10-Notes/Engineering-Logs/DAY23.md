# Day 23 — Repository Cleanup

**Project:** Project Titan — Student Management System  
**Phase:** Java / Architecture / Testing  
**Status:** ✅ Complete

## Objective

Clean up the Repository layer so that it has one clear responsibility:

> **The Repository manages student data. It does not implement search algorithms, sorting algorithms, or console presentation.**

The goal was to improve separation of concerns without changing the application's existing behavior.

---

## Starting Point

Before Day 23, the project had already introduced:

- `StudentService`
- `StudentRepository`
- `InMemoryStudentRepository`
- `SearchStrategy`
- `SortingStrategy`
- Constructor Dependency Injection
- Custom exceptions
- JUnit tests

The Repository still contained responsibilities that overlapped with the Strategy layer, especially student searching and sorting.

---

## Tasks Completed

### 1. Reviewed Repository responsibilities

Reviewed:

- `StudentRepository`
- `InMemoryStudentRepository`
- `StudentService`
- Repository tests

Separated data-access responsibilities from algorithm responsibilities.

### 2. Removed Repository search responsibility

Removed:

```java
Student searchStudent(int id);
```

from the Repository contract and implementation.

The old Repository search implementation was also removed.

Search is now handled through:

```text
SearchStrategy
├── LinearSearchStrategy
└── BinarySearchStrategy
```

`StudentService` supplies the repository's student list to the selected strategy.

Conceptually:

```text
StudentService
      ↓
SearchStrategy
      ↓
repository.getStudents()
      ↓
ArrayList<Student>
```

This avoids having the Repository decide how a search should be performed.

### 3. Kept delete responsibility in Repository

A question that came up during the refactor was:

> If `searchStudent()` is removed, how will `deleteStudent()` find a student?

The answer is that `deleteStudent()` is a Repository data operation and can locate the record it needs to remove directly.

Current behavior:

```java
public void deleteStudent(int id)
        throws StudentNotFoundException {

    for (int i = 0; i < students.size(); i++) {

        if (students.get(i).getId() == id) {
            students.remove(i);
            return;
        }
    }

    throw new StudentNotFoundException("Student not found");
}
```

The Repository does not need to call the separate SearchStrategy just to delete a stored record.

### 4. Removed Repository sorting responsibility

Removed:

```java
void sortById();
```

from the Repository contract.

Sorting remains the responsibility of:

```text
SortingStrategy
├── BubbleSortStrategy
├── SelectionSortStrategy
└── BuiltInSortStrategy
```

This keeps algorithms separate from data storage.

### 5. Removed Repository console output

The Repository contains no user-facing `System.out.println()` calls.

This keeps the Repository independent from the CLI.

The Repository can therefore be reused by:

- Console applications
- Tests
- Spring Boot REST APIs
- Other future UI layers

### 6. Cleaned unused code

Removed the unused `Comparator` import from `InMemoryStudentRepository`.

The old commented-out `searchStudent()` implementation was also removed from the production class.

---

## Final Repository Responsibilities

`StudentRepository` now focuses on data operations:

```text
getStudents()
setStudents()
addStudent()
deleteStudent()
studentExists()
isStudentsEmpty()
size()
get()
set()
swap()
```

The Repository does not:

```text
❌ Perform linear search
❌ Perform binary search
❌ Perform sorting algorithms
❌ Print console messages
❌ Handle UI interaction
```

---

## Final Architecture

```text
                         Main
                          │
                          ▼
                   StudentService
                  /       |                         /        |                         ▼         ▼          ▼
          Repository    Search     Sorting
              │        Strategy   Strategy
              │          │           │
              ▼          ▼           ▼
       Student Data   Linear /    Bubble /
                      Binary      Selection /
                                  Built-in
```

More specifically:

```text
StudentService
│
├── StudentRepository
│      └── InMemoryStudentRepository
│             └── ArrayList<Student>
│
├── SearchStrategy
│      ├── LinearSearchStrategy
│      └── BinarySearchStrategy
│
└── SortingStrategy
       ├── BubbleSortStrategy
       ├── SelectionSortStrategy
       └── BuiltInSortStrategy
```

---

## Repository Tests

The Repository test suite was expanded to cover the data-access contract.

### Add

- Add one student
- Add multiple students
- Verify repository size increases
- Verify added student can be retrieved

### Delete

- Delete existing student
- Delete nonexistent student
- Verify repository size decreases

### Existence

- Existing student ID returns `true`
- Nonexistent student ID returns `false`

### Empty state

- New repository is empty
- Repository becomes non-empty after adding a student

### Size

- New repository has size `0`
- Correct size after adding students
- Correct size after deleting a student

### Collection access

- `get(index)` returns the correct student
- `set(index, student)` replaces a student
- `getStudents()` returns the stored collection
- `setStudents()` replaces the stored collection

### Swap

- Two students can be swapped
- Student positions are correctly changed

Repository search tests were removed because search is no longer a Repository responsibility.

---

## Test Result

Day 23 finished with:

```text
Running repository.InMemoryStudentRepositoryTest
Tests run: 16
Failures: 0
Errors: 0
Skipped: 0

Running service.StudentServiceTest
Tests run: 20
Failures: 0
Errors: 0
Skipped: 0

Total:
Tests run: 36
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

Command used:

```bash
mvn clean test
```

---

## Key Concepts Learned

### Separation of Concerns

Different classes should have different responsibilities.

```text
Repository
→ manages data

Strategy
→ performs algorithms

Service
→ coordinates application/business logic

Main
→ handles console interaction
```

### Repository Pattern

The application works through:

```java
StudentRepository
```

instead of tightly coupling the service to:

```java
InMemoryStudentRepository
```

### Strategy Pattern

Search and sorting algorithms can change without changing the Repository.

### Refactoring with Tests

The existing test suite acted as a safety net.

The Repository was refactored while verifying that the rest of the application continued to work.

---

## Day 23 Definition of Done

- [x] Repository responsibilities reviewed
- [x] `searchStudent()` removed from Repository
- [x] Old Repository search implementation removed
- [x] `deleteStudent()` remains functional
- [x] `sortById()` removed from Repository
- [x] Sorting remains in `SortingStrategy`
- [x] Repository console output removed
- [x] Repository tests updated
- [x] Repository tests passing
- [x] Full Maven test suite passing
- [x] Git commit completed
- [x] Git push completed

---

## Final Lesson

The most important lesson from Day 23:

> **A Repository manages data. It should not decide how the application searches, sorts, validates, or displays that data.**

This separation will make the future transition from the console application to a Spring Boot backend much easier.

---

## Next Step

**Day 24 — Collections Deep Dive**

Focus:

- `List`
- `ArrayList`
- `LinkedList`
- `Set`
- `HashSet`
- `Map`
- `HashMap`
- Choosing the right collection based on the problem
- Applying a collection improvement to Project Titan only when it is justified
