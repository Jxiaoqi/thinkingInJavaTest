package com.book.algo.linkedlist;

import java.util.Objects;
import java.util.Scanner;

/**
 * 基于单链表实现的LRU算法
 *
 * @param <T>
 */
public class LRUBaseLinkedList<T> {
    
    private static final int DEFAULT_CAPACITY = 8;
    
    /**
     * 链表的容量
     */
    private int capacity;
    /**
     * 链表的数据长度
     */
    private int length;
    /**
     * 链表的头节点
     */
    private SNode<T> headNode = null;
    
    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }
    
    public LRUBaseLinkedList(int capacity) {
        headNode = new SNode<T>();
        this.capacity = capacity;
        this.length = 0;
    }
    
    public T addData(T obj) {
        //1. 找到改该节点的前置节点，第一个节点的前置节点为头节点
        SNode preNode = findPreNodeByData(obj);
        //2. 前置节点不存在，插入节点
        if (Objects.isNull(preNode)) {
            //1. 容量已满，删除尾部节点，插入头部
            if (length == capacity) {
                deleteLastNode();
            }
            //2. 容量未满，插入头部
        } else {
            //3. 前置存在，移动到头部
            preNode.setNext(preNode.getNext().getNext());
            length--;
        }
        addHeadData(obj);
        return obj;
    }
    
    /**
     * 根据值找到对应节点的前置节点
     *
     * @param obj
     * @return
     */
    private SNode findPreNodeByData(T obj) {
        SNode sNode = headNode;
        while (sNode != null && sNode.getNext() != null) {
            if (sNode.next.getData().equals(obj)) {
                return sNode;
            }
            sNode = sNode.getNext();
        }
        return null;
    }
    
    /**
     * 插入头部元素
     *
     * @param data
     */
    private void addHeadData(T data) {
        SNode<T> tsNode = new SNode<>(data, headNode.getNext());
        headNode.setNext(tsNode);
        length++;
    }
    
    /**
     * 删除链表的尾节点
     */
    private void deleteLastNode() {
        //找到尾节点的前置节点
        SNode preNode = null;
        SNode sNode = headNode;
        while (Objects.nonNull(sNode) && Objects.nonNull(sNode.getNext())) {
            preNode = sNode;
            sNode = sNode.getNext();
        }
        //删除尾节点
        preNode.setNext(null);
        length--;
    }
    
    public void printAll() {
        SNode<T> headNode = this.headNode.getNext();
        StringBuilder sb = new StringBuilder();
        while (Objects.nonNull(headNode)) {
            sb.append(headNode.getData() + " ");
            headNode = headNode.getNext();
        }
        System.out.println(sb);
    }
    
    public static class SNode<T> {
        private T data;
        private SNode next;
        
        public SNode(T data, SNode next) {
            this.data = data;
            this.next = next;
        }
        
        public SNode() {
        }
        
        public SNode(SNode next) {
            this.next = next;
        }
        
        public T getData() {
            return data;
        }
        
        public void setData(T data) {
            this.data = data;
        }
        
        public SNode getNext() {
            return next;
        }
        
        public void setNext(SNode next) {
            this.next = next;
        }
        
        @Override
        public String toString() {
            return "SNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    
    public static void main(String[] args) {
//        testDefaultConstructor();
        testSpecialConstructor();
    }
    
    public static void testDefaultConstructor() {
        LRUBaseLinkedList<Integer> linkedList = new LRUBaseLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            linkedList.addData(scanner.nextInt());
            linkedList.printAll();
        }
    }
    
    public static void testSpecialConstructor() {
        LRUBaseLinkedList<Integer> linkedList = new LRUBaseLinkedList<>(2);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            linkedList.addData(scanner.nextInt());
            linkedList.printAll();
        }
    }
    
}
