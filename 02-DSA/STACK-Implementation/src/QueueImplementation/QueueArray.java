package QueueImplementation;

public class QueueArray {
    int[] queue = new int[3];
    int front = 0, rear = -1;
    public void push(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = data;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front++];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
    public int size(){
        return rear-front+1;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean isFull(){
        return size() == queue.length;
    }

}
