# Day 10

## Completed

* Implemented Manual Selection Sort to sort students by ID.
* Created a separate `getMaxIndex()` method to find the student with the highest ID.
* Implemented a reusable `swap()` method for swapping `Student` objects.
* Compared Bubble Sort and Selection Sort implementations.
* Debugged an issue caused by comparing an ID value with an array index.

## Learned

* Selection Sort algorithm
* Finding the maximum element in the unsorted portion of the list
* Reusing helper methods (`getMaxIndex()` and `swap()`)
* Time Complexity - O(n²)
* Space Complexity - O(1)
* Selection Sort is an unstable sorting algorithm
* Difference between comparing object values and array indices

## Reflection

* Selection Sort felt more challenging than Bubble Sort because it required tracking indices correctly.
* I initially compared a student's ID with an index, which caused incorrect sorting.
* Debugging helped me understand the importance of distinguishing between an element's value and its position.
* Biggest takeaway: Small logical mistakes in algorithms can completely change the program's behavior, so understanding the algorithm is more important than memorizing the code.