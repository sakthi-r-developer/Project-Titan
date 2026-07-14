## Day 5

### Completed

* Added student validation before insertion.
* Implemented validation for ID, Name, Age, and Department.
* Prevented invalid student records from being added.
* Displayed specific validation messages for invalid input.
* Reused a single Student object instead of creating multiple objects.
* Simplified isStudentsEmpty() using ArrayList.isEmpty().

### Learned

* Input validation
* Business rules in the service layer
* Returning meaningful validation messages
* Reusing objects to avoid unnecessary object creation
* Why duplicate validation logic should be avoided

### Reflection

* Initially struggled to design the validation flow.
* Realized that user-friendly error messages make the application much better.
* Started thinking more about software design instead of only making the code work.
* Biggest takeaway: Good code doesn't just solve the problem—it also guides the user when something goes wrong.