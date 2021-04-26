package com.book.algo.stack;

/**
 * 基于链表实现的链式栈
 * 利用链式栈实现浏览器的前进后退功能
 */
public class SampleBrowser {
    
    public static void main(String[] args) {
        SampleBrowser sampleBrowser = new SampleBrowser();
        sampleBrowser.open("http://www.baidu.com");
        sampleBrowser.open("http://news.baidu.com/");
        sampleBrowser.open("http://news.baidu.com/ent");
        sampleBrowser.goBack();
        sampleBrowser.goBack();
        sampleBrowser.goForward();
        sampleBrowser.goForward();
        sampleBrowser.goBack();
        
        sampleBrowser.open("http://www.google.com");
        sampleBrowser.goForward();
        sampleBrowser.checkCurrentPage();
    }
    
    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;
    
    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }
    
    public void open(String url) {
        if (this.currentPage != null) {
            backStack.push(currentPage);
        }
        this.currentPage = url;
        forwardStack.clear();
        showUrl(url, "Open");
    }
    
    public boolean canGoBack() {
        return backStack.size() > 0;
    }
    
    public boolean canGoForward() {
        return forwardStack.size() > 0;
    }
    
    public String goBack() {
        if (!canGoBack()) {
            return null;
        }
        if (this.currentPage != null) {
            forwardStack.push(currentPage);
        }
        String pop = backStack.pop();
        this.currentPage = pop;
        showUrl(pop, "Back");
        return pop;
    }
    
    public String goForward() {
        if (!canGoForward()) {
            return null;
        }
        if (this.currentPage != null) {
            backStack.push(currentPage);
        }
        String pop = forwardStack.pop();
        this.currentPage = pop;
        showUrl(pop, "Forward");
        return pop;
    }
    
    public void showUrl(String url, String prefix) {
        System.out.println(prefix + " url = " + url);
    }
    
    public void checkCurrentPage() {
        System.out.println("Current page is " + this.currentPage);
    }
    
    public static class LinkedListBasedStack {
        
        public static void main(String[] args) {
            LinkedListBasedStack stack = new LinkedListBasedStack();
            stack.push("1");
            stack.push("2");
            stack.push("3");
            stack.push("4");
            stack.print();
            
            System.out.println(stack.pop());
            
            stack.print();
            
            System.out.println(stack.getTopData());
        }
        
        private int size;
        private Node top;
        
        private Node createNode(String data, Node next) {
            return new Node(data, next);
        }
        
        public void clear() {
            this.size = 0;
            this.top = null;
        }
        
        public void push(String data) {
            Node node = createNode(data, top);
            this.top = node;
            this.size++;
        }
        
        public String pop() {
            String topData = getTopData();
            top = top.next;
            return topData;
        }
        
        public String getTopData() {
            if (size() <= 0) {
                return null;
            }
            return top.getData();
        }
        
        public int size() {
            return this.size;
        }
        
        public void print() {
            System.out.println("Print stack:");
            Node current = this.top;
            while (current != null) {
                String data = current.getData();
                System.out.print(data + "\t");
                current = current.next;
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
            
            public void setData(String data) {
                this.data = data;
            }
            
            public Node getNext() {
                return next;
            }
            
            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}
