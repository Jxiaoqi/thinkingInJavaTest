package com.book.algo;

import javax.xml.ws.FaultAction;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    /**
     * 顶点个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];
    
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    /**
     * 添加一条边，无向图一条边存两次
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
    
    /**
     * 广度优先搜索
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] pre = new int[v];
        queue.add(s);
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        while (!queue.isEmpty()) {
            Integer w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                Integer q = adj[w].get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        //打印
                        print(pre, s, t);
                        return;
                    }
                    queue.add(q);
                    visited[q] = true;
                }
            }
        }
    }
    
    boolean found = false;
    
    /**
     * 深度优先搜索
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        recurDfs(s, t, visited, pre);
        print(pre, s, t);
    }
    
    private void recurDfs(int s, int t, boolean[] visited, int[] pre) {
        if (found) {
            return;
        }
        if (s == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[s].size(); i++) {
            Integer w = adj[s].get(i);
            if (!visited[w]) {
                visited[w] = true;
                pre[w] = s;
                recurDfs(w, t, visited, pre);
            }
        }
    }
    
    public void print(int[] pre, int s, int t) {
        if (pre[t] != -1 && s != t) {
            print(pre, s, pre[t]);
        }
        System.out.print(t + " ");
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
//        graph.bfs(0, 6);
        graph.dfs(0, 6);
        
    }
}
