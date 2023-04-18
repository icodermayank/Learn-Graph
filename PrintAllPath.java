// program to Print the all possible path from the source to target in Un-Directed Graph.
import java.util.*;

public class PrintAllPath {
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

    // function to create graph..
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
    

     // function to print all the possible path in Un-Directed graph..
     static void printAllPath(ArrayList<Edge> graph [], boolean vist [], String path, int cur, int tar){
        // for the best case if the source and target became equal..
        if(cur == tar){
            System.out.println(path);
            return;
        }

        // find all their neighbor and trying to find the all possible path..
        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            
        // if there neighbor is not visited then..
            if(vist[e.dest]==false){
                // make cur as visitd to avoid looping..
                vist[cur] = true;
 // recursivly call the function, make path as cur + dest , and cur as dest, and target will be same
                printAllPath(graph, vist, path+e.dest, e.dest, tar);
                // again make cur is unvisited, it means cur may be included in different paths.
                vist[cur]= false;
            }
        }
     }

    public static void main(String [] args){
        int v = 7;
        ArrayList<Edge> graph [] = new ArrayList[v];

        createGraph(graph);
        int cur = 0; 
        int tar = 5; 
        String path = ""+cur; // because path started from current source.
// dynamically passing the boolean array..
        printAllPath(graph, new boolean[v], path, cur, tar );
    }
    
}
