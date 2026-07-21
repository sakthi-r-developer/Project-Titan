
    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.Scanner;


    class Main {
        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


        public static void main(String[] args) {
            StudentService studentService = new StudentService();
            Scanner sc = new Scanner(System.in);
            while (true) {
                int option = InputHelper.readMenuChoice(sc);
                if(option==10) {
                    break;
                }
                switch (option) {
                    case 0:
                        studentService.addDummyStudents();
                        System.out.println("Add Student Successful");
                        break;

                    case 1:
                        int id=InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();
                        String name=InputHelper.readString(sc,"Enter Student Name:");
                        int age=InputHelper.readInt(sc,"Enter Student Age:");

                        sc.nextLine();
                        String department=InputHelper.readString(sc,"Enter Student Department:");
                        Student student = new Student(id, name, age, department);


                        if(studentService.addStudent(student)){
                            System.out.println("Student added successfully");
                        }
                        else{
                            System.out.println("Failed to add student.");
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
                        Student foundStudent=studentService.searchStudent( searchId);
                        if(foundStudent!=null) {
                            System.out.println(foundStudent);
                            System.out.println("Student found successfully");
                        }
                        else{
                            System.out.println("Student not found");
                        }
                        break;
                    case 4:
                        int deleteId = InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();
                        if(studentService.deleteStudent(deleteId)){
                            System.out.println("Student deleted successfully");
                        }
                        else{
                            System.out.println("Student not deleted successfully");
                        }
                        break;
                    case 5:
                        int updateId = InputHelper.readInt(sc,"Enter Student ID:");
                        sc.nextLine();

                        System.out.println("Choose Field: \n"+
                                "1.Name\n"+
                                "2.Age\n"+
                                "3.Department\n"+
                                "Enter Choice: ");

                        int choice = -1;
                        while(choice==-1) {
                            String choiceStr = sc.next();
                            if(studentService.isNumeric(choiceStr)){
                                choice = Integer.parseInt(choiceStr);
                                if(studentService.isValidChoice(choice)){}
                                break;
                            }
                            else{
                                System.out.println("Invalid Choice \n");
                                System.out.println("Choose Choice: ");
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
                            studentService.sortStudentsById();
                            studentService.viewStudents();
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 7:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            studentService.bubbleSortStudents();
                            studentService.viewStudents();
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 8:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            studentService.selectionSortStudents();
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
                            Student foundBSStudent=studentService.binarySearchStudent( binarySearchId);
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
