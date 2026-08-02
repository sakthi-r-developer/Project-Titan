# Day 16

## Completed

- Introduced the Repository Layer (`StudentRepository`).
- Moved CRUD operations from `StudentService` to `StudentRepository`.
- Refactored `StudentService` to delegate data access responsibilities.
- Updated service methods to interact with the repository instead of directly managing the student list.
- Improved separation between Business Logic and Data Access.
- Better understood the Repository design pattern used in enterprise Java applications.

## Learned

- Repository Pattern
- Data Access Layer (DAL)
- Business Logic Layer (Service Layer)
- Delegation
- Encapsulation
- Layered Architecture
- Separation of Responsibilities

## Reflection

Today was one of the most challenging days so far.

Initially, I struggled to understand why some methods belong in the Service layer while others belong in the Repository layer. Through practice, I learned that the Repository should only be responsible for storing and retrieving data, while the Service should contain business rules and application logic.

I also realized that hiding the underlying data structure behind repository methods makes the application easier to maintain and extend in the future. This refactoring brought my project one step closer to real-world Java application architecture.