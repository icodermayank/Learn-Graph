import java.util.*;

class LearningGraph{
    // creating the class edge.
   static class Edge{
        int src;
        int dest;

        // creating constructor to initilize the value
        Edge(int source, int dest){
            this.src = source; 
            this.dest = dest;
        }

    }


    // creating the method to create graph

    public static void createGraph(ArrayList<Edge> graph []){
    for(int i=0; i<graph.length; i++){
        graph[i] = new ArrayList<Edge>();
    }

    // adding node into the graph array.
    // add function is already defined in the ArrayList class.

    graph[0].add(new Edge(0,2));

    graph[1].add(new Edge(1,2));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,1));
    graph[3].add(new Edge(3,2));

}

    public static void main(String [] args){
        int V = 4;

        // creating the graph array of Arraylist type Edge and size V=4;

        ArrayList<Edge> graph [] = new ArrayList [V];

        createGraph(graph);

        // print the 2's neighbours
        for(int i =0;i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest+" ");
        }
    }
}