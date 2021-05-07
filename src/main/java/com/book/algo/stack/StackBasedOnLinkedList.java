package com.book.algo.stack;

public class StackBasedOnLinkedList {
    
    private Node top;
    
    public void push(int value) {
        Node node = new Node(value, top);
        top = node;
    }
    
    public int pop() {
        if (top == null) {
            return -1;
        }
        int data = top.getData();
        top = top.next;
        System.out.println("Pop: " + data);
        return data;
    }
    
    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println("打印完毕");
    }
    
    private static class Node {
        private int data;
        private Node next;
    
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    
        public int getData() {
            return data;
        }
    }
    
    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(1);
        stack.push(2);
        stack.printAll();
        stack.pop();
        stack.printAll();
        stack.pop();
        stack.printAll();
    }
}
