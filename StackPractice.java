import java.util.EmptyStackException;
import java.util.Stack;

public class StackPractice {
    public static Stack<Integer> stackIntegers(){
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println("Stack 1 after push: "+stack1);
        stack1.pop();
        System.out.println("Stack 1 after pop: "+stack1);
        return stack1;
    }

    public static Stack<String> stackStrings(){
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
        return stack2;
    }
    public static void reverseIntegerStack(Stack<Integer> stack){
        Stack<Integer> revStack = new Stack<Integer>();
        int stackSize = stack.size();
        for(int i=0;i<stackSize;i++){
            int pop = stack.peek();
            revStack.push(pop);
            stack.pop();
        }
        System.out.println("Reverse Stack is: "+revStack);
    }

    public static void reverseStringStack(Stack<String> stack){
        Stack<String> revStack = new Stack<String>();
        int stackSize = stack.size();
        for(int i=0;i<stackSize;i++){
            String pop = stack.peek();
            revStack.push(pop);
            stack.pop();
        }
        System.out.println("Reverse Stack is: "+revStack);
    }

    public static void insertAtGivenIndexInGivenStack(int index, int value, Stack<Integer> stack){
        Stack<Integer> stack1 = new Stack<Integer>();
        int popTimes = stack.size()-index+1;
        for(int i=1;i<=popTimes;i++){
            stack1.push(stack.pop());
        }
        stack.push(value);
        for(int i=1;i<=popTimes;i++){
            stack.push(stack1.pop());
        }
        System.out.println("Stack after insertion: "+stack);
    }

    public static Integer minimumValueInStack(Stack<Integer> stack){
        Stack<Integer> stack1 = new Stack<Integer>();
        int min = 0;
        int size = stack.size();
        for(int i=0;i<size;i++){
            int current = stack.pop();
            if(i==0){
                min = current;
            }
            if(current<min){
                min = current;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        stackIntegers();
        stackStrings();
        reverseIntegerStack(stackIntegers());
        reverseStringStack(stackStrings());
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(11);
        stack.push(25);
        stack.push(55);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        insertAtGivenIndexInGivenStack(3,9,stack);
        insertAtGivenIndexInGivenStack(3,10,stack);
        System.out.println("Minimum value in this stack is: "+minimumValueInStack(stack));
    }
}
