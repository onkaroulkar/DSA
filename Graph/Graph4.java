package com.onkar;
import java.util.ArrayList;

public class Graph4 {

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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }

    // Cycle detection in undirected graph.
    // Algorithm:
    // 1.Create a method isCycleUndirected with argument graph,boolean array visited,current node and parent index.
    // 2.Mark the value of the current node in visited array true.
    // 3.Find the neighbours of the current node.
    // 4.If neighbour of the current node not visited then call the isCycleUndirected method.
    // 5.If neighbour is visited and neighbour is not equal to the parent then return true.
    // 6.If node doesn't have the neighbour then return false.
    // Time Complexity O(V + E)
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean visited[], int curr,int parent){
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                if(isCycleUndirected(graph,visited,e.dest,curr)){
                    return true;
                }
            }else if(visited[e.dest] == true && e.dest != parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visited[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visited[i]){
                System.out.println(isCycleUndirected(graph,visited,i,-1));

            }
        }
    }
}
