package sorting;

import model.Student;
import service.StudentService;

import java.util.ArrayList;

public class BubbleSortStrategy implements SortingStrategy {
    public void sort(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if ((students.get(j)).getId() > (students.get(j + 1)).getId()) {

                    swap(students,j,j+1);

                    swapped = true;
                }
            }

            // Already sorted
            if (!swapped) break;
        }
    }
    public void swap(ArrayList<Student> students,int a,int b){
        Student temp = students.get(a);
        students.set(a, students.get(b));
        students.set(b, temp);
    }
}
