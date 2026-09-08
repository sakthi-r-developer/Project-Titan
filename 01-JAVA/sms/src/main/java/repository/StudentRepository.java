package repository;

import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;

import java.util.ArrayList;

public interface StudentRepository {

    ArrayList<Student> getStudents();

    void setStudents(ArrayList<Student> students);

    void addStudent(Student student) throws InvalidStudentException;

    Student searchStudent(int id) throws StudentNotFoundException;

    void deleteStudent(int id) throws StudentNotFoundException;

    boolean studentExists(int id);

    boolean isStudentsEmpty();

    int size();

    Student get(int index);

    void set(int index, Student student);

    void swap(int index1, int index2);

}