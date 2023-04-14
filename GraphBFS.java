import java.util.*;
public class GraphBFS {
    // creating the Edge class to define the Edge of the graph.
    static class Edge{
        int src;
        int dest;
        // creating constructor to initilize the data of the edge.
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    // function to create graph is used to create the graph and assign the edge into the graph..

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i<graph.length; i++){
            // assgnining an empty ArrayList to the graph array..
            graph[i] = new ArrayList<Edge>();
        }

        // assigning the edge into the graph..
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }
    
    public static void main(String [] args){
        int v =7;
        ArrayList<Edge> graph [] = new ArrayList[v];
        
        // creating the grpah...
        createGraph(graph);

        

    }
    
}
