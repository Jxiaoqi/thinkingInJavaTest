package com.book.algo.queue;

/**
 * 循环队列
 */
public class CircularQueue {
    private String items[];
    private int n;
    private int head;
    private int tail;
    
    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }
    
    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            System.out.println("入队，队列已满");
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }
    
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head =  (head + 1) % n;
        return item;
    }
    
    public void printAll() {
        if (n == 0) {
            return;
        }
        for (int i = head; i % n  != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(4);
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");
        circularQueue.enqueue("3");
    
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        circularQueue.enqueue("4");
    
        circularQueue.printAll();
    }
}
