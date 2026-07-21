import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner sc, String tag) {
        while (true) {
            System.out.print(tag);
            String input = sc.next();

            if (StudentService.isNumeric(input)) {
                return Integer.parseInt(input);
            }

            System.out.println("Invalid number. Try again.");
        }
    }
    public static String readString(Scanner sc, String tag) {
        System.out.print(tag);
        return  sc.nextLine();
    }
    public static int readMenuChoice(Scanner sc) {
        int choice;
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
            String input = sc.next();

            if(StudentService.isNumeric(input)){
                choice = Integer.parseInt(input);

                if(StudentService.isValidChoice(choice)){
                    break;
                }
            }

            System.out.println("Invalid choice.");
        }
        return choice;
    }
    public static boolean isValidAge(String value) {
        int age=Integer.parseInt(value);
        if(age<16 || age>100) {
            return false;
        }
        return true;
    }

}
