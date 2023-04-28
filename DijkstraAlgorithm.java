import java.util.*;
class DijkstraAlgorithm{

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
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        // adding node to the graph
    }
    public static void main(String [] args){

        int v =  8;
        ArrayList<Edge> graph [] = new ArrayList[v];

        createGraph(graph);
    }
}