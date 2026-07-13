public class Student {
    private int id;
    private String name;
    private int age;
    private String department;
    Student(int id, String name,int age,String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("___________________________\n");
        sb.append("ID : "+id+"\n");
        sb.append("Name : "+name+"\n");
        sb.append("Age : "+age+"\n");
        sb.append("Department : "+department+"\n");
        sb.append("___________________________");
        return sb.toString();
    }
    public int getId() {
        return id;
    }
    public String  getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getDepartment() {
        return department;
    }

}
