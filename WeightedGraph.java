import java.util.*;


public class WeightedGraph {
    // creating the edge class to store the edge information in the graph,
    static class Edge{
        int src; 
        int dest;
        int wt;

        // creating the constructor to initilize the default value to the edge of the grpah,

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // creating the method createGraph to create the graph of Array of ArrayList.

    static void createGraph(ArrayList<Edge> graph []){
        for(int i =0; i<graph.length; i++){
            // assigning the an empty arraylist to the each position of the graph array.
            graph[i] = new ArrayList<Edge> ();
        }

        // now adding edge to the graph..


        
        graph[0].add(new Edge(0,2,6));

        graph[1].add(new Edge(1,2,4 ));
        graph[1].add(new Edge(1, 3,2));

        graph[2].add(new Edge(2,0,9));
        graph[2].add(new Edge(2,1,3));
        graph[2].add(new Edge(2,3,11));

        graph[3].add(new Edge(3,1,7));
        graph[3].add(new Edge(3,2,5));

    }






    public static void main(String [] args){
        int V = 4;

        ArrayList<Edge> graph [] = new ArrayList[V];

        // creating the graph ..
        createGraph(graph);


        // showing the neighbours of the graph with their weight..
        System.out.println("Showing the neighbours of 2 with their weight ");
        for(int i =0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println("("+e.src+")"+"---"+e.wt+"---"+"("+e.dest+")");
        }

    }
}
