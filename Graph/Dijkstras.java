import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras {

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

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;    // ascending
        }
    }

    // Dijkstra's Algorithm (sortest path algorithm)
    // Time Complexity O(E + E*logV)
    // Create Pair class which holds info of node and distance, also create priority queue,distance array and visited array.
    // Assign distance array infinite value.
    // Add pair object in the queue.
    // while queue is not empty remove the node form the queue, marks the node value true in the visited array.
    // Find the neighbours of the current node if the distance the v < distance u + wt then dis[V] = dis[u] + wt.
    // Add the new Pair in the queue with new node and its distance.
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for(int i=0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(-0,0));

        while (!pq.isEmpty()){
            Pair curr = pq.remove(); // sortest path
            if(!vis[curr.node]){
                vis[curr.node] = true;
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<V;i++){
            System.out.print(dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatGraph(graph);
        dijkstra(graph,0,V);
    }
}
