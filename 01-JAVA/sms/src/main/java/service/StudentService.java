package service;

import validation.Validator;
import exceptions.DuplicateStudentException;
import exceptions.InvalidAgeException;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import repository.StudentRepository;
import searching.LinearSearchStrategy;
import searching.SearchStrategy;
import sorting.SortingStrategy;
import util.FileHandler;
import java.util.ArrayList;


public class StudentService{
    private StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public void loadStudents(){
        repository.setStudents(FileHandler.loadStudents());
    }
    public void saveStudents(){
        FileHandler.saveStudents(repository.getStudents());
    }

    public boolean addDummyStudents() throws InvalidStudentException{
        if(!repository.isStudentsEmpty()) {
            return false;
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
        return true;
    }
    public void addStudent(Student student)
            throws InvalidStudentException,
            InvalidAgeException,
            DuplicateStudentException {

        Validator.validateStudent(student, this);
        repository.addStudent(student);
    }
//    public void viewStudents() {
//        for (int i = 0; i < repository.size(); i++) {
//            System.out.println(repository.get(i));
//        }
//    }
    public ArrayList<Student> getStudents() {
        return repository.getStudents();
    }
    public boolean studentExists(int id) {
        return repository.studentExists(id);
    }
    public Student searchStudent(SearchStrategy strategy, int id)
            throws StudentNotFoundException {
        Student student = strategy.search(repository.getStudents(), id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        return student;
    }
    public void deleteStudent( int deleteId) throws StudentNotFoundException {
        repository.deleteStudent(deleteId);
    }
    public boolean updateStudent(int updateId,int choice,String value) throws StudentNotFoundException,InvalidStudentException {
        Student studentToUpdate = searchStudent(new LinearSearchStrategy(), updateId);
        switch (choice) {
            case 1:
                studentToUpdate.setName(value);
                return true;
            case 2:
                if(Validator.isNumeric(value) && Validator.isValidAge(value)) {
                    studentToUpdate.setAge(Integer.parseInt(value));
                    return true;
                }
                return false;
//                throw new InvalidAgeException("Enter according datatype ..");
            case 3:
                studentToUpdate.setDepartment(value);
                return true;
            default:
//                throw new InvalidStudentException("Invalid input");
                return false;
        }


    }
    public void sortStudents(SortingStrategy sortingStrategy) {
        sortingStrategy.sort(repository.getStudents());
    }
    public boolean isStudentsEmpty() {
        return repository.isStudentsEmpty();
    }

}
