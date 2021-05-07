package com.book.algo.queue;

public class QueueBasedOnLinkedList {
    
    private Node head;
    private Node tail;
    
    public boolean enqueue(String item) {
        if (tail == null) {
            tail = new Node(item, null);
            head = tail;
            return true;
        }
        Node node = new Node(item, null);
        tail.next = node;
        tail = tail.next;
        return true;
    }
    
    public String dequeue() {
        if (head == null) {
            System.out.println("出队，队列为空");
            return null;
        }
        String data = head.getData();
        head = head.next;
        if (head == null) {
            System.out.println("出队完毕");
            tail = null;
        }
        return data;
    }
    
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }
    
    
    public static class Node {
        private String data;
        private Node next;
    
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    
        public String getData() {
            return data;
        }
    }
    
    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue("1");
        queue.enqueue("2");
    
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printAll();
    }
}
