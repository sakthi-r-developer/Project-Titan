## Day 6

### Completed

* Added Update Student feature to the SMS project.
* Added menu option to update an existing student.
* Reused searchStudent() to find the student before updating.
* Added setter methods (setName(), setAge(), setDepartment()) to modify student details.
* Kept id immutable by not creating a setId() method.
* Improved validation flow while updating student records.

### Learned

* Object mutation
* Setter methods
* Mutable vs immutable fields
* Reusing business logic instead of duplicating code
* Why object identity should be preserved


### Reflection

* Implementing the update feature was more challenging than expected.
* Initially mixed UI logic with business logic, but realized the importance of separating responsibilities.
* Understood that updating an object is better than deleting and creating a new one because the object's identity remains the same.
* Need to improve validation during updates and avoid potential NullPointerExceptions.