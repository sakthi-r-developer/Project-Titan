package repository;

import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;

import java.util.ArrayList;


public class InMemoryStudentRepository implements StudentRepository {
    private ArrayList<Student> students;
    public InMemoryStudentRepository() {
        students = new ArrayList<>();
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }
    public int size(){
        return students.size();
    }
    public Student get(int index){
        return students.get(index);
    }
    public void set(int index, Student student){
        students.set(index, student);
    }
    public void swap(int index1, int index2){
        Student temp = students.get(index1);
        students.set(index1, students.get(index2));
        students.set(index2, temp);
    }

    public void addStudent(Student student) throws InvalidStudentException{

        students.add(student);

    }
    public boolean studentExists(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public void deleteStudent(int id)
            throws StudentNotFoundException {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {
                students.remove(i);
                return;
            }
        }

        throw new StudentNotFoundException("Student not found");
    }

    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }

}
