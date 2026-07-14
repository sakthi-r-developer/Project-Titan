import java.util.ArrayList;

public class StudentService{
    private ArrayList<Student> students;
    public StudentService(){
        students = new ArrayList<>();
    }
    public boolean isValidStudent(Student student){
        if(student.getId()<=0) {
            return false;
        }
        else if(student.getName().trim().isEmpty()) {
            return false;
        }
        else if(student.getDepartment().trim().isEmpty()) {
            return false;
        }
        else if(student.getAge()<16 || student.getAge()>100) {
            return false;
        }
        else return true;
    }
    public String inValidDetail(Student student){
        if(student.getId()<=0) {
            return "Invalid ID";
        }
        else if(student.getName().trim().isEmpty()) {
            return "Invalid Name";
        }
        else if(student.getDepartment().trim().isEmpty()) {
            return "Invalid Department";
        }
        else if(student.getAge()<16 || student.getAge()>100) {
            return "Invalid Age";
        }
        else return "Unknown validation error";
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchStudent(int searchId) {

        for (Student student: students) {
            if(student.getId() == searchId) {
                return student;
            }
        }
        return null;

    }
    public void deleteStudent( Student student) {
        students.remove(student);
    }

//    public void updateStudent(Student studentToUpdate,String modifyField) {
//        switch (modifyField) {
//            case "Name":
//                System.out.println("Enter update Student Name: ");
//                String updateName = sc.nextLine();
//                sc.nextLine();
//                if(studentToUpdate.getName().equals(updateName)){
//                    studentToUpdate.setName(updateName);
//                }
//                break;
//            case "Age":
//                System.out.println("Enter update Student Age: ");
//                int updateAge = sc.nextInt();
//                sc.nextLine();
//                studentToUpdate.setAge(updateAge);
//                break;
//            case "Department":
//                System.out.println("Enter update Student Department: ");
//                String updateDepartment = sc.nextLine();
//                sc.nextLine();
//                studentToUpdate.setDepartment(updateDepartment);
//                break;
//            default:
//                System.out.println("Invalid input");
//                break;
//        }
//
//    }

    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }
}
