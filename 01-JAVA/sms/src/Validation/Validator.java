package Validation;

import exceptions.*;
import model.Student;
import service.StudentService;

public class Validator {
    public static boolean isValidAge(String value){
        int age=Integer.parseInt(value);
        if(age<16 || age>100) {
           return false;
        }
        return true;
    }
    public static boolean isNumeric(String id){
        try {
            Integer.parseInt(id);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public static boolean isValidChoice(int choice) throws InvalidChoiceException {
        if(choice <=10 &&  choice >=0){
            return true;
        }
        else{
            throw new InvalidChoiceException("Invalid Choice");
        }
    }
    public static void validateStudent(Student student) throws InvalidStudentException, StudentNotFoundException, InvalidAgeException, DuplicateStudentException {
        if (student.getId() <= 0) {
            throw new InvalidStudentException("Student ID must be greater than 0.");
        }

        if (StudentService.studentExists(student.getId())) {
            throw new DuplicateStudentException("Student already exists.");
        }

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new InvalidStudentException("Student name cannot be empty.");
        }

        if (student.getDepartment() == null || student.getDepartment().trim().isEmpty()) {
            throw new InvalidStudentException("Department cannot be empty.");
        }

        if (student.getAge() < 16 || student.getAge() > 100) {
            throw new InvalidAgeException("Invalid age.");
        }
    }

}
