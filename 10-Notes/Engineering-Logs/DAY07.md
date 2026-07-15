## Day 7

### Completed

* Refactored `addStudent()` to handle validation internally.
* Moved duplicate ID validation into `StudentService`.
* Refactored `deleteStudent()` to accept Student ID instead of a Student object.
* Refactored `updateStudent()` to search and update the student within `StudentService`.
* Reduced business logic inside `Main` by delegating more responsibilities to the service layer.
* Improved overall code organization and method responsibilities.

### Learned

* Service layer should own business logic.
* Methods can return `boolean` to indicate success or failure.
* Reusing methods (`searchStudent()`) avoids duplicate code.
* Cleaner separation between UI (`Main`) and business logic (`StudentService`).

### Reflection

* I reduced the amount of logic inside `Main` compared to previous days.
* I started thinking about where a piece of code actually belongs instead of just making it work.
* My code feels cleaner and easier to maintain than before.