# Project Titan – Day 03

**Date:** 11 Jul 2026

### Built

* Added **Delete Student** feature.
* Prevented duplicate Student IDs.
* Refactored code into reusable methods (`add`, `view`, `search`, `delete`).
* Reused `searchStudent()` across multiple features to eliminate duplicate logic.

### Learned

* Returning an object (`Student`) is more reusable than returning a boolean.
* Avoid code duplication by creating a single source of truth.
* Helper methods used only inside a class should be `private`.

### Problem

* Initially wrote separate search logic for delete and duplicate validation.
* Forgot to actually delete the student after finding it.

### Fixed

* Centralized all search operations into `searchStudent()`.
* Used `deleteStudent()` method correctly.
* Improved variable names (`existingStudent`, `foundStudent`, `studentToDelete`).

### Next

* Learn encapsulation (`private`, getters, setters).
* Start separating business logic from `Main.java`.

**Time:** ~5 hours


