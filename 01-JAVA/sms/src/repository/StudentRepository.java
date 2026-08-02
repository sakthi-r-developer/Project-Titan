package repository;

import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import service.StudentService;

import java.util.ArrayList;

public class StudentRepository {
    private static ArrayList<Student> students;
    public StudentRepository() {
        if (students == null) {
            students = new ArrayList<>();
        }
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static void setStudents(ArrayList<Student> students){
        StudentRepository.students = students;
    }


    public void addStudent(Student student) throws InvalidStudentException{

        students.add(student);

    }
    public void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public static boolean studentExists(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static Student searchStudent(int searchId) throws StudentNotFoundException {
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
//    public Student binarySearchStudent(int searchId) {
//        int start=0;
//        int end=students.size()-1;
//        int count=0;
//        while(start<=end) {
//            int mid=start+(end-start)/2;
//            count++;
//            if(searchId==students.get(mid).getId()) {
//                System.out.println(count+" comparisons");
//                return students.get(mid);
//            }
//            else if(searchId<students.get(mid).getId()) {
//                end=mid-1;
//            }
//            else {
//                start=mid+1;
//            }
//        }
//
//        return null;
//    }
    public void deleteStudent( int deleteId) throws StudentNotFoundException {
        Student student = searchStudent(deleteId);
        students.remove(student);
    }
    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }

}
