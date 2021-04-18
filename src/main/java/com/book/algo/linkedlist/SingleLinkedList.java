package com.book.algo.linkedlist;

import javax.xml.crypto.dsig.SignedInfo;

/**
 * 单链表的查找、插入、删除
 * 1. 判断是否是回文链表
 * 2. 链表反转
 * 1）. 迭代遍历法，无头链表
 * 2）. 头插法，有头链表
 */
public class SingleLinkedList {
    
    private Node head = null;
    
    /**
     * 链表查找，根据值查找链表
     * TODO 值重复的链表查找
     *
     * @param value
     * @return
     */
    private Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }
    
    /**
     * 链表查找，根据下表查找链表
     *
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }
    
    /**
     * 链表头部插入
     * 1. 无头节点，直接插入
     * 2. 表头部插入
     *
     * @param value
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }
    
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    /**
     * 链表尾部插入
     *
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            //先找到尾节点
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }
    
    /**
     * 链表插入，在某节点后插入值
     *
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }
    
    /**
     * 链表插入，在某节点后插入节点
     *
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }
    
    /**
     * 链表插入，某节点前插入某值
     *
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }
    
    /**
     * 链表插入，某节点前插入某节点
     *
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        //无头节点插入
        if (p == head) {
            insertToHead(newNode);
        } else {
            //有头节点插入
            //查找P节点的前置节点
            Node q = head;
            while (q != null && q.next != p) {
                q = q.next;
            }
            if (q == null) {
                return;
            }
            newNode.next = p;
            q.next = newNode;
        }
    }
    
    /**
     * 删除节点
     *
     * @param p
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        //TODO 上次这个写错了
        if (p == head) {
            head = head.next;
            return;
        }
        //查找p的前置节点
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = p.next;
    }
    
    /**
     * 按值删除节点
     *
     * @param value
     */
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        //查找该值所在节点的前置节点
        Node p = head;
        //前置节点
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        
        if (q == null) {
            //查找的节点为头节点
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }
    
    /**
     * 判断链表是否是回文链表
     * 1. 找到中间节点
     * 2. 反转链表
     * 3. 循环比较
     *
     * @return
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        }
        System.out.println("开始寻找中间节点");
        //1. 找到中间节点,一步两步法
        Node p = head;
        Node q = head;
        if (q.next == null) {
            System.out.println("链表只有一个节点");
            return true;
        }
        while (q.next != null && q.next.next != null) {
            //走一步
            p = p.next;
            //走两步
            q = q.next.next;
        }
        
        Node leftLink = null;
        Node rightLink = null;
        if (q.next == null) {
            //奇数长度的链表，p为中间节点
            System.out.println("奇数长度的链表， 中间节点为：" + p.data);
            //2. 反转链表
            leftLink = inverseLinkedList(p).next;
            rightLink = p.next;
        } else {
            //偶数长度的链表 p 和 p.next 均为中间节点
            System.out.println("偶数长度的链表，中间节点为：" + p.data);
    
            rightLink = p.next;
            leftLink = inverseLinkedList(p);
            
            //TODO 错误解法，先翻转左边，偶数链表会修改了p节点，例如 1 2 3 3 2 1， 反转后为p为 3 2 1, 然后再取右边链表就有问题
//            leftLink = inverseLinkedList(p);
//            rightLink = p.next;
        }
        return TFResult(leftLink, rightLink);
    }
    
    /**
     * 反转链表， 迭代反转法
     * 无头结点的链表翻转：反转以后是无头链表
     * http://c.biancheng.net/view/8105.html
     *
     * @param p
     * @return
     */
    public Node inverseLinkedList(Node p) {
        if (p == null) {
            return null;
        }
        Node pre = null;
        Node r = head;
        Node next = null;
        while (r != p) {
            next = r.next;
            
            r.next = pre;
            pre = r;
            r = next;
        }
        
        r.next = pre;
        return r;
    }
    
    /**
     * 链表反转，迭代反转法
     * http://c.biancheng.net/view/8105.html
     *
     * @param Head
     * @return
     */
    public Node iterationReverse(Node Head) {
        //只有一个节点
        if (Head == null || Head.next == null) {
            return Head;
        }
        Node beg = null;
        Node mid = Head;
        Node end = Head.next;
        while (true) {
            mid.next = beg;
            if (end == null) {
                break;
            }
            //三个指针整体向后移动一位
            beg = mid;
            mid = end;
            end = end.next;
        }
        Head = mid;
        return Head;
    }
    
    /**
     * 链表反转，反转为带头链表
     * 头插法, 新建一个链表，逐渐把原链表节点从头部插入
     * http://c.biancheng.net/view/8105.html
     *
     * @return
     */
    public Node inverseLinkList_head(Node p) {
        Node Head = new Node(999, null);
        Head.next = p;
        Node Cur = p.next;
        p.next = null;
        Node next = null;
        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            
            Cur = next;
        }
        return Head;
    }
    
    /**
     * 反转链表：递归法，反转无头链表
     * http://c.biancheng.net/view/8105.html
     *
     * @return
     */
    public Node recursiveReverse(Node Head) {
        if (Head == null || Head.next == null) {
            return Head;
        }
        Node newHead = recursiveReverse(Head.next);
        Head.next.next = Head;
        Head.next = null;
        return newHead;
    }
    
    /**
     * 就地逆置法反转链表，与头插法的区别
     * http://c.biancheng.net/view/8105.html
     *
     * @param Head
     * @return
     */
    public Node localReverse(Node Head) {
        //空链表或者是链表只有一个节点
        if (Head == null || Head.next == null) {
            return Head;
        }
        Node beg = Head;
        Node end = Head.next;
        while (end != null) {
            beg.next = end.next;
            end.next = Head;
            Head = end;
            end = beg.next;
        }
        return Head;
    }
    
    /**
     * 判断两个链表是否相同
     *
     * @param left  首节点
     * @param right 首节点
     * @return
     */
    public boolean TFResult(Node left, Node right) {
        if (left == null || right == null) {
            return false;
        }
        Node l = left;
        Node r = right;
        while (l != null && r != null) {
            if (l.data != r.data) {
                System.out.println("链表中不相同的节点 l=" + l.data + ",r=" + r.data);
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }
    
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    
    public static class Node {
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
        SingleLinkedList singleLinkedList = new SingleLinkedList();
    
        int[] data = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < data.length; i++) {
            singleLinkedList.insertTail(data[i]);
        }
        singleLinkedList.printAll();
    
//        Node byIndex = singleLinkedList.findByIndex(2);
//        System.out.println(byIndex.data);
//
//        Node byValue = singleLinkedList.findByValue(3);
//        System.out.println(byValue.data);
//
//        singleLinkedList.insertToHead(6);
//        singleLinkedList.printAll();
//
//        singleLinkedList.insertToHead(new Node(7, null));
//        singleLinkedList.printAll();
//
//        singleLinkedList.insertTail(8);
//        singleLinkedList.printAll();
        
//        singleLinkedList.insertAfter(byValue, 9);
//        singleLinkedList.printAll();
        
//        singleLinkedList.insertAfter(byValue, new Node(9, null));
//        singleLinkedList.printAll();
        
//        singleLinkedList.insertBefore(byValue, new Node(9, null));
//        singleLinkedList.printAll();
        
//        singleLinkedList.insertBefore(byValue, 9);
//        singleLinkedList.printAll();
    
//        Node byIndex1 = singleLinkedList.findByIndex(1);
//        singleLinkedList.deleteByNode(byIndex1);
    
//        singleLinkedList.deleteByValue(1);
//        System.out.println("是回文链表:" + singleLinkedList.palindrome());
    
//        Node byIndex1 = singleLinkedList.findByIndex(2);
//        Node node = singleLinkedList.iterationReverse(byIndex1);

//        Node byIndex1 = singleLinkedList.findByIndex(2);
//        Node node = singleLinkedList.recursiveReverse(byIndex1);
    
//        Node byIndex1 = singleLinkedList.findByIndex(2);
//        Node node = singleLinkedList.inverseLinkList_head(byIndex1);
    
        Node byIndex1 = singleLinkedList.findByIndex(2);
        Node node = singleLinkedList.localReverse(byIndex1);
        singleLinkedList.printAll();
    }
}