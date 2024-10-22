package com.onkar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// BFS - breadth first search.
public class Graph1 {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Algorithm-
    // 1. Create a Queue and visited array and add 1st vertex in the queue.
    // 2. while queue is not empty, remove the vertex from the queue.
    // 3. If the value of the vertex in the visited array is false then print the vertex and mark it true.
    // 4. Add the neighbours of the vertex in the queue.
    // Time Complexity O(V + E)
    public static void BFS(ArrayList<Edge> graph[], boolean visted[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (visted[curr] == false) {
                System.out.print(curr + " ");
                visted[curr] = true;
            }
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }

    // DFS
    // Algorithm:
    // 1.Create a visited array of type boolean. Call the DSF function and pass the visited array and current node value.
    // 2.print the current node.
    // 3.visited[current] = true.
    // 4.Call the DSF with the current value as destination of the previous node.
    // Time Complexity O(V+E)
    public static void DFS(ArrayList<Edge> graph[], boolean visited[], int curr) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visited[e.dest] == false) {
                DFS(graph, visited, e.dest);
            }
        }
    }

    // problem:1
    // Time Complexity O(V^V)
    // All paths from source to target.
    // Algorithm:
    // 1. Create a method printAllPaths which takes arguments graph,boolean visited array, src,target,path.
    // 2. If src == target --> print the path and return.
    // 3. Find the neighbour of the src, if neighbour not visited, make its value true in visited array and call printAllPaths method and pass the next arguments.
    // 4. Once the src == target, during the back track mark the visited array value false.
    public static void printAllPaths(ArrayList<Edge> graph[], boolean visited[], int src, int target, String path){
        if (src == target) {
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(visited[e.dest] == false){
                visited[src] = true;
                printAllPaths(graph,visited,e.dest,target,path+"->"+e.dest);
                visited[src] = false;
            }
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visited[] = new boolean[v];
        /*for(int i=0; i<v; i++){
            if(visited[i] == false){
                BFS(graph,visited,i);
            }
        }

        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                DFS(graph, visited, 0);
            }
        }*/

        int src = 0;
        int tar = 5;
        printAllPaths(graph,visited,src,tar,"0");

    }
}
