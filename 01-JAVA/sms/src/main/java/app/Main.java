package app;

import exceptions.DuplicateStudentException;
import exceptions.InvalidAgeException;
import exceptions.InvalidChoiceException;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
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
import validation.Validator;
import java.io.IOException;
import java.util.Scanner;




class Main {


        static void main(String[] args)  {
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
                            if (studentService.addDummyStudents()) {
                                System.out.println("Add Student Successful");
                            } else {
                                System.out.println("Dummy students already loaded");
                            }
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
                            studentService.addStudent(student);
                            System.out.println("Add Student Successful");
                        }
                        catch (InvalidAgeException e) {
                            System.out.println(e.getMessage());
                        }
                        catch (DuplicateStudentException e) {
                            System.out.println(e.getMessage());
                        }
                        catch (InvalidStudentException e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    case 2:
                        if(studentService.isStudentsEmpty()) {
                                System.out.println("no students found");

                        }
                        else {
                            for (Student s : studentService.getStudents()) {
                                System.out.println(s);
                            }
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


                        int choice = InputHelper.readUpdateChoice(sc);
                        sc.nextLine();
                        String value=InputHelper.readString(sc,"Enter New Value :");
                        try {
                            studentService.updateStudent(updateId, choice, value);
                            System.out.println("Student updated successfully");
                        }
                        catch (StudentNotFoundException | InvalidStudentException e ) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            studentService.sortStudents(new BuiltInSortStrategy());
                            for (Student s : studentService.getStudents()) {
                                System.out.println(s);
                            }
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 7:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");
                        }
                        else {
                            studentService.sortStudents(new BubbleSortStrategy());
                            for (Student s : studentService.getStudents()) {
                                System.out.println(s);
                            }
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 8:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            studentService.sortStudents(new SelectionSortStrategy());
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 9:
                        if (studentService.isStudentsEmpty()) {
                            System.out.println("no students found");
                        } else {
                            int binarySearchId =
                                    InputHelper.readInt(sc, "Enter searchId :");

                            sc.nextLine();

                            try {
                                Student foundBSStudent =
                                        studentService.searchStudent(
                                                new BinarySearchStrategy(),
                                                binarySearchId
                                        );

                                System.out.println(foundBSStudent);

                            } catch (StudentNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;


                    default:
                        break;

                }

            }

        }
    }
