import java.util.EmptyStackException;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println("Stack 1 after push: "+stack1);
        stack1.pop();
        System.out.println("Stack 1 after pop: "+stack1);

        Stack<String> stack2 = new Stack<String>();
        try{
            stack2.pop();
        }catch (EmptyStackException e){
            System.out.println("Stack is empty");
        }
        stack2.push("Arjit");
        stack2.push("Karan");
        stack2.push("Sid");
        stack2.push("Laks");
        System.out.println("Stack 2 after push: "+stack2);
        stack2.pop();
        stack2.pop();
        System.out.println("Stack 2 after 2 pops: "+stack2);
    }
}
