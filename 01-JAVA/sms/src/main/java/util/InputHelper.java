package util;

import validation.Validator;
import exceptions.InvalidChoiceException;

import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner sc, String tag) {
        while (true) {
            System.out.print(tag);
            String input = sc.next();

            if (Validator.isNumeric(input)) {
                return Integer.parseInt(input);
            }

            System.out.println("Invalid number. Try again.");
        }
    }
    public static String readString(Scanner sc, String tag) {
        System.out.print(tag);
        return sc.nextLine();
    }
    public static int readUpdateChoice(Scanner sc) {
        while (true) {
            System.out.println(
                    "Choose Field:\n" +
                            "1. Name\n" +
                            "2. Age\n" +
                            "3. Department"
            );

            System.out.print("Enter Choice: ");
            String input = sc.next();

            if (!Validator.isNumeric(input)) {
                System.out.println("Enter a valid number.");
                continue;
            }

            int choice = Integer.parseInt(input);

            try {
                Validator.isValidChoice(choice);
                return choice;
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int readMenuChoice(Scanner sc) {
        while (true) {
            System.out.println(
                    "0. Add DummyStudents\n" +
                            "1. Add Student\n" +
                            "2. View Students\n" +
                            "3. Search Student\n" +
                            "4. Delete Student\n" +
                            "5. Update Student\n" +
                            "6. Sort Students by ID\n" +
                            "7. bubbleSort by Student ID\n" +
                            "8. selectionSort by Student ID\n" +
                            "9. binarySearchStudent by Student ID\n" +
                            "10. Exit\n" +
                            "Choose an option: "
            );

            String input = sc.next();

            if (!Validator.isNumeric(input)) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            int choice = Integer.parseInt(input);

            try {
                if (Validator.isValidChoice(choice)) {
                    return choice;
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
