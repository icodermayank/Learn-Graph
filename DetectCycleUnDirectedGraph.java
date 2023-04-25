import java.util.*;
public class DetectCycleUnDirectedGraph {
    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;

        }
    }
    static void createGraph(ArrayList<Edge> graph []){
        for(int i =0; i<graph.length; i++){
            graph [i] = new ArrayList<>();
        }
        // adding Edge into the graph.
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,2));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,4));

    }

    static boolean detectCycle(ArrayList<Edge> graph[], boolean vis[], int cur, int parrent){
        vis[cur] = true;

        for(int i =0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);

            // Neighbor is already visited but not parrent so cycle exists.
            if(vis[e.dest] && parrent != e.dest){
            return true;
            }

            // if node is not visited then visit it, if it return true means cycle exists.
            // then return true to the main function.
            // if return false then no action taken.
           else if(!vis[e.dest]){
                if(detectCycle(graph, vis, e.dest, cur)){
                    return true;
                }
            }
        }
        // finally rerturn false to the main function if cycle not exists in the graph.
        return false;
    }

    public static void main(String [] args){
        int v=6;
        ArrayList<Edge> graph [] = new ArrayList[v];

        createGraph(graph);

        System.out.println(detectCycle(graph, new boolean [v], 0, -1));
    }
}
