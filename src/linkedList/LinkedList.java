package linkedList;


public class LinkedList {
    Node head;

    public LinkedList(int headData) {
        this.head = new Node(headData, null);
    }

    public void addEnd(int newNodeData){
        Node current = head;
        while (current.next !=null){
            current = current.next;
        }
        current.next =  new Node(newNodeData, null);
    }
    public void addStart(int newNodeData){
        Node newNode=  new Node(newNodeData, head);
        head = newNode;
    }


    public void removeEnd(){
        Node current = head;
        Node newEnd = head;
        while (current.next !=null){
            newEnd = current;
            current = current.next;
        }
        newEnd.next = null;
    }

    public void removeStart(){
        head = head.next;
    }

    public void removeItem(int data){
        Node current = head;
        if (head.data == data){
            removeStart();
        }else {
            while (current.next !=null){
                if (data == current.next.data){
                    current.next = current.next.next;
                    break;
                }
                    current = current.next;
            }
        }
    }
    public void addAfter(int targetData, int newNodeData){
        Node current = head;
        if (head.next == null){
            addEnd(newNodeData);
        } else {
            while (current !=null){
                if (targetData == current.data){
                    Node newNode = new Node(newNodeData, current.next);
                    current.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
    }



    public void display(){
        System.out.println();
        Node current = head;
        while (current !=null){
            System.out.print(current.data +"->");
            current = current.next;
        }
        System.out.println();
    }
}
