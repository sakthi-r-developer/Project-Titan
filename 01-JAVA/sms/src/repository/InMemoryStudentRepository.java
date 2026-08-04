package repository;

import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class InMemoryStudentRepository implements StudentRepository {
    private static ArrayList<Student> students;
    public InMemoryStudentRepository() {
        if (students == null) {
            students = new ArrayList<>();
        }
    }
//    public static ArrayList<Student> getStudents(){
//        return students;
//    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students){
        InMemoryStudentRepository.students = students;
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
    public void sortById(){
        students.sort(Comparator.comparing(Student::getId));
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

    public Student searchStudent(int searchId) throws StudentNotFoundException {
        int count=0;
        for (Student student: students) {
            count++;
            if(student.getId() == searchId) {
                System.out.println(count+" Comparisons");
                return student;
            }
        }
        throw new StudentNotFoundException("Student not found");
//      return null;

    }

    public void deleteStudent( int deleteId) throws StudentNotFoundException {
        Student student = searchStudent(deleteId);
        students.remove(student);
    }
    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }

}
