package com.book.algo.tree;


import javax.management.MXBean;
import javax.sound.midi.Soundbank;
import java.util.TreeMap;

/**
 * 二叉查找树
 */
public class BinarySearchTree {
    
    private Node tree;
    
    public Node find(int data) {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }
    
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { //data <= p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
        
    }
    
    public void delete(int data) {
        if (tree == null) {
            return;
        }
        Node p = tree;
        //父节点
        Node pp = tree;
        while (p != null && p.data != data) {
            pp = p;
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        
        //p 有两个节点
        if (p.left != null && p.right != null) {
            //找到右子树中最小的节点
            Node minP = p.right;
            Node minPp = p;
            while (minP != null && minP.left != null) {
                minPp = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPp;
        }
    
        // 删除节点是叶子节点或者仅有一个子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }
    
    public Node findMin() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
    
    public Node findMax() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    
    public static class Node {
        private int data;
        private Node left;
        private Node right;
    
        public Node(int data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        /**
         *
         7
         4     20
         3  5  15  25
         14 16
         */
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node11 = new Node(11);
    
        Node node4 = new Node(4);
        node4.left = node3;
        node4.right = node5;
    
        Node node10 = new Node(10);
        node10.left = node6;
        node10.right = node11;
    
        Node node7 = new Node(7);
        node7.left = node4;
        node7.right = node10;
    
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.tree = node7;
    
        Node node = binarySearchTree.find(4);
        System.out.println(node.data);
        System.out.println(node.left.data);
    
//        binarySearchTree.insert(12);
//        System.out.println(binarySearchTree.tree.right.right.right.data);
        
//        binarySearchTree.delete(4);
//        System.out.println(binarySearchTree.tree.left.data);
    
        Node min = binarySearchTree.findMin();
        System.out.println(min.data);
    
        Node max = binarySearchTree.findMax();
        System.out.println(max.data);
    }
}
