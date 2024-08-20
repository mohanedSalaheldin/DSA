package linkedList;

import java.util.*;

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return  head;
    }


    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode mid = findMiddle(head);
        ListNode secondNode = mid.next;
        secondNode = reverseList(secondNode);
        ListNode cur1 = head;
        ListNode cur2 = secondNode;
        while(cur1!=null && cur2!=null){
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return  head;
    }

    //*********************************************************************************
    public static ListNode findMiddle(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public  static ListNode merge(ListNode head1, ListNode head2) {
         ListNode dNode = new ListNode(-1);
         ListNode temp = dNode;
         ListNode t1 = head1;
         ListNode t2 = head2;
         while (t1!=null || t2!=null){
             if (t1.val < t2.val){
                 temp.next = t1;
                 t1= t1.next;
             }else {
                 temp.next = t2;
                 t2= t2.next;
             }
             temp = temp.next;
         }
         if (t1!=null){
             temp.next = t1;
         }if (t2!=null){
            temp.next = t2;
        }

        return  dNode.next;
    }

    public  static ListNode sortList(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode head1 = head;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        List<ListNode> listNodes = new ArrayList<>();
        while (temp1!=null){
            listNodes.add(temp1);
            temp1= temp1.next;
        }
        temp1 = headB;
        while (temp1!=null){
            if (listNodes.contains(temp1)){
                return temp1;
            }
            temp1= temp1.next;
        }
        return null;
    }
    public static Node segregate(Node head) {
        Node dZero = new Node(-1);
        Node dOne = new Node(-1);
        Node dTwo = new Node(-1);
        Node l0 = dZero;
        Node l1 = dOne;
        Node l2 = dTwo;
        Node temp = head;

        while (temp!=null){
            if (temp.data==0){
                l0.next = temp;
                l0 = l0.next;
            } else if (temp.data == 1){
                l1.next = temp;
                l1 = l1.next;
            }else{
                l2.next = temp;
                l2 = l2.next;
            }
            temp= temp.next;
        }

        l0.next = dOne.next!=null ? dOne.next : dTwo.next;
        l1.next = dTwo.next;
        l2.next = null;

        return dOne.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static int additionHelper(Node temp){
        if (temp == null)
            return 1;
        int curry = additionHelper(temp.next);
        temp.data = temp.data + 1;
        if (temp.data < 10)
            return 0;
        temp.data = 0;
        return 1;
    }
    public static Node addOne(Node head) {
        int curry = additionHelper(head);
        if (curry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dommy = new ListNode(-1);
        ListNode cur = dommy;

        int curry = 0;
        while (t1!=null || t2!=null){
            int sum = 0;
            if (t1 != null) {
                sum += t1.val ;
                t1 = t1.next;
            }
            if (t2 != null) {
                sum += t2.val ;
                t2 = t2.next;
            }
            sum+=curry;
            curry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
        }
        return  dommy.next;
    }
}
