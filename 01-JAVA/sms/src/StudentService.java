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
    public void addDummyStudents() {

        if(!students.isEmpty()) {
            System.out.println("Dummy students already loaded");
            return;
        }

        addStudent(new Student(101, "Sakthi", 19, "IT"));
        addStudent(new Student(102, "Arun", 20, "CSE"));
        addStudent(new Student(103, "Vijay", 18, "ECE"));
        addStudent(new Student(104, "Karthik", 21, "EEE"));
        addStudent(new Student(105, "Rahul", 19, "MECH"));
        addStudent(new Student(106, "Ajay", 20, "IT"));
        addStudent(new Student(107, "Surya", 18, "CSE"));
        addStudent(new Student(108, "Praveen", 22, "ECE"));
        addStudent(new Student(109, "Manoj", 19, "EEE"));
        addStudent(new Student(110, "Hari", 20, "MECH"));
    }
    public static boolean isNumeric(String id){
        try {
            Integer.parseInt(id);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public static boolean isValidChoice(int choice){
        return choice <=10 &&  choice >=0;
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
        int count=0;
        for (Student student: students) {
            count++;
            if(student.getId() == searchId) {
                System.out.println(count+" Comparisons");
                return student;
            }
        }
        return null;

    }
    public Student binarySearchStudent(int searchId) {
        int start=0;
        int end=students.size()-1;
        int count=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            count++;
            if(searchId==students.get(mid).getId()) {
                System.out.println(count+" comparisons");
                return students.get(mid);
            }
            else if(searchId<students.get(mid).getId()) {
                end=mid-1;
            }
            else {
                start=mid+1;
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
                if(isNumeric(value) && InputHelper.isValidAge(value)) {
                    studentToUpdate.setAge(Integer.parseInt(value));
                    result = true;
                }
//                studentToUpdate.setAge(Integer.parseInt(value));
                else{
                    System.out.println("Enter according datatype ..");
                }
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
            int max=getMAX(0,last);
            swap(max,last);
        }
        viewStudents();
    }
    private int getMAX(int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(students.get(i).getId()>students.get(max).getId()){
                max=i;
            }
//            max=Math.max(max,(students.get(i)).getId());
        }
        return max;
    }
    private void swap(int a,int b){
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


    }

    public void sortStudentsById() {
        students.sort(Comparator.comparing(Student::getId));

    }

    public boolean isStudentsEmpty() {
        return students.isEmpty();
    }

}
