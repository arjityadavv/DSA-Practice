import javax.swing.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackPractice {
    // Method to demonstrate basic stack operations with integers
    public static Stack<Integer> stackIntegers() {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1); // Push elements onto the stack
        stack1.push(2);
        stack1.push(3);
        System.out.println("Stack 1 after push: " + stack1);
        stack1.pop(); // Pop the top element from the stack
        System.out.println("Stack 1 after pop: " + stack1);
        return stack1; // Return the stack for further operations
    }

    // Method to demonstrate stack operations with strings
    public static Stack<String> stackStrings() {
        Stack<String> stack2 = new Stack<String>();
        try {
            stack2.pop(); // Try popping from an empty stack to demonstrate exception handling
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty"); // Handle empty stack scenario
        }
        stack2.push("Arjit"); // Push elements onto the stack
        stack2.push("Karan");
        stack2.push("Sid");
        stack2.push("Laks");
        System.out.println("Stack 2 after push: " + stack2);
        stack2.pop(); // Pop the top two elements from the stack
        stack2.pop();
        System.out.println("Stack 2 after 2 pops: " + stack2);
        return stack2; // Return the stack for further operations
    }

    // Method to reverse a stack of integers
    public static void reverseIntegerStack(Stack<Integer> stack) {
        Stack<Integer> revStack = new Stack<Integer>();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            int pop = stack.peek(); // Peek at the top element
            revStack.push(pop); // Push the peeked element onto the reversed stack
            stack.pop(); // Pop the top element
        }
        System.out.println("Reverse Stack is: " + revStack);
    }

    // Method to reverse a stack of strings
    public static void reverseStringStack(Stack<String> stack) {
        Stack<String> revStack = new Stack<String>();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            String pop = stack.peek(); // Peek at the top element
            revStack.push(pop); // Push the peeked element onto the reversed stack
            stack.pop(); // Pop the top element
        }
        System.out.println("Reverse Stack is: " + revStack);
    }

    // Method to insert an element at a given index in a stack
    public static void insertAtGivenIndexInGivenStack(int index, int value, Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<Integer>();
        int popTimes = stack.size() - index + 1; // Calculate how many elements to pop
        for (int i = 1; i <= popTimes; i++) {
            stack1.push(stack.pop()); // Move elements to a temporary stack
        }
        stack.push(value); // Push the new value
        for (int i = 1; i <= popTimes; i++) {
            stack.push(stack1.pop()); // Move elements back to the original stack
        }
        System.out.println("Stack after insertion: " + stack);
    }

    // Method to find the minimum value in a stack
    public static Integer minimumValueInStack(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<Integer>();
        int min = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int current = stack.pop(); // Pop each element from the stack
            if (i == 0) {
                min = current; // Initialize the minimum value
            }
            if (current < min) {
                min = current; // Update the minimum value
            }
        }
        return min;
    }

    // Method to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        System.out.println("Inside sort stack");
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.empty()) {
            int stack_current = stack.pop(); // Pop the top element
            if (temp.empty()) {
                temp.push(stack_current); // Push the first element onto the temp stack
            } else {
                while (!temp.isEmpty() && temp.peek() > stack_current) {
                    stack.push(temp.pop()); // Reorder elements between stacks
                }
                temp.push(stack_current); // Push the sorted element
            }
        }
        System.out.println("Sorted Stack: " + temp);
    }

    // Method to check if a string has balanced brackets
    public static Boolean checkBalancedString(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char b = input.charAt(i);
            if (b == '[' || b == '{' || b == '(') {
                stack.push(b); // Push opening brackets
            } else if (b == ']' || b == '}' || b == ')') {
                char top = stack.pop(); // Pop the top element for matching
                if (b == ']' && top != '[') {
                    return false; // Return false if brackets don't match
                } else if (b == '}' && top != '{') {
                    return false;
                } else if (b == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // Check if the stack is empty after processing
    }

    public static void main(String[] args) {
        stackIntegers(); // Demonstrate integer stack operations
        stackStrings(); // Demonstrate string stack operations
        reverseIntegerStack(stackIntegers()); // Reverse integer stack
        reverseStringStack(stackStrings()); // Reverse string stack

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(11);
        stack.push(25);
        stack.push(55);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        insertAtGivenIndexInGivenStack(3, 9, stack); // Insert an element in the stack
        insertAtGivenIndexInGivenStack(3, 10, stack);
        System.out.println("Minimum value in this stack is: " + minimumValueInStack(stack)); // Find minimum value

        Stack<Integer> stack2 = new Stack<Integer>();
        stack2.push(11);
        stack2.push(25);
        stack2.push(55);
        stack2.push(4);
        sortStack(stack2); // Sort the stack

        System.out.println("Check Balanced String: " + checkBalancedString("[2+{2+2}](4+5)")); // Check balanced brackets
        System.out.println("Check Balanced String: " + checkBalancedString("[2+{2+2}(4+5)"));
        System.out.println("Check Balanced String: " + checkBalancedString("[2+2+2}]4+5)"));
    }
}
