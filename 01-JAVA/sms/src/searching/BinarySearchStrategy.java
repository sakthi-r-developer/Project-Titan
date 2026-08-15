package searching;

import model.Student;
import java.util.ArrayList;

public class BinarySearchStrategy implements SearchStrategy {

    @Override
    public Student search(ArrayList<Student> students, int id) {

        int start = 0;
        int end = students.size() - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (students.get(mid).getId() == id) {
                return students.get(mid);
            }

            if (id < students.get(mid).getId()) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return null;
    }
}