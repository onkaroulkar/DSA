package com.onkar;

import java.util.ArrayList;

public class TarjanAlgo {

    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph []){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }
    public static void getAp(ArrayList<Edge> graph[], int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        int time =0;
        boolean vis[] = new boolean[v];
        boolean ap[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs()
            }
        }

        for(int i=0; i<v; i++){
            if(ap[i]){
                System.out.println("ap :"+ap[i] );
            }
        }
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
    }
}
