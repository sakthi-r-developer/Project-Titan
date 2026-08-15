# Day 20

## Completed

- Implemented the Strategy Pattern for sorting.
- Created a `SortingStrategy` interface.
- Created multiple sorting strategies:
  - `BubbleSortStrategy`
  - `SelectionSortStrategy`
  - `BuiltInSortStrategy`
- Implemented the Strategy Pattern for searching.
- Created a `SearchStrategy` interface.
- Created:
  - `LinearSearchStrategy`
  - `BinarySearchStrategy`
- Updated `StudentService` to accept sorting and searching strategies.
- Removed algorithm-specific logic from `StudentService`.
- Used Dependency Injection to provide the repository to `StudentService`.
- Improved separation between:
  - User interaction
  - Business logic
  - Data access
  - Algorithms
- Improved exception handling in the new search architecture.

## Learned

### Design Patterns

- Strategy Pattern
- Repository Pattern
- Dependency Injection

### Java Concepts

- Interfaces
- Polymorphism
- Abstraction
- Composition
- Method parameters as dependencies

### Software Engineering

- Separation of Concerns
- Single Responsibility Principle
- Open/Closed Principle
- Programming to an interface
- Algorithm encapsulation
- Dependency management

## Key Concept

The Strategy Pattern allows different algorithms to be used without changing the main business logic.

For example:

```java
studentService.SortStudents(new BubbleSortStrategy());