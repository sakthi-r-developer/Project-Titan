public class Student {
    int id;
    String name;
    int age;
    String department;
    Student(int id, String name,int age,String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    public String toString(){
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + "]" ;
    }
}
