package com.book.algo.queue;

/**
 * 基于数组实现的队列
 */
public class ArrayQueue {
    
    private String[] items;
    private int n;
    private int head;
    private int tail;
    
    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }
    
    /**
     * 入队
     */
    public boolean enqueue(String element) {
        if (tail == n) {
            System.out.println("入队: " + element + "，队列已满");
            return false;
        }
        items[tail] = element;
        tail++;
        return true;
    }
    
    public String dequeue() {
        if (head == tail) {
            System.out.println("出队，队列为空");
            return null;
        }
        String item = items[head];
        head ++;
        return item;
    }
    
    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.printAll();
    
        String dequeue = arrayQueue.dequeue();
        System.out.println(dequeue);
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        
        arrayQueue.printAll();
    }
}
