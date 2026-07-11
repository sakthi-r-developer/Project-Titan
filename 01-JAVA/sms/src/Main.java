
    import java.util.ArrayList;
    import java.util.Scanner;


    class Main {
        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        private static void addStudent(ArrayList<Student> students, Student student) {
            students.add(student);
        }
        private static void viewStudents(ArrayList<Student> students) {
            for (Student student : students) {
                System.out.println(student);
            }
        }
        private static Student searchStudent(ArrayList<Student> students, int searchId) {

            for (Student student: students) {
                if(student.getId() == searchId) {
                    return student;
                }
            }
            return null;

        }

        private static void deleteStudent(ArrayList<Student> students, Student student) {
            students.remove(student);
        }

        public static void main(String[] args) {
            ArrayList<Student> students = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Student \n"+
                "2. View Students \n"+
                "3. Search Student \n"+
                "4. Delete Student \n"+
                "5. Exit \n"+
                "Choose an option: ");
                int option = sc.nextInt();
                if(option==5) {
                    break;
                }
                switch (option) {
                    case 1:
                        System.out.println(
                                "Enter Student ID: "
                        );
                        int id = sc.nextInt();
                        sc.nextLine();

                        Student existingStudent = searchStudent(students, id);
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
                        addStudent(students,new Student(id,name,age,department));
                        break;
                    case 2:
                        if(students.isEmpty()) {
                            System.out.println("no students found");

                        }
                        else {
                            viewStudents(students);
                        }
                        break;
                    case 3:
                        System.out.println("Enter Student ID: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        Student foundStudent=searchStudent(students, searchId);
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

                        Student studentToDelete=searchStudent(students, deleteId);
                        if(studentToDelete!=null) {
                            deleteStudent(students, studentToDelete);
                            System.out.println("Student deleted successfully.");
                        }
                        else{
                            System.out.println("Student not found");
                        }
                        break;

                    default:
                        break;

                }

            }

        }
    }
