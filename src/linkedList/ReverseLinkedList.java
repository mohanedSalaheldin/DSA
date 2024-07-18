package linkedList;

import java.util.*;

public class ReverseLinkedList {
    public static boolean hasCycle(ListNode head) {
//        Set<ListNode> hashSet = new HashSet<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast. next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return  true;
            }
        }
        return false;
    }



    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null; // Return null for an empty array
        }

        // Create the head node
        ListNode head = new ListNode(values[0]);
        ListNode currentNode = head;

        // Iterate through the rest of the values and create nodes
        for (int i = 1; i < values.length; i++) {
            currentNode.next = new ListNode(values[i]);
            currentNode = currentNode.next;
        }

        return head; // Return the head of the linked list
    }

    public static void printLinkedList(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;

        }
        System.out.println("null");
    }
//    public void removeItem(int data,ListNode head ){
//        ListNode current = head;
//        if (head.val == data){
//            head = head.next;
//        }else {
//            while (current.next !=null){
//                if (data == current.next.val){
//                    current.next = current.next.next;
//                    break;
//                }
//                current = current.next;
//            }
//        }
//    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode current = head;
        if (head.val == val){
            head = head.next;
        }else {
            while (current !=null){
                if (val == current.next.val){
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);
        printList(head);
        printList(removeElements(head, 6));


    }

}
