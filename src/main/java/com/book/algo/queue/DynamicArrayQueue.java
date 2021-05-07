package com.book.algo.queue;


/**
 * 基于动态数组实现的队列
 */
public class DynamicArrayQueue {
    private String items[];
    private int n;
    private int head;
    private int tail;
    
    public DynamicArrayQueue(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }
    
    public boolean enqueue(String element) {
        if (tail == n) {
            if (head == 0) {
                System.out.println("入队，队列已满");
                return false;
            }
            //数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
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
        ++head;
        return item;
    }
    
    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        DynamicArrayQueue arrayQueue = new DynamicArrayQueue(4);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
    
        System.out.println(arrayQueue.dequeue());
        arrayQueue.enqueue("5");
        arrayQueue.enqueue("6");
    
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    
        arrayQueue.enqueue("6");
        arrayQueue.enqueue("7");
        arrayQueue.printAll();
    }
 }
