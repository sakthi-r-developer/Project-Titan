package util;

import model.Student;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;


public class FileHandler {
    public static void saveStudents(ArrayList<Student> students){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {

            for(Student student : students){
                bw.write(student.getId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getDepartment()
                );
                bw.newLine();
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
    public static ArrayList<Student> loadStudents(){
        ArrayList<Student> students = new ArrayList<>();

        File file = new File("students.txt");

        if(!file.exists()){
            return students;
        }
        try{
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine()) != null){
                String[] lineArray = line.split(",");
                if (lineArray.length != 4) {
                    continue;
                }

                int id = Integer.parseInt(lineArray[0]);
                String name = lineArray[1];
                int age = Integer.parseInt(lineArray[2]);
                String department = lineArray[3];
                students.add(new Student(id, name, age, department));
            }
        }
        catch(IOException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return students;
    }
}
