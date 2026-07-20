
    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.Scanner;


    class Main {
        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

        public static void main(String[] args) {
//            ArrayList<Student> students = new ArrayList<>();
            StudentService studentService = new StudentService();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println(
                "0. Add DummyStudents\n"+
                "1. Add Student \n"+
                "2. View Students \n"+
                "3. Search Student \n"+
                "4. Delete Student \n"+
                "5. Update Student \n"+
                "6. Sort Students by ID \n"+
                "7. bubbleSort by Student ID \n"+
                "8. selectionSort by Student ID \n"+
                "9. binarySearchStudent by Student ID \n"+
                "10. Exit \n"+
                "Choose an option: ");
                int option = sc.nextInt();
                if(option==10) {
                    break;
                }
                switch (option) {
                    case 0:
                        studentService.addDummyStudents();
                        System.out.println("Add Student Successful");
                        break;

                    case 1:
                        System.out.println(
                                "Enter Student ID: "
                        );

                        int id = -1;
                        while(id==-1) {
//                            try {
//                                id = Integer.parseInt(sc.next());
//                            } catch (NumberFormatException e) {
//                                System.out.println("Please enter a valid Student ID");
//                            }
                            String idStr = sc.next();
                            if(studentService.isNumeric(idStr)){
                                id = Integer.parseInt(idStr);
                                break;
                            }
                            else{
                                System.out.println("Invalid ID \n");
                                System.out.println("Enter Student ID: ");
                            }
                        }
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
                        int age=-1;
                        while(age==-1) {
//                            try {
//                                age = Integer.parseInt( sc.next());
//                            } catch (NumberFormatException e) {
//                                System.out.println("Please enter a valid Student Age");
//                            }
                            String ageStr = sc.next();
                            if(studentService.isNumeric(ageStr)){
                                age = Integer.parseInt(ageStr);
                                break;
                            }
                            else{
                                System.out.println("Invalid Age Format\n");
                                System.out.println("Enter Student Age: ");
                            }
                        }

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

//                        int searchId = sc.nextInt();
                        int searchId = -1;
                        while(searchId==-1) {
//                            try {
//                                searchId = Integer.parseInt(sc.next());
//                            }
//                            catch(NumberFormatException e) {
//                                System.out.println("Please enter a valid Student ID");
//                            }
                            String idStr = sc.next();
                            if(studentService.isNumeric(idStr)){
                                searchId = Integer.parseInt(idStr);
                                break;
                            }
                            else{
                                System.out.println("Invalid ID \n");
                                System.out.println("Enter Student ID: ");
                            }
                        }
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
//                        int deleteId = sc.nextInt();
                        int deleteId = -1;
                        while(deleteId==-1) {
//                            try {
//                                deleteId = Integer.parseInt(sc.next());
//                            }
//                            catch(NumberFormatException e) {
//                                System.out.println("Please enter a valid Student ID");
//                            }
                            String idStr = sc.next();
                            if(studentService.isNumeric(idStr)){
                                deleteId = Integer.parseInt(idStr);
                                break;
                            }
                            else{
                                System.out.println("Invalid ID \n");
                                System.out.println("Enter Student ID: ");
                            }
                        }
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
//                        int updateId = sc.nextInt();
                        int updateId = -1;
                        while(updateId==-1) {
//                            try {
//                                updateId = Integer.parseInt(sc.next());
//                            }
//                            catch(NumberFormatException e) {
//                                System.out.println("Please enter a valid Student ID");
//                            }
                            String idStr = sc.next();

                            if(studentService.isNumeric(idStr)){
                                updateId = Integer.parseInt(idStr);
                                break;
                            }
                            else{
                                System.out.println("Invalid ID \n");
                                System.out.println("Enter Student ID: ");
                            }
                        }
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

//                        int  choice = sc.nextInt();
                        int choice = -1;
                        while(choice==-1) {
//                            try {
//                                choice = Integer.parseInt(sc.next());
//                            }
//                            catch(NumberFormatException e) {
//                                System.out.println("Please enter a valid Choice");
//                            }
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
                            studentService.viewStudents();
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
                            System.out.println("Enter searchId :");
//                            int binarysearchId = sc.nextInt();
                            int binarysearchId = -1;
                            while(binarysearchId==-1) {
                                String idStr = sc.next();
                                if(studentService.isNumeric(idStr)){
                                    binarysearchId = Integer.parseInt(idStr);
                                    break;
                                }
                                else{
                                    System.out.println("Invalid ID \n");
                                    System.out.println("Enter searchId :");
                                }
                            }
                            sc.nextLine();
                            Student foundBSStudent=studentService.binarySearchStudent( binarysearchId);
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
