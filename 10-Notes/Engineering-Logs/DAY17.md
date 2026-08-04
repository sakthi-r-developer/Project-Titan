# Day 17

## Completed

- Introduced the `StudentRepository` interface.
- Created `InMemoryStudentRepository` implementing the interface.
- Refactored `StudentService` to depend on the `StudentRepository` interface instead of a concrete implementation.
- Implemented manual Dependency Injection by passing the repository from `Main` to `StudentService`.
- Reduced coupling between the Service and Repository layers.
- Improved the project's flexibility for future repository implementations.

## Learned

- Interfaces
- Programming to an Interface
- Dependency Injection (Manual)
- Loose Coupling
- Dependency Inversion Principle (DIP)
- Interface-based Design

## Reflection

Today I learned one of the most important software engineering concepts: **Dependency Injection**.

Initially, `StudentService` created its own repository, making it tightly coupled to `InMemoryStudentRepository`. After refactoring, the repository is now created in `Main` and injected into `StudentService`, allowing the service layer to remain independent of the repository implementation.

This design makes the project much more flexible. In the future, I can replace the in-memory repository with a file-based or MySQL repository by changing only the object created in `Main`, without modifying the business logic.

Today wasn't about adding features—it was about writing cleaner, more maintainable, and extensible code.