
    import java.util.ArrayList;
    import java.util.Scanner;


    class Main {
        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

        public static void main(String[] args) {
//            ArrayList<Student> students = new ArrayList<>();
            StudentService studentService = new StudentService();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Student \n"+
                "2. View Students \n"+
                "3. Search Student \n"+
                "4. Delete Student \n"+
                "5. Update Student \n"+
                "6. Sort Students by ID \n"+
                "7. bubbleSort by Student ID \n"+
                "8. selectionSort by Student ID \n"+
                "9. Exit \n"+
                "Choose an option: ");
                int option = sc.nextInt();
                if(option==7) {
                    break;
                }
                switch (option) {
                    case 1:
                        System.out.println(
                                "Enter Student ID: "
                        );
                        int id = sc.nextInt();
                        sc.nextLine();


//                        Student existingStudent=studentService.searchStudent(id);
//                        if(existingStudent != null) {
//                            System.out.println("Student id already in use");
//                            break;
//                        }
                        System.out.println(
                                "Enter Student Name: "
                        );
                        String name = sc.nextLine();
                        System.out.println(
                                "Enter Student Age: "
                        );
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println(
                                "Enter Student Department: "
                        );
                        String department = sc.nextLine();
                        Student student = new Student(id, name, age, department);


                        if(studentService.addStudent(student)){
                            System.out.println("Student added successfully");
                        }
                        else{
                            System.out.println("Student not added successfully");
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
                        System.out.println("Enter Student ID: ");
                        int searchId = sc.nextInt();
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
                        System.out.println("Enter Student ID: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        if(studentService.deleteStudent(deleteId)){
                            System.out.println("Student deleted successfully");
                        }
                        else{
                            System.out.println("Student not deleted successfully");
                        }
                        break;
                    case 5:
                        System.out.println("Enter Student ID: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

//                        Student studentToUpdate = studentService.searchStudent(updateId);
//                        if(studentToUpdate!=null) {
//                            System.out.println(studentToUpdate);
//                            System.out.println("Student found successfully");
//                        }
//                        else{
//                            System.out.println("Student not found");
//                            break;
//                        }

                        System.out.println("Choose Field: \n"+
                                "1.Name\n"+
                                "2.Age\n"+
                                "3.Department\n"+
                                "Enter Choice: ");
                        int  choice = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Value: ");
                        String value = sc.nextLine();
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
//                            studentService.bubbleSortStudents();
                            System.out.println("Student sorted successfully");
                        }
                        break;
                    case 7:
                        if(studentService.isStudentsEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
//                            studentService.sortStudentsById();
                            studentService.bubbleSortStudents();
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

                    default:
                        break;

                }

            }

        }
    }
