import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentService{
    private ArrayList<Student> students;
    public StudentService(){
        students = new ArrayList<>();
    }
    public boolean isValidStudent(Student student){
        if(student.getId()<=0 || searchStudent(student.getId())!=null || student.getName().trim().isEmpty() || student.getDepartment().trim().isEmpty() || student.getAge()<16 || student.getAge()>100) {
            return false;
        }
        else return true;
    }
    public String inValidDetail(Student student){
        if(student.getId()<=0 ) {
            return "Invalid ID";
        }
        else if(searchStudent(student.getId())!=null) {
            return "Student with ID "+student.getId()+" already exists";
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
//        else if(student.searchStudent())
        else return "Unknown validation error";
    }
    public boolean addStudent(Student student){
        if(isValidStudent(student)) {
            students.add(student);
            return true;
        }
        else{
            System.out.println(inValidDetail(student));
            return false;
        }
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
    public boolean deleteStudent( int deleteId) {
        Student student = searchStudent(deleteId);
        if(student!=null) {
            students.remove(student);
            return true;
        }
        else{
            return false;
        }

    }

    public boolean updateStudent(int updateId,int choice,String value) {
        Student studentToUpdate = searchStudent(updateId);
        if(studentToUpdate==null) {
            return false;
        }
        boolean result = false;
        switch (choice) {
            case 1:
                studentToUpdate.setName(value);
                result = true;
                break;
            case 2:
                studentToUpdate.setAge(Integer.parseInt(value));
                result = true;
                break;
            case 3:
                studentToUpdate.setDepartment(value);
                result = true;
                break;
            default:
                System.out.println("Invalid input");
                result = false;
                break;
        }
        return result;

    }
    public void selectionSortStudents(){
        int n =students.size();
        for(int i=0;i<n-1;i++){
            int last=n-i-1;
            int max=GetMAX(0,last);
            swap(max,last);
        }
        viewStudents();
    }
    public int GetMAX(int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(students.get(i).getId()>students.get(max).getId()){
                max=i;
            }
//            max=Math.max(max,(students.get(i)).getId());
        }
        return max;
    }
    public void swap(int a,int b){
        Student temp = students.get(a);
        students.set(a, students.get(b));
        students.set(b, temp);
    }
    public void bubbleSortStudents() {
        int n = students.size();
        Student temp;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if ((students.get(j)).getId() > (students.get(j + 1)).getId()) {

                    // Swap
                    temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);

                    swapped = true;
                }
            }

            // Already sorted
            if (!swapped) break;
        }
        viewStudents();

    }
    public void sortStudentsById() {
        students.sort(Comparator.comparing(Student::getId));
        viewStudents();
    }

    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }
}
