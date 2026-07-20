# Day 12

## Completed

* Added `addDummyStudents()` to quickly populate the application with test data.
* Implemented `isNumeric()` using `try-catch` and `Integer.parseInt()` to validate numeric input.
* Replaced direct `Scanner.nextInt()` usage with string input followed by validation to prevent program crashes.
* Added input validation loops for Student ID, Age, Update ID, Delete ID, Search ID, Binary Search ID, and Update Choice.
* Improved the update feature by validating numeric age input before updating.
* Added menu choice validation helper (`isValidChoice()`).
* Continued improving the robustness of the application against invalid user input.

## Learned

* Exception Handling (`try-catch`)
* `NumberFormatException`
* Input validation using `Integer.parseInt()`
* Defensive programming
* Why applications should recover from invalid user input instead of terminating
* Separating validation logic into service methods

## Reflection

* Today was my first experience using exception handling in a real project.
* I learned that exceptions are not only for fixing crashes—they also improve the user experience.
* Writing validation repeatedly made me realize there is duplicated code that can be refactored into reusable helper methods later.
* Biggest takeaway: A program that handles incorrect input gracefully is much more reliable than one that only works for perfect input.