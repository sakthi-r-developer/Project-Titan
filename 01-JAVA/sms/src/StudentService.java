import java.util.ArrayList;

public class StudentService{
    private ArrayList<Student> students;
    public StudentService(){
        students = new ArrayList<>();
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

    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }
}
