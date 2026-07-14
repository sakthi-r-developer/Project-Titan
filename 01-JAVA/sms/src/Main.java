
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
                "6. Exit \n"+
                "Choose an option: ");
                int option = sc.nextInt();
                if(option==6) {
                    break;
                }
                switch (option) {
                    case 1:
                        System.out.println(
                                "Enter Student ID: "
                        );
                        int id = sc.nextInt();
                        sc.nextLine();


                        Student existingStudent=studentService.searchStudent(id);
                        if(existingStudent != null) {
                            System.out.println("Student id already in use");
                            break;
                        }
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

                        if(studentService.isValidStudent(student)){
                            studentService.addStudent(student);
                        }
                        else{
                            System.out.println(studentService.inValidDetail(student)+"\n");
                        }
                        break;
                    case 2:
                        if(studentService.isStudentsEmpty()) {
                                System.out.println("no students found");

                        }
                        else {
                            studentService.viewStudents();
                        }
                        break;
                    case 3:
                        System.out.println("Enter Student ID: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        Student foundStudent=studentService.searchStudent( searchId);
                        if(foundStudent!=null) {
                            System.out.println(foundStudent);
                        }
                        else{
                            System.out.println("Student not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Student ID: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();

                        Student studentToDelete = studentService.searchStudent(deleteId);
                        if(studentToDelete!=null) {
                            studentService.deleteStudent(studentToDelete);
                            System.out.println("Student deleted successfully.");
                        }
                        else{
                            System.out.println("Student not found");
                        }
                        break;
                    case 5:
                        System.out.println("Enter Student ID: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        Student studentToUpdate = studentService.searchStudent(updateId);
                        if(studentToUpdate!=null) {
                            System.out.println(studentToUpdate);
                        }
                        else{
                            System.out.println("Student not found");
                            break;
                        }
                        System.out.println("Enter Student Field: ");
                        String modifyField = sc.nextLine();

//                        if(studentToUpdate!=null)
//                        StudentService.updateStudent(studentToUpadate,modifyField);
                        switch (modifyField) {
                            case "Name":
                                System.out.println("Enter update Student Name: ");
                                String updateName = sc.nextLine();
//                                if(studentToUpdate.getName().equals(updateName)){
                                studentToUpdate.setName(updateName);
                                System.out.println("Student Name Updated successfully. ");

//                                }

                                break;
                            case "Age":
                                System.out.println("Enter update Student Age: ");
                                int updateAge = sc.nextInt();
                                sc.nextLine();
                                studentToUpdate.setAge(updateAge);
                                System.out.println("Student Age Updated successfully. ");

                                break;
                            case "Department":
                                System.out.println("Enter update Student Department: ");
                                String updateDepartment = sc.nextLine();
                                studentToUpdate.setDepartment(updateDepartment);
                                System.out.println("Student Department Updated successfully. ");
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }

                        break;
                    default:
                        break;

                }

            }

        }
    }
