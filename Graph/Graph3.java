package com.onkar;

import java.util.ArrayList;
import java.util.Stack;

// Topological Sorting.
public class Graph3 {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Time Complexity O(V + E).
    // Algorithm:
    // 1. Create a method topSort with arguments graph,visited array,current node and stack.
    // 2. Mark current node value in visited array true.
    // 3. Find the neighbour of the node if neighbour not visited then call the topSort method and add the last recursive call node in the stack.
    // 4. Else add the current node value in the stack.
    public static void topSort(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> stack){
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph,visited,e.dest,stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<v; i++){
            if(!visited[i]){
                topSort(graph,visited,i,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
