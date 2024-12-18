package com.onkar;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void creatGraph(ArrayList<Edge> graph []){

        for(int i=0;i< graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));


    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;    // ascending
        }
    }

    // Time Complexity O(ElogE)
    // Algorithm:
    // Crete a priority queue and store the pair of node and its cost. Priority queue decides the priority based on the cost.
    // Create the boolean visited array also add the first pair in the queue.
    // Initially the cost is zero.
    // Till the queue is not empty, remove the pair from queue if node is not visited then make it visited in visited array also add the cost of the edge.
    // Find the neighbour of the node if the neighbour node is not visited then add the destination node and its weight in the queue.
    public static void primsAlgo(ArrayList<Edge> graph[], int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[v];
        pq.add(new Pair(0,0));
        int mstCost = 0;
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost += curr.cost;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }

        System.out.print("mstCost is " + mstCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatGraph(graph);
        primsAlgo(graph,V);
    }
}
