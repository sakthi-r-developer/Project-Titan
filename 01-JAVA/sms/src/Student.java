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
        StringBuilder sb = new StringBuilder();
        sb.append("ID : "+id+"\n");
        sb.append("Name : "+name+"\n");
        sb.append("Age : "+age+"\n");
        sb.append("Department : "+department+"\n");
        return sb.toString();
    }
    public int getId() {
        return id;
    }

}
