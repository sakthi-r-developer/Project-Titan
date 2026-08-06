# Day 18

## Completed

- Learned the Strategy Design Pattern.
- Created the `SortingStrategy` interface.
- Implemented `BubbleSortStrategy`.
- Implemented `SelectionSortStrategy`.
- Implemented `BuiltInSortStrategy` using `Collections.sort()`.
- Refactored `StudentService` to delegate sorting to strategy classes instead of containing sorting algorithms.
- Applied runtime polymorphism by selecting different sorting strategies through the common interface.

## Learned

- Strategy Design Pattern
- Polymorphism
- Interface-based Behavior
- Runtime Method Dispatch
- Programming to an Interface
- Separation of Algorithms
- Extensible Design

## Reflection

Today I learned how design patterns make software more flexible and maintainable.

Previously, all sorting algorithms were implemented inside `StudentService`, making the class responsible for both business logic and sorting implementations. By introducing the Strategy Pattern, each sorting algorithm now lives in its own class implementing the same interface.

This allows the application to switch between Bubble Sort, Selection Sort, and Java's built-in sorting algorithm without modifying the service layer. I also understood how interfaces can represent behaviors, not just data access.

This was my first design pattern implementation, and it helped me understand how enterprise applications remain extensible as new features are added.   