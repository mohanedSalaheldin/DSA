package StackAndQueue;

import java.util.*;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int size = q.size();
        q.add(x);
        for (int i = 0; i < size; i++) {
            int temp = q.poll();
            q.add(temp);
        }
    }

    public int pop() {
        Integer poll = q.poll();
        return poll;
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        List<Integer> temps = new ArrayList<>();
        while (!stack.isEmpty()){
            temps.add(stack.pop());
        }
        stack.add(x);
        for (int i = temps.size(); i > 0 ; i--) {
            stack.add(temps.get(i));
        }
    }

    public int pop() {
       return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}


class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek() ) {
            minStack.push(val);
        }else
            minStack.push(minStack.peek());
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

