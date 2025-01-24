import java.util.Stack;

public class QueueWithStack {
    static Stack<Integer> stack;
    static Stack<Integer> queueStack;

    public QueueWithStack(Stack<Integer> stack){
        this.stack = stack;
    }

    public void enqueue(int value){
        stack.push(value);
    }

    public void dequeue(){
        queueStack = new Stack<Integer>();
        while(!stack.isEmpty()){
            queueStack.push(stack.pop());
        }
        queueStack.pop();
        while(!queueStack.isEmpty()){
            stack.push(queueStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(70);
        stack1.push(10);
        stack1.push(20);
        stack1.push(50);
        stack1.push(40);
        QueueWithStack qstack = new QueueWithStack(stack1);
        qstack.enqueue(90);
        System.out.println("Current queue after enqueue: "+stack1);
        qstack.dequeue();
        System.out.println("Current queue after dequeue: "+stack1);
    }

}
