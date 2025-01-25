import java.util.Stack;

public class QueueWithStack {
    static Stack<Integer> stack; // Stack to represent the queue
    static Stack<Integer> queueStack; // Temporary stack for dequeue operations

    // Constructor to initialize the main stack
    public QueueWithStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    // Method to enqueue an element into the queue
    public void enqueue(int value) {
        stack.push(value);
        System.out.println("Enqueued " + value + " into the queue.");
    }

    // Method to dequeue an element from the queue
    public void dequeue() {
        // Check if the queue is empty
        if (stack.isEmpty()) {
            System.out.println("Cannot dequeue from an empty queue.");
            return;
        }

        queueStack = new Stack<>(); // Temporary stack to reverse elements
        // Move all elements from the main stack to the temporary stack
        while (!stack.isEmpty()) {
            queueStack.push(stack.pop());
        }

        // Remove the front element of the queue
        int dequeuedValue = queueStack.pop();
        System.out.println("Dequeued " + dequeuedValue + " from the queue.");

        // Move the elements back to the main stack
        while (!queueStack.isEmpty()) {
            stack.push(queueStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(70);
        stack1.push(10);
        stack1.push(20);
        stack1.push(50);
        stack1.push(40);

        // Initialize the queue with the stack
        QueueWithStack qstack = new QueueWithStack(stack1);

        // Enqueue operation
        qstack.enqueue(90);
        System.out.println("Current queue after enqueue: " + stack1);

        // Dequeue operation
        qstack.dequeue();
        System.out.println("Current queue after dequeue: " + stack1);

        // Attempting to dequeue from an empty queue
        stack1.clear(); // Clear the stack to simulate an empty queue
        qstack.dequeue();
    }
}
