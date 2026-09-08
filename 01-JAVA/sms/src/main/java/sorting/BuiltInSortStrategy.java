package sorting;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class BuiltInSortStrategy implements SortingStrategy {
    public void sort(ArrayList<Student> students) {
        students.sort(Comparator.comparing(Student::getId));
    }
}
