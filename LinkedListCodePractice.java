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
        if(head==null){
            head = startNode;
            tail = startNode;
        }
        startNode.next = head;
        head = startNode;
    }

    public void addNodeAtGivenIndex(int val, int index){
        int count = 1;
        Node current = head;
        Node newNode = new Node(val);
        while(current!=null && count!=index-1){
            current = current.next;
            count++;
        }
        if(current==null){
            if(index==1){
                addNodeAtEnd(val);
            }else{
                System.out.println("Can't add as Linked List Empty or Index value is wrong");
            }
        }else{
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    public static void main(String[] args) {
        LinkedListCodePractice linkedList = new LinkedListCodePractice();
        linkedList.addNodeAtEnd(11);
        linkedList.addNodeAtEnd(22);
        linkedList.addNodeAtEnd(33);
        linkedList.addNodeAtEnd(44);
        linkedList.addNodeAtStart(55);
        linkedList.printLinkedList(head);
        linkedList.addNodeAtGivenIndex(99, 4);
        linkedList.printLinkedList(head);
    }
}
