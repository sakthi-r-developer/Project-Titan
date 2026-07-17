package QueueImplementation;

public class Main {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.size());
        System.out.println(queue.isFull());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
