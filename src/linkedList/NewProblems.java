package linkedList;

public class NewProblems {

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null \n");
    }
    public static void main(String[] args) {
        Node newNode = new Node(1, null);
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        printList(head);
        Node cur = head.next;
        Node prev = head;
        while( cur.next !=null){
            cur.data = cur.next.data;
            prev = cur;
            cur = cur.next;
        }
        System.out.println(prev.next);
        prev .next = null;
        printList(head);
    }



}
