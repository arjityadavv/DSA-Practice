public class LinkedListCodePractice {

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    static Node head = null;
    static Node tail = null;

    public void addNodeAtEnd(int val){
        Node newNode = new Node(val);
        if(head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.next = null;
            tail = newNode;
        }
    }

    public void printLinkedList(Node headNode){
        Node current = headNode;
        while(current!=null){
          System.out.println(current.val);
          current = current.next;
        }
    }

    public void addNodeAtStart(int val){
        Node startNode = new Node(val);
        startNode.next = head;
        head = startNode;
    }

    public static void main(String[] args) {
        LinkedListCodePractice linkedList = new LinkedListCodePractice();
        linkedList.addNodeAtEnd(11);
        linkedList.addNodeAtEnd(22);
        linkedList.addNodeAtEnd(33);
        linkedList.addNodeAtEnd(44);
        linkedList.addNodeAtStart(55);
        linkedList.printLinkedList(head);
    }
}
