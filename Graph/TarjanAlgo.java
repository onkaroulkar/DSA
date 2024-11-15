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

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[],
                           boolean vis[], int time, boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(par == neigh){
                continue;
            }else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            }else{
                dfs(graph,neigh,curr,dt,low,vis,time,ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(dt[curr] <= low[neigh] && par != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children > 1){
            ap[curr] = true;
        }
    }

    // Time complexity O(E + V)
    // Algorithm:
    // 1. Create discovery time, lower discovery time, visited and articulation point array of size v.
    // 2. If node is not visited then apply the dfs on the node.
    // 3. Mark the visited of the current node true. Initially discovery time and low discovery time is same also the children count is zero.
    // 4. Find the neighbour of the current node.
    // 5. If the destination node is the parent of the current node then continue.
    // 6. If destination node is visited then compare the lower discovery time of the current node with the discovery time of the destination node and update the lower discovery time of the current node.
    // 7. If destination node is not visited then apply the dsf on the destination node

     public static void getAP(ArrayList<Edge> graph[], int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean vis[] = new boolean[v];
        boolean ap[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time,ap);
            }
        }

        for(int i=0; i<v; i++){
            if(ap[i]){
                System.out.println("AP : " + i);
            }
        }
     }
    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        getAP(graph,v);
    }
}
