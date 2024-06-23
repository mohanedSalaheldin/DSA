package linkedList;

import java.util.Stack;

public class ReverseLinkedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null){
            tail.next = list1;
        }else  if (list2 != null){
            tail.next = list2;
        }
//        System.out.println("------------------------(RESILT)------------------------");
//        display(dummy.next);
        return  dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,null);
        ListNode n1 = new ListNode(2,null);
        ListNode n2 = new ListNode(4,null);
        head1.next = n1;
        n1.next = n2;

        ListNode head2 = new ListNode(1,null);
        ListNode m1 = new ListNode(3,null);
        ListNode m2 = new ListNode(4,null);
        head2.next = m1;
        m1.next = m2;
//        ListNode n3 = new ListNode(4,null);
//        ListNode n4 = new ListNode(5,null);

//        n2.next = n3;
//        n3.next = n4;


//        reverseList(head);
        mergeTwoLists(head1,head2);

    }

    public static void display(ListNode head){
        System.out.println();
        ListNode current = head;
        while (current !=null){
            System.out.print(current.val +"->");
            current = current.next;
        }
        System.out.println();
    }
}
