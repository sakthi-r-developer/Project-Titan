package sorting;

import model.Student;

import java.util.ArrayList;

public class SelectionSortStrategy implements SortingStrategy {
    public void sort(ArrayList<Student> students){
        int n = students.size();
        for(int i=0;i<n-1;i++){
            int last=n-i-1;
            int max=getMax(students,0,last);
            swap(students,max,last);
        }
    }
    public void swap(ArrayList<Student> students,int a,int b){
        Student temp = students.get(a);
        students.set(a, students.get(b));
        students.set(b, temp);
    }
    private int getMax(ArrayList<Student> students,int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(students.get(i).getId()> students.get(max).getId()){
                max=i;
            }
        }
        return max;
    }
}
