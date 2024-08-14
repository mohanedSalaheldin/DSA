package linkedList;

import java.util.HashMap;
import java.util.Map;

public class NewProblems {
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&& fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;


        }
        return slow;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;

    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null \n");
    }
    public static void main(String[] args) {
        ListNode newNode = new ListNode(1, null);
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(3, null);
        printList(head);
        ListNode cur = head.next;
        detectCycle(head);

    }

    public static ListNode detectCycle(ListNode head) {
        Map<Integer, Integer> hp = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        while (cur!=null){
            System.out.println(cur.val);
            if (hp.containsValue(cur.val)){
                return cur;
            }else{
                hp.put(index, cur.val);
                index++;
                cur = cur.next;
            }
        }
        return null;
    }



}
