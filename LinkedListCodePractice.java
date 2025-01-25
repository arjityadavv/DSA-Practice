public class LinkedListCodePractice {

    // Inner class representing a Node in the LinkedList
    static class Node {
        int val; // Value stored in the node
        Node next; // Reference to the next node
        public Node(int val) {
            this.val = val; // Assign value during creation
        }
    }

    // Head and Tail references for the LinkedList
    static Node head = null;
    static Node tail = null;

    // Method to add a node at the end of the LinkedList
    public void addNodeAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) { // If list is empty
            head = newNode; // Head and tail both point to the new node
            tail = newNode;
        } else { // Append to the end
            tail.next = newNode;
            tail = newNode; // Update tail to point to the new last node
        }
    }

    // Method to print all elements of the LinkedList
    public void printLinkedList(Node headNode) {
        Node current = headNode;
        while (current != null) { // Traverse until end
            System.out.println(current.val); // Print each node value
            current = current.next; // Move to next node
        }
    }

    // Method to add a node at the start of the LinkedList
    public void addNodeAtStart(int val) {
        Node startNode = new Node(val);
        if (head == null) { // If list is empty
            head = startNode; // Head and tail point to the new node
            tail = startNode;
        }
        startNode.next = head; // Link the new node to the current head
        head = startNode; // Update head to the new node
    }

    // Method to add a node at a specific index
    public void addNodeAtGivenIndex(int val, int index) {
        int count = 1;
        Node current = head;
        Node newNode = new Node(val);

        while (current != null && count != index - 1) { // Traverse to the node before the given index
            current = current.next;
            count++;
        }

        if (current == null) { // Check for invalid index
            if (index == 1) { // Special case: adding at index 1
                addNodeAtEnd(val);
            } else {
                System.out.println("Can't add as Linked List is empty or index value is invalid.");
            }
        } else { // Valid index, insert the new node
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    // Method to delete the last node
    public void deleteNodeAtEnd() {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.next == null) { // Found the last node
                if (prev != null) {
                    prev.next = null; // Remove the last node
                } else { // Single node in the list
                    head = null;
                    tail = null;
                }
                break;
            } else {
                prev = current; // Keep track of the previous node
                current = current.next;
            }
        }
    }

    // Method to delete the first node
    public void deleteNoteAtStart() {
        Node current = head;
        if (current != null) {
            if (current.next != null) { // More than one node
                head = current.next; // Update head to the next node
                current.next = null; // Disconnect the old head
            } else { // Single node
                head = null;
                tail = null; // Clear the list
            }
        } else {
            System.out.println("There is no node present, nothing will be deleted.");
        }
    }

    // Method to delete a node at a specific index
    public void deleteNodeAtGivenIndex(int index) {
        Node current = head;
        int count = 1;
        if (index == 1) { // Special case: deleting the first node
            deleteNoteAtStart();
        } else {
            Node before = null, after = null, deleted = null;
            while (current != null) {
                if (count == index - 1) {
                    before = current;
                } else if (count == index) {
                    deleted = current; // Node to delete
                    after = current.next; // Node after the one to delete
                }
                current = current.next;
                count++;
            }
            if (before != null) {
                before.next = after; // Bypass the deleted node
            }
            if (deleted != null) {
                deleted.next = null; // Disconnect the deleted node
            }
        }
    }

    // Method to delete nodes with even values
    public void deleteTheEvenValueNode() {
        Node current = head;
        int count = 1;
        while (current != null) {
            if (current.val % 2 == 0) { // Check if value is even
                deleteNodeAtGivenIndex(count); // Delete at current index
                count = 1; // Reset count after modifying the list
            } else {
                count++;
            }
            current = current.next;
        }
    }

    // Method to reverse the LinkedList
    public Node reverseLinkedList() {
        Node currentNode = head;
        Node prevNode = null, nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next; // Save next node
            currentNode.next = prevNode; // Reverse the link
            prevNode = currentNode; // Move prev forward
            currentNode = nextNode; // Move current forward
        }
        return prevNode; // New head of the reversed list
    }

    public static void main(String[] args) {
        LinkedListCodePractice linkedList = new LinkedListCodePractice();

        // Adding nodes to the LinkedList
        linkedList.addNodeAtEnd(11);
        linkedList.addNodeAtEnd(22);
        linkedList.addNodeAtEnd(33);
        linkedList.addNodeAtEnd(44);
        linkedList.addNodeAtStart(55);

        // Printing the LinkedList
        System.out.println("Initial List:");
        linkedList.printLinkedList(head);

        // Adding a node at index 4
        System.out.println("After adding 99 at index 4:");
        linkedList.addNodeAtGivenIndex(99, 4);
        linkedList.printLinkedList(head);

        // Deleting nodes from the end
        System.out.println("After deleting nodes at the end:");
        linkedList.deleteNodeAtEnd();
        linkedList.deleteNodeAtEnd();
        linkedList.printLinkedList(head);

        // Deleting the first node
        System.out.println("After deleting the first node:");
        linkedList.deleteNoteAtStart();
        linkedList.printLinkedList(head);

        // Deleting a node at a specific index
        System.out.println("After deleting the node at index 4:");
        linkedList.deleteNodeAtGivenIndex(4);
        linkedList.printLinkedList(head);

        // Deleting all nodes with even values
        System.out.println("After deleting even value nodes:");
        linkedList.deleteTheEvenValueNode();
        linkedList.printLinkedList(head);

        // Reversing the LinkedList
        System.out.println("After reversing the LinkedList:");
        Node startNode = linkedList.reverseLinkedList();
        linkedList.printLinkedList(startNode);
    }
}