package searching;

import model.Student;

import java.util.ArrayList;

public interface SearchStrategy {
    Student search(ArrayList<Student> students,int id);
}
