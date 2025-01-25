import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueuePractice {

    static int rear;
    int front;
    static int[] a;
    int size;

    // Constructor to initialize queue with a fixed size
    public QueuePractice(int size) {
        rear = -1;
        this.size = size;
        a = new int[size];
    }

    // Method to add an element to the queue
    public void enQueue(int value) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        a[rear] = value;
    }

    // Method to remove an element from the front of the queue
    public int deQueue() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int ele = a[0];
        for (int i = 0; i < rear; i++) {
            a[i] = a[i + 1];
        }
        rear--;
        return ele;
    }

    // Method to print the current elements in the queue
    public static void printQueue() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i <= rear; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Method to reverse the queue using two pointers
    public static void reverseQueue() {
        int start = 0;
        int end = rear;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    // Method to reverse the queue using a stack
    public static void reverseQueueUsingStack() {
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i <= rear; i++) {
            temp.push(a[i]);
        }
        int start = 0;
        while (!temp.isEmpty()) {
            a[start] = temp.pop();
            start++;
        }
    }

    // Method to enqueue elements in sorted order
    public static void enQueueWithArray(int x) {
        if (rear == a.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        a[rear] = x;
        int currentRear = rear;
        while (currentRear > 0 && a[currentRear - 1] > x) {
            int temp = a[currentRear];
            a[currentRear] = a[currentRear - 1];
            a[currentRear - 1] = temp;
            currentRear--;
        }
    }

    public static void main(String[] args) {
        // Demonstrate basic queue operations
        QueuePractice queue = new QueuePractice(5);
        queue.enQueue(4);
        queue.enQueue(3);
        queue.enQueue(7);
        queue.enQueue(1);
        queue.enQueue(5);
        printQueue(); // 4 3 7 1 5

        queue.deQueue();
        printQueue(); // 3 7 1 5

        queue.enQueue(10);
        printQueue(); // 3 7 1 5 10

        queue.deQueue();
        printQueue(); // 7 1 5 10

        reverseQueue();
        printQueue(); // 10 5 1 7

        reverseQueueUsingStack();
        printQueue(); // 7 1 5 10

        // Demonstrate priority queue usage
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(99);
        priorityQueue.add(77);
        priorityQueue.add(111);
        priorityQueue.add(200);
        System.out.println("Priority Queue elements:");
        for (int ele : priorityQueue) {
            System.out.print(ele + " ");
        }
        System.out.println();

        // Demonstrate sorted enqueue operations
        QueuePractice sortedQueue = new QueuePractice(5);
        sortedQueue.enQueueWithArray(50);
        sortedQueue.enQueueWithArray(70);
        sortedQueue.enQueueWithArray(10);
        sortedQueue.enQueueWithArray(40);
        sortedQueue.enQueueWithArray(30);

        printQueue(); // 10 30 40 50 70
    }
}