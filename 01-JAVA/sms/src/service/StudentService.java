package service;

import Validation.Validator;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import sorting.BubbleSortStrategy;
import sorting.SelectionSortStrategy;
import sorting.SortingStrategy;
import util.FileHandler;

//import static repository.StudentRepository.students;

//import static repository.StudentRepository.students;

public class StudentService{
//    private static ArrayList<Student> students;
    private StudentRepository repository;
    private SortingStrategy sortingStrategy;
//    private static ArrayList<Student> students;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public void loadStudents(){
        repository.setStudents(FileHandler.loadStudents());
    }
    public void saveStudents(){
        FileHandler.saveStudents(repository.getStudents());
    }

    public void addDummyStudents() throws InvalidStudentException{

        if(!repository.isStudentsEmpty()) {
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
        repository.addStudent(student);

    }
    public void viewStudents() {
        for (int i = 0; i < repository.size(); i++) {
            System.out.println(repository.get(i));
        }
    }
    public boolean studentExists(int id) {
        return repository.studentExists(id);
    }

    public Student searchStudent(int searchId) throws StudentNotFoundException {

        return repository.searchStudent(searchId);


    }
    public Student binarySearchStudent(int searchId) {
        int n= repository.size();
        int start=0;
        int end=n-1;
        int count=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            count++;
            if(searchId== repository.get(mid).getId()) {
                System.out.println(count+" comparisons");
                return repository.get(mid);
            }
            else if(searchId< repository.get(mid).getId()) {
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
        repository.deleteStudent(deleteId);
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
        sortingStrategy = new SelectionSortStrategy();
        sortingStrategy.sort(repository.getStudents());
        viewStudents();
    }


    public void bubbleSortStudents() {
        sortingStrategy = new BubbleSortStrategy();
        sortingStrategy.sort(repository.getStudents());
        viewStudents();

    }

    public void sortStudentsById() {

        sortingStrategy = new SelectionSortStrategy();
        sortingStrategy.sort(repository.getStudents());
    }

    public boolean isStudentsEmpty() {
//        return students.isEmpty();
        return repository.isStudentsEmpty();
    }

}
