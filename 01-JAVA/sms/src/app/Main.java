package app;

import Validation.Validator;
import exceptions.*;
import model.Student;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import searching.BinarySearchStrategy;
import searching.LinearSearchStrategy;
import service.StudentService;
import sorting.BubbleSortStrategy;
import sorting.BuiltInSortStrategy;
import sorting.SelectionSortStrategy;
import util.InputHelper;

import java.io.IOException;
import java.util.Scanner;

import static util.FileHandler.loadStudents;
import static util.FileHandler.saveStudents;


class Main {
        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


        public static void main(String[] args) throws StudentNotFoundException, InvalidChoiceException, IOException {
            StudentRepository repository = new InMemoryStudentRepository();
            StudentService studentService = new StudentService(repository);
            Scanner sc = new Scanner(System.in);
            studentService.loadStudents();
            while (true) {
                int option = InputHelper.readMenuChoice(sc);
                if(option==10) {
                    studentService.saveStudents();
                    break;
                }
                switch (option) {
                    case 0:
                        try {
                            studentService.addDummyStudents();
                            System.out.println("Add Student Successful");
                        }
                        catch (InvalidStudentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 1:
                        int id=InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();
                        String name= InputHelper.readString(sc,"Enter Student Name:");
                        int age=InputHelper.readInt(sc,"Enter Student Age:");

                        sc.nextLine();
                        String department=InputHelper.readString(sc,"Enter Student Department:");
                        Student student = new Student(id, name, age, department);

                        try{
                            Validator.validateStudent(student,studentService);
                            studentService.addStudent(student);
                            System.out.println("Add Student Successful");
                        }
                        catch (InvalidStudentException e) {
                            System.out.println(e.getMessage());
                        }
                        catch (InvalidAgeException e) {
                            System.out.println(e.getMessage());
                        }
                        catch (DuplicateStudentException e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    case 2:
                        if(studentService.isStudentsEmpty()) {
                                System.out.println("no students found");

                        }
                        else {
                            studentService.viewStudents();
                            System.out.println("Student view successfully");
                        }
                        break;
                    case 3:
                        int searchId = InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();
                        try{
                            Student searchStudent =
                                    studentService.searchStudent(
                                            new LinearSearchStrategy(),
                                            searchId
                                    );
                            System.out.println(searchStudent);
                            System.out.println("Student found successfully");
                        }
                        catch(StudentNotFoundException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        int deleteId = InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();
                        try{
                            studentService.deleteStudent(deleteId);
                            System.out.println("Student delete successfully");
                        }
                        catch(StudentNotFoundException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        int updateId = InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();

                        System.out.println("Choose Field: \n  1.Name \n 2.Age \n 3.Department \n");

                        int choice = -1;
                        while(choice==-1) {
                            System.out.println("Enter Choice: ");
                            String choiceStr = sc.next();
                            try {
                                if (Validator.isNumeric(choiceStr)) {
                                    choice = Integer.parseInt(choiceStr);
                                    if (Validator.isValidChoice(choice))
                                        System.out.println("Valid Choice.");
                                }
                            }
                            catch (InvalidChoiceException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        sc.nextLine();
                        String value=InputHelper.readString(sc,"Enter New Value :");
                        if(studentService.updateStudent(updateId,choice,value)){
                            System.out.println("Student updated successfully");
                        }
                        else{
                            System.out.println("Student not updated successfully");
                        }
                        break;
                    case 6:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            studentService.SortStudents(new BuiltInSortStrategy());
                            studentService.viewStudents();
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 7:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");
                        }
                        else {
                            studentService.SortStudents(new BubbleSortStrategy());
                            studentService.viewStudents();
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 8:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            studentService.SortStudents(new SelectionSortStrategy());
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 9:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");
                        }
                        else{
                            int binarySearchId = InputHelper.readInt(sc,"Enter searchId :");
                            sc.nextLine();
                            Student foundBSStudent=
                                    studentService.searchStudent(
                                            new BinarySearchStrategy(),
                                            binarySearchId
                                    );
                            if(foundBSStudent!=null) {
                                System.out.println(foundBSStudent);
                            }
                            else{
                                System.out.println("Student not found");
                            }
                        }
                        break;


                    default:
                        break;

                }

            }

        }
    }
