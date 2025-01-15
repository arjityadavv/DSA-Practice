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

    public void deleteNodeAtEnd(){
        Node current = head;
        Node prev = null;
        while(current!=null){
            if(current.next==null){
                prev.next = null;
                break;
            }else {
                prev = current;
                current = current.next;
                continue;
            }
        }
    }

    public void deleteNoteAtStart(){
        Node current = head;
        if(current!=null){
            if(current.next!=null){
                Node next_node = current.next;
                head = next_node;
                current.next = null;
            }else{
                head = null;
                tail = null;
            }
        }else {
            System.out.println("There is no node present, nothing will be deleted.");
        }

    }

    public void deleteNodeAtGivenIndex(int index){
        Node current = head;
        int count = 1;
        if(index==1){
            deleteNoteAtStart();
        }else{
            Node before = null;
            Node after = null;
            Node deleted = null;
            while(current!=null){
                if(count==index-1){
                    before = current;
                } else if(count==index){
                    deleted = current;
                    if(current.next!=null){
                        after = current.next;
                    }else{
                        after = null;
                    }

                }
                current = current.next;
                count++;
            }
            before.next = after;
            if(after!=null){
                after.next = null;
                deleted.next = null;
            }
        }
    }

    public void deleteTheEvenValueNode(){
        Node current = head;
        int count = 1;
        while(current!=null){
            if(current.val%2==0){
                deleteNodeAtGivenIndex(count);
                count = 1;
            }else{
                count++;
            }
            current = current.next;
        }
    }

    public Node reverseLinkedList(){
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode = null;
        while(currentNode!=null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        LinkedListCodePractice linkedList = new LinkedListCodePractice();
        linkedList.addNodeAtEnd(11);
        linkedList.addNodeAtEnd(22);
        linkedList.addNodeAtEnd(33);
        linkedList.addNodeAtEnd(44);
        linkedList.addNodeAtStart(55);
        System.out.println(">>>>>>>>>>>>>>>>>");
        linkedList.printLinkedList(head);
        System.out.println(">>>>>>>>>>>>>>>>>");
        linkedList.addNodeAtGivenIndex(99, 4);
        linkedList.printLinkedList(head);
        System.out.println(">>>>>>>>>>>>>>>>>");
        linkedList.deleteNodeAtEnd();
        linkedList.deleteNodeAtEnd();
        linkedList.printLinkedList(head);
        System.out.println(">>>>>>>>>>>>>>>>>");
        linkedList.deleteNoteAtStart();
        linkedList.printLinkedList(head);
        System.out.println(">>>>>>>>>>>>>>>>>");
        linkedList.deleteNodeAtGivenIndex(4);
        linkedList.printLinkedList(head);
        System.out.println(">>>>>>>>>>>>>>>>>");
        linkedList.deleteTheEvenValueNode();
        linkedList.printLinkedList(head);
        System.out.println(">>>>>>>>>>>>>>>>>");
        Node startNode = linkedList.reverseLinkedList();
        linkedList.printLinkedList(startNode);
    }
}
