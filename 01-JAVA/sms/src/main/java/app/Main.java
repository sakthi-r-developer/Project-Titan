package app;

import exceptions.DuplicateStudentException;
import exceptions.InvalidAgeException;
import exceptions.InvalidStudentException;
import exceptions.StudentNotFoundException;
import model.Student;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import searching.BinarySearchStrategy;
import searching.LinearSearchStrategy;
import searching.SearchStrategy;
import service.StudentService;
import sorting.BubbleSortStrategy;
import sorting.BuiltInSortStrategy;
import sorting.SelectionSortStrategy;
import sorting.SortingStrategy;
import util.InputHelper;

import java.util.Scanner;

class Main {

    static void main(String[] args) {

        StudentRepository repository =
                new InMemoryStudentRepository();

        StudentService studentService =
                new StudentService(repository);

        Scanner sc = new Scanner(System.in);

        studentService.loadStudents();

        while (true) {

            int option =
                    InputHelper.readMenuChoice(sc);

            if (option == 10) {
                studentService.saveStudents();
                break;
            }

            switch (option) {

                case 0:
                    try {
                        if (studentService.addDummyStudents()) {
                            System.out.println("Add Student Successful");
                        } else {
                            System.out.println(
                                    "Dummy students already loaded"
                            );
                        }

                    } catch (InvalidStudentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 1:
                    addStudent(studentService, sc);
                    break;

                case 2:
                    viewStudents(studentService);
                    break;

                case 3:
                    searchStudent(
                            studentService,
                            new LinearSearchStrategy(),
                            sc
                    );
                    break;

                case 4:
                    deleteStudent(studentService, sc);
                    break;

                case 5:
                    updateStudent(studentService, sc);
                    break;

                case 6:
                    sortStudents(
                            studentService,
                            new BuiltInSortStrategy()
                    );
                    break;

                case 7:
                    sortStudents(
                            studentService,
                            new BubbleSortStrategy()
                    );
                    break;

                case 8:
                    sortStudents(
                            studentService,
                            new SelectionSortStrategy()
                    );
                    break;

                case 9:
                    searchStudent(
                            studentService,
                            new BinarySearchStrategy(),
                            sc
                    );
                    break;

                default:
                    break;
            }
        }
    }

    private static void addStudent(
            StudentService studentService,
            Scanner sc
    ) {

        int id =
                InputHelper.readInt(
                        sc,
                        "Enter Student ID:"
                );

        sc.nextLine();

        String name =
                InputHelper.readString(
                        sc,
                        "Enter Student Name:"
                );

        int age =
                InputHelper.readInt(
                        sc,
                        "Enter Student Age:"
                );

        sc.nextLine();

        String department =
                InputHelper.readString(
                        sc,
                        "Enter Student Department:"
                );

        Student student =
                new Student(
                        id,
                        name,
                        age,
                        department
                );

        try {

            studentService.addStudent(student);

            System.out.println(
                    "Add Student Successful"
            );

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());

        } catch (DuplicateStudentException e) {

            System.out.println(e.getMessage());

        } catch (InvalidStudentException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void viewStudents(
            StudentService studentService
    ) {

        if (studentService.isStudentsEmpty()) {
            System.out.println("No students found");
            return;
        }

        for (Student student :
                studentService.getStudents()) {

            System.out.println(student);
        }

        System.out.println(
                "Student view successfully"
        );
    }

    private static void searchStudent(
            StudentService studentService,
            SearchStrategy strategy,
            Scanner sc
    ) {

        if (studentService.isStudentsEmpty()) {
            System.out.println("No students found");
            return;
        }

        int searchId =
                InputHelper.readInt(
                        sc,
                        "Enter Student ID:"
                );

        sc.nextLine();

        try {

            Student student =
                    studentService.searchStudent(
                            strategy,
                            searchId
                    );

            System.out.println(student);

            System.out.println(
                    "Student found successfully"
            );

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent(
            StudentService studentService,
            Scanner sc
    ) {

        int deleteId =
                InputHelper.readInt(
                        sc,
                        "Enter Student ID:"
                );

        sc.nextLine();

        try {

            studentService.deleteStudent(deleteId);

            System.out.println(
                    "Student delete successfully"
            );

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void updateStudent(
            StudentService studentService,
            Scanner sc
    ) {

        int updateId =
                InputHelper.readInt(
                        sc,
                        "Enter Student ID:"
                );

        sc.nextLine();

        int choice =
                InputHelper.readUpdateChoice(sc);

        sc.nextLine();

        String value =
                InputHelper.readString(
                        sc,
                        "Enter New Value :"
                );

        try {

            studentService.updateStudent(
                    updateId,
                    choice,
                    value
            );

            System.out.println(
                    "Student updated successfully"
            );

        } catch (StudentNotFoundException |
                 InvalidStudentException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void sortStudents(
            StudentService studentService,
            SortingStrategy strategy
    ) {

        if (studentService.isStudentsEmpty()) {
            System.out.println("No students found");
            return;
        }

        studentService.sortStudents(strategy);

        for (Student student :
                studentService.getStudents()) {

            System.out.println(student);
        }

        System.out.println(
                "Student sorted successfully"
        );
    }
}