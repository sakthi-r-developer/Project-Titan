package service;

import Validation.Validator;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentService{
    private static ArrayList<Student> students;
    public StudentService() {
        if (students == null) {
            students = new ArrayList<>();
        }
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static void setStudents(ArrayList<Student> students){
        StudentService.students = students;
    }

    public void addDummyStudents() throws InvalidStudentException{

        if(!students.isEmpty()) {
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
    public Student binarySearchStudent(int searchId) {
        int start=0;
        int end=students.size()-1;
        int count=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            count++;
            if(searchId==students.get(mid).getId()) {
                System.out.println(count+" comparisons");
                return students.get(mid);
            }
            else if(searchId<students.get(mid).getId()) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }

        return null;
    }
    public void deleteStudent( int deleteId) throws StudentNotFoundException {
        Student student = searchStudent(deleteId);
        students.remove(student);
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
        int n =students.size();
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
            if(students.get(i).getId()>students.get(max).getId()){
                max=i;
            }
//            max=Math.max(max,(students.get(i)).getId());
        }
        return max;
    }
    private void swap(int a,int b){
        Student temp = students.get(a);
        students.set(a, students.get(b));
        students.set(b, temp);
    }
    public void bubbleSortStudents() {
        int n = students.size();
        Student temp;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if ((students.get(j)).getId() > (students.get(j + 1)).getId()) {

                    // Swap
                    temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);

                    swapped = true;
                }
            }

            // Already sorted
            if (!swapped) break;
        }


    }

    public void sortStudentsById() {
        students.sort(Comparator.comparing(Student::getId));

    }

    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }

}
