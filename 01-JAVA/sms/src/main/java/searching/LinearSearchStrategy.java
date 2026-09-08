package searching;

import model.Student;
import java.util.ArrayList;

public class LinearSearchStrategy implements SearchStrategy {

    @Override
    public Student search(ArrayList<Student> students, int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}
