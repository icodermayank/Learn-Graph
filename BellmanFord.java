import java.util.*;

public class BellmanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // function to create graph.
    static void createGraph(ArrayList<Edge> graph []){
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();

        }

        //adding edges to the graph.
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }

    // Bellman Ford Algorithm.
    public static void bellmanFord(ArrayList<Edge> graph [], int src, int V){
        int dist [] = new int[V];

        for(int i =0; i<V; i++){
            
            // assigning infinite to all the rest distances till calculated.
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // code for bellman ford 
        for(int k =0; k<V-1; k++){       //Time Complexity - O(v);
            // Time complexity of Below code -  O(E)
            for(int i =0; i<V; i++){
                for(int j =0; j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);


                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+e.wt <dist[v]){
                        dist[v] = dist[u]+e.wt;
                    }
                }
            }
        }

        //print all the distances.
        for(int i =0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    // creating main method.
    public static void main(String [] args){
        int V = 5;
        ArrayList<Edge> graph [] = new ArrayList[V];

        // create the graph.
        createGraph(graph);

        bellmanFord(graph, 0, V);

    }
}
