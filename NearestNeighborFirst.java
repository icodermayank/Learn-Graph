// finding the Nearest Neighbor First.. in weighted Undirected Graph in java.

import java.util.*;
public class NearestNeighborFirst {
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

     // creating the function to create graph..
     static void createGraph(ArrayList <Edge> graph [] ){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        // assigning the edges into the graph..
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 10));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 8));

        graph[2].add(new Edge(2, 0, 10));
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 1, 8));
        graph[3].add(new Edge(3, 4, 5));
        graph[3].add(new Edge(3, 5, 11));

        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 5));
        graph[4].add(new Edge(4, 5, 12));

        graph[5].add(new Edge(5, 3, 11));
        graph[5].add(new Edge(5, 4, 12));
        graph[5].add(new Edge(5, 6, 4));
        
        graph[6].add(new Edge(6, 5, 4));
     }


     // function to find the nearest neighbor 

     static void nearestNeighbor(ArrayList <Edge> graph [], int start){
        int nearest = Integer.MAX_VALUE;
        int node =0;
        // Iterate through all the edges of the starting node.
        for(int i =0; i<graph[start].size(); i++){
            Edge e = graph[start].get(i);

             // Check if the current edge has a smaller weight than the previous smallest weight.
            if(nearest  > e.wt){ 
                nearest = e.wt;
                node = e.dest;  
            } 
        }
        System.out.println("Nearest Neighbor of "+start+" is: "+ node);

     }

    public static void main(String args[]){
        int v = 7;
        ArrayList<Edge> graph [] = new ArrayList [v];

        createGraph(graph);

        int start = 4; // starting node.

        nearestNeighbor(graph, start);  // Find the nearest neighbor.
    }
    
}
