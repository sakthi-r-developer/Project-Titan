
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student \n"+
            "2. View Students\n"+
            "3. Exit\n"+
            "Choose an option: ");
            int option = sc.nextInt();
            if(option==3) {
                break;
            }
            switch (option) {
                case 1:
                    System.out.println(
                            "Enter Student ID: "
                    );
                    int id = sc.nextInt();
                    sc.nextLine();
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
                    list.add(new Student(id, name, age, department));
                    break;
                case 2:
                    if(list.isEmpty()) {
                        System.out.println("no students found");

                    }
                    else {
                        for (int i = 0; i < list.size(); i++)
                            System.out.println(i + 1 + " " + list.get(i).toString());
                    }
                    break;
                default:
                    break;

            }
            
        }

    }
}
