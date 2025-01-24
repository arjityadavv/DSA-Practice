import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueuePractice {

    static int rear;
    int front;
    static int[] a;
    int size;

    public QueuePractice(int size){
        rear = -1;
        this.size = size;
        this.a = new int[size];
    }

    public void enQueue(int value){
        rear++;
        a[rear] = value;
    }

    public int deQueue(){
        int ele = a[0];
        for(int i=0;i<rear;i++){
            a[i] = a[i+1];
        }
        rear--;
        return ele;
    }

    public static void printQueue(){
        for(int i=0;i<=rear;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    public static void reverseQueue(){
        int start = 0;
        int end = rear;
        while(start<end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseQueueUsingStack(){
        Stack<Integer> temp = new Stack<Integer>();
        for(int i=0;i<=rear;i++){
            temp.push(a[i]);
        }
        int start = 0;
        while(!temp.isEmpty()){
            a[start] = temp.pop();
            start++;
        }
    }

    public static void enQueueWithArray(int x){
        rear++;
        a[rear] = x;
        int currentRear = rear;
        while(currentRear!=0){
            if(a[currentRear-1]>x){
                int temp = a[currentRear];
                a[currentRear] = a[currentRear-1];
                a[currentRear-1] = temp;
            }
            currentRear--;
        }
    }

    public static void main(String[] args) {
        QueuePractice queue = new QueuePractice(5);
        queue.enQueue(4);
        queue.enQueue(3);
        queue.enQueue(7);
        queue.enQueue(1);
        queue.enQueue(5);
        printQueue(); // 4 3 7 1
        queue.deQueue();
        printQueue(); // 3 7 1
        queue.enQueue(10);
        printQueue(); // 3 7 1 10
        queue.deQueue();
        printQueue(); // 7 1 10
        reverseQueue();
        printQueue();
        reverseQueueUsingStack();
        printQueue();
        Queue<Integer> priority = new PriorityQueue<>();
        priority.add(99);
        priority.add(77);
        priority.add(111);
        priority.add(200);
        for(int ele : priority){
            System.out.print(ele+" ");
            System.out.println();
        }
        QueuePractice queue1 = new QueuePractice(5);
        queue1.enQueueWithArray(50);
        queue1.enQueueWithArray(70);
        queue1.enQueueWithArray(10);
        queue1.enQueueWithArray(40);
        queue1.enQueueWithArray(30);

        printQueue();
    }
}
