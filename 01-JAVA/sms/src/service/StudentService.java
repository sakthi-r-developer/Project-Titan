package service;

import Validation.Validator;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.Comparator;

//import static repository.StudentRepository.students;

//import static repository.StudentRepository.students;

public class StudentService{
//    private static ArrayList<Student> students;
static StudentRepository studentRepository;
//    private static ArrayList<Student> students;
    public StudentService() {
        studentRepository = new StudentRepository();
    }
    public static ArrayList<Student> getStudents(){
        return studentRepository.getStudents();
    }
    public static void setStudents(ArrayList<Student> students){
        StudentRepository.setStudents(students);
    }

    public void addDummyStudents() throws InvalidStudentException{

        if(!studentRepository.getStudents().isEmpty()) {
            System.out.println("Dummy students already loaded");
            return;
        }

        addStudent(new Student(101, "Sakthi", 19, "IT"));
        addStudent(new Student(102, "Arun", 20, "CSE"));
        addStudent(new Student(103, "Vijay", 18, "ECE"));
        addStudent(new Student(104, "Karthik", 21, "EEE"));
        addStudent(new Student(105, "Rahul", 19, "MECH"));
        addStudent(new Student(106, "Ajay", 20, "IT"));
        addStudent(new Student(107, "Surya", 18, "CSE"));
        addStudent(new Student(108, "Praveen", 22, "ECE"));
        addStudent(new Student(109, "Manoj", 19, "EEE"));
        addStudent(new Student(110, "Hari", 20, "MECH"));
    }

    public void addStudent(Student student) throws InvalidStudentException{
        studentRepository.addStudent(student);

    }
    public void viewStudents() {
        for (Student student : studentRepository.getStudents()) {
            System.out.println(student);
        }
    }
    public static boolean studentExists(int id) {
//        for (Student student : students) {
//            if (student.getId() == id) {
//                return true;
//            }
//        }
//        return false;
        return studentRepository.studentExists(id);
    }

    public static Student searchStudent(int searchId) throws StudentNotFoundException {
//        int count=0;
//        for (Student student: students) {
//            count++;
//            if(student.getId() == searchId) {
//                System.out.println(count+" Comparisons");
//                return student;
//            }
//        }
//        throw new StudentNotFoundException("Student not found");
        return studentRepository.searchStudent(searchId);
//      return null;

    }
    public Student binarySearchStudent(int searchId) {
        int start=0;
        int end=studentRepository.getStudents().size()-1;
        int count=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            count++;
            if(searchId==studentRepository.getStudents().get(mid).getId()) {
                System.out.println(count+" comparisons");
                return studentRepository.getStudents().get(mid);
            }
            else if(searchId<studentRepository.getStudents().get(mid).getId()) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }

        return null;
    }
    public void deleteStudent( int deleteId) throws StudentNotFoundException {
//        Student student = searchStudent(deleteId);
        studentRepository.deleteStudent(deleteId);
    }

    public boolean updateStudent(int updateId,int choice,String value) throws StudentNotFoundException {
        Student studentToUpdate = searchStudent(updateId);
        boolean result = false;
        switch (choice) {
            case 1:
                studentToUpdate.setName(value);
                result = true;
                break;
            case 2:
                if(Validator.isNumeric(value) && Validator.isValidAge(value)) {
                    studentToUpdate.setAge(Integer.parseInt(value));
                    result = true;
                }
                else{
                    System.out.println("Enter according datatype ..");
                }
                break;
            case 3:
                studentToUpdate.setDepartment(value);
                result = true;
                break;
            default:
                System.out.println("Invalid input");
                result = false;
                break;
        }
        return result;

    }
    public void selectionSortStudents(){
        int n =studentRepository.getStudents().size();
        for(int i=0;i<n-1;i++){
            int last=n-i-1;
            int max=getMax(0,last);
            swap(max,last);
        }
        viewStudents();
    }
    private int getMax(int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(studentRepository.getStudents().get(i).getId()>studentRepository.getStudents().get(max).getId()){
                max=i;
            }
//            max=Math.max(max,(students.get(i)).getId());
        }
        return max;
    }
    private void swap(int a,int b){
        Student temp = studentRepository.getStudents().get(a);
        studentRepository.getStudents().set(a, studentRepository.getStudents().get(b));
        studentRepository.getStudents().set(b, temp);
    }
    public void bubbleSortStudents() {
        int n = studentRepository.getStudents().size();
        Student temp;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if ((studentRepository.getStudents().get(j)).getId() > (studentRepository.getStudents().get(j + 1)).getId()) {

                    // Swap
                    temp = studentRepository.getStudents().get(j);
                    studentRepository.getStudents().set(j, studentRepository.getStudents().get(j + 1));
                    studentRepository.getStudents().set(j + 1, temp);

                    swapped = true;
                }
            }

            // Already sorted
            if (!swapped) break;
        }


    }

    public void sortStudentsById() {
        studentRepository.getStudents().sort(Comparator.comparing(Student::getId));

    }

    public boolean isStudentsEmpty() {
//        return students.isEmpty();
        return studentRepository.isStudentsEmpty();
    }

}
