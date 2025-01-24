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

    public static void main(String[] args) {
        QueuePractice queue = new QueuePractice(4);
        queue.enQueue(4);
        queue.enQueue(3);
        queue.enQueue(7);
        queue.enQueue(1);
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

    }
}
