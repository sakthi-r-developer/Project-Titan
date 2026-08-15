package service;

import Validation.Validator;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import repository.StudentRepository;
import searching.LinearSearchStrategy;
import searching.SearchStrategy;
import sorting.SortingStrategy;
import util.FileHandler;

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
    public boolean updateStudent(int updateId,int choice,String value) throws StudentNotFoundException {
        Student studentToUpdate = searchStudent(new LinearSearchStrategy(), updateId);
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
    public void SortStudents(SortingStrategy sortingStrategy) {
        sortingStrategy.sort(repository.getStudents());
        viewStudents();
    }
    public boolean isStudentsEmpty() {
        return repository.isStudentsEmpty();
    }

}
