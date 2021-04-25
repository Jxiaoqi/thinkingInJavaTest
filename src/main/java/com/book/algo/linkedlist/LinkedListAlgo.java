package com.book.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 链表反转,四个方法
 * 2. 检查链表中是否有环
 *      1）快慢指针
 *      2）足迹法
 * 3. 查找有环链表的入口节点
 * 4. 合并两个有序链表
 * 5. 删除倒数第K个元素
 *      1）计数
 *      2）快慢指针
 * 6. 寻找中间节点
 */
public class LinkedListAlgo {
    
    /**
     * 反转链表：迭代反转法
     *
     * @param head
     * @return
     */
    public static Node iterationReverse(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node mid = head;
        Node end = head.next;
        while (end != null) {
            mid.next = pre;
            
            pre = mid;
            mid = end;
            end = end.next;
        }
        mid.next = pre;
        return mid;
    }
    
    /**
     * 反转链表：递归反转法
     *
     * @param head
     * @return
     */
    private static Node recursiveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    
    /**
     * 反转链表： 本地逆置法
     *
     * @param head
     * @return
     */
    private static Node localReverse(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = head;
        Node pre = head;
        Node mid = head.next;
        while (mid != null) {
            pre.next = mid.next;
            
            mid.next = newHead;
            newHead = mid;
            mid = pre.next;
        }
        return newHead;
    }
    
    /**
     * 反转链表： 头插法，和本地逆置法的区别是需要新建一个链表，在头部插入
     *
     * @param head
     * @return
     */
    private static Node headInsertReverse(Node head) {
        if (head == null) {
            return head;
        }
        Node newHead = null;
        Node pre = head;
        Node mid = head.next;
        while (mid != null) {
            pre.next = newHead;
            
            newHead = pre;
            pre = mid;
            mid = mid.next;
        }
        
        pre.next = newHead;
        newHead = pre;
        return newHead;
    }
    
    /**
     * 判断链表中是否有环，快慢指针法
     * https://zhuanlan.zhihu.com/p/103626709
     *
     * @return
     */
    public static boolean checkCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断链表中是否有环，足迹法
     * https://zhuanlan.zhihu.com/p/103626709
     *
     * @param head
     * @return
     */
    public static boolean checkCircleV2(Node head) {
        Map<Node, Integer> nodeMap = new HashMap<>();
        int count = 0;
        Node p = head;
        while (p != null) {
            if (nodeMap.containsKey(p)) {
                return true;
            }
            nodeMap.put(p, count++);
            p = p.next;
        }
        return false;
    }
    
    /**
     * 查找链表中环的起始节点
     *
     * @return
     */
    public static Node findCircleStart(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        //快慢指针寻找相遇节点，此处寻找相遇节点的起始点都应该从头元节点开始，不然会出现不满足公式 1，2，3，4，5 -》 3这种有环链表死循环
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //链表中不存在环
        if (fast == null || fast.next == null) {
            return null;
        }
        
        //一个节点从开始遍历，一个节点从相遇节点开始遍历，相遇节点即为环的起始节点
        Node start = head;
        while (true) {
            if (start == slow) {
                break;
            }
            start = start.next;
            slow = slow.next;
        }
        return start;
    }
    
    /**
     * 合并两个有序链表
     *
     * @param nodeList1
     * @param nodeList2
     * @return
     */
    public static Node mergeTwoLists(Node nodeList1, Node nodeList2) {
        //利用哨兵节点简化
        Node head = new Node(Integer.MIN_VALUE, null);
        Node node = head;
        while (nodeList1 != null && nodeList2 != null) {
            if (nodeList1.data <= nodeList2.data) {
                node.next = nodeList1;
                nodeList1 = nodeList1.next;
            } else {
                node.next = nodeList2;
                nodeList2 = nodeList2.next;
            }
            node = node.next;
        }
        if (nodeList1 == null) {
            node.next = nodeList2;
        }
        if (nodeList2 == null) {
            node.next = nodeList1;
        }
        //去除哨兵
        head = head.next;
        return head;
    }
    
    /**
     * 删除倒数第K个节点
     * 加入哨兵，减少第一个节点的判断
     *
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        if (k < 1) {
            return list;
        }
        //算链表长度
        int i = 0;
        Node head = list;
        while (head != null) {
            i++;
            head = head.next;
        }
        
        if (k > i) {
            return list;
        }
        //前置节点的下标 4 - 3 -1 = 0
        int preI = i - k;
        //加入哨兵节点，简化删除第一个节点
        Node newHead = new Node(0, list);
        Node p = newHead;
        while (preI-- > 0) {
            p = p.next;
        }
        
        p.next = p.next.next;
        return newHead.next;
    }
    
    /**
     * 删除链表中倒数第K个节点
     * 快慢指针法，先丈量K个节点，然后快慢指针向后移动
     *
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKthV2(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast.next != null && i < k) {
            i++;
            fast = fast.next;
        }
        //长度不够K
        if (i < k - 1) {
            return list;
        }
        //倒数第K个节点的前置节点
        Node pre = null;
        Node slow = list;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            list = slow.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }
    
    /**
     * 寻找链表的中间节点
     * 快慢指针法：奇数节点返回中间节点， 偶数节点返回偏右中间节点
     *
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public static void printAll(Node head) {
        Node p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.getData() + " ");
            p = p.next;
        }
        System.out.println(sb);
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
        Node node = new Node(1, new Node(2, new Node(3, null)));
//        Node node1 = iterationReverse(null);
//        Node node1 = recursiveReverse(null);
//        Node node1 = localReverse(null);
        Node node1 = headInsertReverse(node);
        printAll(node1);
        
        
        Node node3 = new Node(3, null);
        Node node5 = new Node(5, node3);
        node3.next = new Node(4, node5);
        Node circle = new Node(1, new Node(2, node3));
        
        System.out.println(checkCircle(circle));
        System.out.println(checkCircle(node));
        Node node2 = new Node(1, null);
        System.out.println(checkCircle(node2));
        
        System.out.println(checkCircleV2(circle));
        System.out.println(checkCircleV2(node));
        
        Node circleStart = findCircleStart(circle);
        System.out.println(circleStart.data);
        
        Node nodeList1 = new Node(1, new Node(3, new Node(5, new Node(7, null))));
        Node nodeList2 = new Node(2, new Node(3, new Node(6, null)));
        Node node4 = mergeTwoLists(nodeList1, nodeList2);
        printAll(node4);
        printAll(nodeList1);
        
        Node list1 = new Node(1, new Node(2, new Node(3, new Node(4, null))));
//        Node node6 = deleteLastKth(list1, 4);
        Node node6 = deleteLastKthV2(list1, 4);
        printAll(node6);
        
        Node middleNode = findMiddleNode(list1);
        printAll(middleNode);
        
        Node node7 = new Node(1, new Node(2, new Node(3, null)));
        Node middleNode1 = findMiddleNode(node7);
        printAll(middleNode1);
    }
}
