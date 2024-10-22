package com.onkar;
import java.util.ArrayList;

public class Graph2 {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Cycle detection is directed graph.
    // Time Complexity O(V + E).
    // Algorithm:
    // 1.Crate a graph,boolean type visited and recursion stack array.
    // 2.Mark current node value true in visited and recursion stack array.
    // 3.Find the neighbour of the node check neighbour is already marked as ture in recursion stack then return true else give recursive call to the method.
    // 4.If no cycle detect then return false.
    public static boolean isCycleDetected(ArrayList<Edge> graph[], boolean visited[], int curr, boolean rect[]){
        visited[curr] = true;
        rect[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rect[e.dest] == true){
                return true;
            }
            else if(!rect[e.dest]){
                if(isCycleDetected(graph,visited,e.dest,rect)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }
    public static void main(String[] args) {

        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visited[] = new boolean[v];
        System.out.println(isCycleDetected(graph,visited,0,new boolean[v]));
    }
}
