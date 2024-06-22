package linkedList;

public class LLRunner {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10);
        linkedList.addEnd(20);
        linkedList.addEnd(30);

//        linkedList.addEnd(20);
//        linkedList.addEnd(30);
        linkedList.display();
        linkedList.addAfter(30, 25);
        linkedList.display();
        linkedList.removeEnd();
        linkedList.display();

    }
}
